package com.au.example.com.au.example.executer;

import com.au.example.CrawlerImpl;
import com.au.example.ICrawler;
import com.au.example.com.au.example.model.ScanningUrl;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

/**
 * Created by ayhanugurlu on 1/5/17.
 */
public class CrawlerExecuter implements Runnable {

    private ICrawler crawler;



    public  CrawlerExecuter(ICrawler crawler){
        this.crawler = crawler;
    }

    public void run() {

        crawler.scan();

    }

}
