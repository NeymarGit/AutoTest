package com.test.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetHttpClient {
    public static void main(String[] args) throws Exception{

        //1.创建发送请求的客户端
        CloseableHttpClient client = HttpClients.createDefault();

        //2、创建request请求,添加请求头
        HttpGet get = new HttpGet("http://api.lemonban.com/futureloan/loans");
        get.addHeader("X-Lemonban-Media-Type","lemonban.v1");

        //3、客户端发送get请求,返回response
        CloseableHttpResponse response = client.execute(get);

        //4、获取响应信息
        Header[] headers = response.getAllHeaders(); //所有响应头
        int code = response.getStatusLine().getStatusCode();//响应状态码
        HttpEntity entity = response.getEntity(); // 响应体
        String str = EntityUtils.toString(entity); //格式化响应体

        System.out.println("header:"+headers);
        System.out.println("statuscode:"+code);
        System.out.println("entity:"+entity);


    }
}
