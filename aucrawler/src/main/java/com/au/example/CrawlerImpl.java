package com.au.example;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.google.common.net.HttpHeaders;
import com.hazelcast.core.HazelcastInstance;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by ayhanugurlu on 1/4/17.
 */
public class CrawlerImpl implements ICrawler {

    private HazelcastInstance instance;

    public HazelcastInstance getHazelcast() {
        return instance;
    }

    public CrawlerImpl(HazelcastInstance instance) {
        this.instance = instance;
    }

    /**
     * @param url
     */
    public void scan() {
        Map<String, String> crawlerUrl = instance.getMap("exec_url");
        Queue q = instance.getQueue("crawler_url");
        String url = (String) q.poll();



        try {


            Connection connection = Jsoup.connect(url).userAgent(HttpHeaders.USER_AGENT);
            Document htmlDocument = connection.get();

            System.out.println("Received web page at " + url);

            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            for (Element link : linksOnPage) {
                String temp = url = link.absUrl("href");
                if (!crawlerUrl.containsKey(temp)) {
                    q.offer(temp);
                    crawlerUrl.put(temp, "url");
                    System.out.println(temp);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}