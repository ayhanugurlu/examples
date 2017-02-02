package com.au.example;

import com.hazelcast.core.HazelcastInstance;

/**
 * Created by ayhanugurlu on 1/4/17.
 */
public interface ICrawler {
    void scan();
    HazelcastInstance getHazelcast();
}
