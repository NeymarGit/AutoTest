package com.test.jenkins;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Post请求
 */

public class PostRequest {
    public static CloseableHttpResponse postRequest(String url,String param){
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-Type","application/x-www-form-urlencoded");
            post.setEntity(new StringEntity(param)); //bug:参数填成url

            response = client.execute(post);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }
}
