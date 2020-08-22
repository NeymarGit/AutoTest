package com.test.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class PostHttpClient {
    public static void main(String[] args) throws Exception{

    PostHttpClient.httpPost("http://localhost:8080/jenkins/securityRealm/createAccount","");

    }

    public static void httpPost(String url,String parameter){
        try {
            //1.创建发送请求的客户端
            CloseableHttpClient client = HttpClients.createDefault();

            //2、创建request请求,添加请求头
            HttpPost post = new HttpPost(url);
//            post.addHeader("X-Lemonban-Media-Type","lemonban.v1");
//            post.addHeader("Content-Type","application/json");  //bug:"Content-Type"是中划线“-”
             post.addHeader("Content-Type","application/x-www-form-urlencoded");  //表单格式
            //2.1、加入post参数到请求体中
//            StringEntity se = new StringEntity("{\"username\":+\"yu\",+\"password1\":+\"123456\",+\"password2\":+\"123456\",+\"fullname\":+\"yu\",+\"Jenkins-Crumb\":+\"454b707ba6275be3d9893dbfce248494\"}");
            StringEntity se = new StringEntity("username=yu2&password1=123456&password2=123456&fullname=yu2&Jenkins-Crumb=454b707ba6275be3d9893dbfce248494&json=%7B%22username%22%3A+%22yu%22%2C+%22password1%22%3A+%22123456%22%2C+%22password2%22%3A+%22123456%22%2C+%22fullname%22%3A+%22yu%22%2C+%22Jenkins-Crumb%22%3A+%22454b707ba6275be3d9893dbfce248494%22%7D&Submit=%E6%B3%A8%E5%86%8C");
            post.setEntity(se);
            //3、客户端发送get请求,返回response
//            HttpHost proxy = new HttpHost("localhost",8888);//设置代理
//            CloseableHttpResponse response = client.execute(proxy,post);
            CloseableHttpResponse response = client.execute(post);

            //4、获取响应信息
            Header[] headers = response.getAllHeaders(); //所有响应头
            int code = response.getStatusLine().getStatusCode();//响应状态码
            HttpEntity entity = response.getEntity(); // 响应体
            String str = EntityUtils.toString(entity); //格式化响应体

            System.out.println("header:"+headers);
            System.out.println("statuscode:"+code);
            System.out.println("entity:"+str);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
