package com.au.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MainClass {

	private static String ARTIFACTORY_URL = "http://10.0.1.5:8081/artifactory/lib-release-obs-cli";

	public static void main(String[] args) {

		if (args.length > 2) {
			ARTIFACTORY_URL = args[1];
		}
		

		String inputPath = args[0];
		File inputFile = new File(inputPath);

		for (String jarname : inputFile.list()) {
			String jarFilePath = inputPath + "/" + jarname;
			File tempFile = new File(jarFilePath);
			HashMap<String, String> map = new HashMap<String, String>();
			String extension = getExtension(jarFilePath);
			

			if (tempFile.isFile() && extension != null && extension.equals("jar")) {
				try {
					map = getGroupIdArtifactId(jarFilePath);

					String command = "mvn  deploy:deploy-file -Dfile=" + jarFilePath + " -Durl=" + ARTIFACTORY_URL + " -DgroupId="
							+ map.get("groupId") + " -DartifactId=" + map.get("artifactId") + " -Dversion=" + map.get("version");

					System.out.println(executeCommand(command));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		// createObfProperties("/DevelopmentEnvironment/obfuscation/projects/" +
		// "srv-ear.pro");

	}

	private static void createObfProperties(String obfFilePath) {

		BufferedReader reader = null;
		PrintWriter pw = null;
		try {

			pw = new PrintWriter(obfFilePath + "tmp");

			File file = new File(obfFilePath);
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {

				if (line.contains("-injars") || line.contains("-libraryjars")) {
					String newLine = "";
					String jarFolder = line.substring(line.indexOf(' '), line.lastIndexOf('/')).trim();
					String jarName = line.substring(line.lastIndexOf('/') + 1);
					File jarFile = new File(jarFolder);
					for (String realjarName : jarFile.list()) {
						if (jarName.contains("-")
								&& (jarName.substring(0, jarName.lastIndexOf('-')).equals(realjarName.substring(0, realjarName.lastIndexOf('-'))))) {
							// System.out.println(realjarName.substring(realjarName.lastIndexOf('-')+1,realjarName.length()-4));
							newLine = jarFolder + "/" + realjarName;
							break;
						}
					}
					if (line.contains("-injars")) {
						newLine = "-injars " + newLine;
					} else if (line.contains("-libraryjars")) {
						newLine = "-libraryjars " + newLine;
					}
					System.out.println(newLine);
					pw.println(newLine);

				} else {
					System.out.println(line);
					pw.println(line);

				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	private static String getExtension(String fileName) {

		String extension = "";

		int i = fileName.lastIndexOf('.');
		int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

		if (i > p) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}

	private static String executeCommand(String command) {

		System.out.println(command);
		StringBuffer output = new StringBuffer();
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

	public static HashMap<String, String> getGroupIdArtifactId(String jarFile) throws IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		ZipInputStream zis = new ZipInputStream(new FileInputStream(jarFile));
		ZipEntry ze = zis.getNextEntry();
		while (ze != null) {
			if (ze.getName().contains("pom.xml")) {
				byte[] bytePom = new byte[1024];
				zis.read(bytePom);
				String s = new String(bytePom);
				if(s.contains("<build>")){
					s = s.substring(0, s.indexOf("<build>"));	
				}
				if(s.contains("<dependencies>")){
					s = s.substring(0, s.indexOf("<dependencies>"));	
				}
				

				int groupStartId = s.indexOf("<groupId>");
				int groupEndId = s.indexOf("</groupId>");
				String groupId = s.substring(groupStartId + 9, groupEndId);
				map.put("groupId", groupId);

				int artifactStartId = s.lastIndexOf("<artifactId>");
				int artifactEndId = s.lastIndexOf("</artifactId>");

				String artifactId = s.substring(artifactStartId + 12, artifactEndId);
				map.put("artifactId", artifactId);

				int versionStart = s.lastIndexOf("<version>");
				int versionEnd = s.lastIndexOf("</version>");
				String version = s.substring(versionStart + 9, versionEnd);
				map.put("version", version);
			}

			ze = zis.getNextEntry();
		}
		zis.closeEntry();
		zis.close();
		return map;
	}

}
