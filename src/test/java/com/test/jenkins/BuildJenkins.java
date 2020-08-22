package com.test.jenkins;

import com.test.apiCase.utils.CookieUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class BuildJenkins {
    public static void main(String[] args) throws IOException {
        CloseableHttpResponse response = postRequestForm("http://localhost:8080/jenkins/j_acegi_security_check","j_username=yanghe&j_password=123456&from=%2Fjenkins%2F&Jenkins-Crumb=454b707ba6275be3d9893dbfce248494&json=%7B%22j_username%22%3A+%22yanghe%22%2C+%22j_password%22%3A+%22123456%22%2C+%22remember_me%22%3A+false%2C+%22from%22%3A+%22%2Fjenkins%2F%22%2C+%22Jenkins-Crumb%22%3A+%22454b707ba6275be3d9893dbfce248494%22%7D&Submit=%E7%99%BB%E5%BD%95");
        CookieUtil.setCookie(response);
//        CloseableHttpResponse response = postRequestForm("http://localhost:8080/jenkins/view/all/createItem", "name=toms01&mode=hudson.model.FreeStyleProject&from=&Jenkins-Crumb=e6b935a82b209b28f7b3fda202edefbe&json=%7B%22name%22%3A+%22toms02%22%2C+%22mode%22%3A+%22hudson.model.FreeStyleProject%22%2C+%22from%22%3A+%22%22%2C+%22Jenkins-Crumb%22%3A+%22e6b935a82b209b28f7b3fda202edefbe%22%7D");
        CloseableHttpResponse response1 = postRequestForm("http://localhost:8080/jenkins/job/toms02/build","delay=0sec");


        String s1 = EntityUtils.toString(response1.getEntity());
        System.out.println(response1.getStatusLine());
        System.out.println(s1);

    }

    public static CloseableHttpResponse postRequestForm(String url, String param){
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-Type","application/x-www-form-urlencoded");
            post.addHeader("Jenkins-Crumb","e6b935a82b209b28f7b3fda202edefbe");
            CookieUtil.addCookie(post);
            post.setEntity(new StringEntity(param));

            response = client.execute(post);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }

}
