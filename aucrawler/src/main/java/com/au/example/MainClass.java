package com.au.example;

import com.au.example.com.au.example.executer.CrawlerExecuter;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.Queue;

/**
 * Created by ayhanugurlu on 1/4/17.
 */
public class MainClass {

    public static void main(String[] args) {



        Config cfg = new Config();
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);




        Queue q = instance.getQueue("crawler_url");
        q.offer("http://docs.hazelcast.org/docs/3.5/manual/html/queue.html");
        ICrawler crawler = new CrawlerImpl(instance);

        CrawlerExecuter crawlerExecuter = new CrawlerExecuter(crawler);

        crawlerExecuter.run();







    }


}
