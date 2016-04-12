package com.helper.finance.client.service;

import java.io.IOException;

/**
 * Created by dvas on 12.04.2016.
 */
public interface ApacheHelper {
    String performPostRequest(String url, String jsonRequest) throws IOException;
    String performGetRequest(String url) throws IOException;
}
