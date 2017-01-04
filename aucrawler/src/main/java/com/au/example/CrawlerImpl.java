package com.au.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * Created by ayhanugurlu on 1/4/17.
 */
public class CrawlerImpl implements ICrawler {



    /**
     * @param url
     */
    public void scan(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Integer size = doc.body().toString().length();
        String title = doc.title();
        String log = url + " === " + size + " === " + title + "\n";

        System.out.println(log);

    }
}