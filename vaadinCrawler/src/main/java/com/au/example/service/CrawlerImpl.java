package com.au.example.service;

import java.io.IOException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;


/**
 * Created by ayhanugurlu on 1/4/17.
 */
@Service
public class CrawlerImpl implements ICrawler {



    /**
     * @param url
     */
    @Async
    public Future<Boolean> scan(String url) {
        Boolean result =  false;
    	 try {

             Connection connection = Jsoup.connect(url); // connect url with jsoup

             Document doc = connection.get();   //download document from connection
             Elements linksOnPage = doc.select("a[href]"); //get links in document 

             
             
             
             /*add each url to the list*/

             for (Element link : linksOnPage) {

                 String hrefStr = link.absUrl("href");
                 if (!hrefStr.isEmpty()) {
                     System.out.println(hrefStr);
                 }
             }

    	  } catch (IOException ex) {
              ex.printStackTrace();
          }
        return new AsyncResult<>(result);

    }
}