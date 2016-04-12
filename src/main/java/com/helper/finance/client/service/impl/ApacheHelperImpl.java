package com.helper.finance.client.service.impl;

import com.helper.finance.client.service.ApacheHelper;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by dvas on 12.04.2016.
 */
@Service
public class ApacheHelperImpl implements ApacheHelper {

    @Override
    public String performPostRequest(String url, String jsonRequest) throws IOException {

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        httpPost.setEntity(new StringEntity(jsonRequest));
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpPost);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

        StringBuilder sb = new StringBuilder();

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }

        closeableHttpClient.close();

        return sb.toString();
    }

    @Override
    public String performGetRequest(String url) throws IOException {
        return null;
    }
}
