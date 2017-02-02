package com.au.example.service;

import java.util.concurrent.Future;

/**
 * Created by ayhanugurlu on 1/4/17.
 */
public interface ICrawler {
	Future<Boolean> scan(String url);
}