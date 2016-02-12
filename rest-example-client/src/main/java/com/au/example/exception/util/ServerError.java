package com.au.example.exception.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.WebApplicationException;

public class ServerError {

	private WebApplicationException rootException = null;
	private String[] exceptionClasses = new String[] {};
	private PossibleCause[] possibleCauses = new PossibleCause[] {};
	private String[] errorMessages = new String[] {};

	public ServerError(WebApplicationException webApplicationException) {
		this.rootException = webApplicationException;
		if (webApplicationException.getResponse().getHeaders().containsKey("ErrorMessage")) {
			this.errorMessages = webApplicationException.getResponse().getHeaderString("ErrorMessage").split("\\|");
		}
		if (webApplicationException.getResponse().getHeaders().containsKey("ExceptionClasses")) {
			this.exceptionClasses = webApplicationException.getResponse().getHeaderString("ExceptionClasses").split("\\|");
		}
		if (webApplicationException.getResponse().getHeaders().containsKey("PossibleCauses")) {
			this.possibleCauses = parseCauses(webApplicationException.getResponse().getHeaderString("PossibleCauses").split(";"));
		}
	}

	private PossibleCause[] parseCauses(String[] possibleCauses) {
		List<PossibleCause> possibleCauseList = new ArrayList<>();
		for (String possibleCauseParts : possibleCauses) {
			String[] causeParts = possibleCauseParts.split("\\|");
			try {
				possibleCauseList.add(new PossibleCause(causeParts[0], causeParts[1], causeParts[2], causeParts[3]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return possibleCauseList.toArray(new PossibleCause[possibleCauseList.size()]);
	}

	public String[] getExceptionClasses() {
		return exceptionClasses;
	}

	public PossibleCause[] getPossibleCauses() {
		return possibleCauses;
	}

	public String[] getErrorMessages() {
		return errorMessages;
	}

	@SuppressWarnings("unchecked")
	public WebApplicationException getRootException() {
		if (rootException instanceof WebApplicationException && exceptionClasses.length > 0) {

			String rootExceptionClassName = exceptionClasses[exceptionClasses.length - 1];

			Class<? extends Exception> clazz;
			try {
				clazz = (Class<? extends Exception>) Class.forName(rootExceptionClassName);

				if (Exception.class.isAssignableFrom(clazz)) {
					Constructor<?> constructor = null;

					constructor = clazz.getConstructor(String.class);
					String messages = "";
					for (String message : getErrorMessages()) {
						messages += message + ", ";
					}
					rootException = (WebApplicationException) constructor.newInstance(messages);

					// ignore this exception, we will raise another if we cannot
					// find the default constructor

					if (constructor == null) {
						constructor = clazz.getConstructor();
						rootException = (WebApplicationException) constructor.newInstance();
					}
				} 

			} catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return rootException;
	}

	@Override
	public String toString() {
		return "ERROR " + (Arrays.toString(exceptionClasses)) + " " + (Arrays.toString(errorMessages)) + Arrays.toString(possibleCauses);
	}

	public class PossibleCause {

		private final String className;
		private final String fileName;
		private final String methodName;
		private final String lineNumber;

		public PossibleCause(String className, String fileName, String methodName, String lineNumber) {

			this.className = className;
			this.fileName = fileName;
			this.methodName = methodName;
			this.lineNumber = lineNumber;
		}

		public String getClassName() {
			return className;
		}

		public String getFileName() {
			return fileName;
		}

		public String getMethodName() {
			return methodName;
		}

		public String getLineNumber() {
			return lineNumber;
		}

		@Override
		public String toString() {
			return "\n\t" + "at " + className + "." + methodName + "(" + fileName + ":" + lineNumber + ")";
		}
	}
}