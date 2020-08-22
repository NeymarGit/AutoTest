package com.test.jenkins;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * ÷¥––∂‡Ãıcase
 */
public class JenkinsRegist {

    @Test(dataProvider = "datas")
    public void regist(String url,String param) throws Exception{
        CloseableHttpResponse response = PostRequest.postRequest(url, param);
        System.out.println(response.getStatusLine());
        String str = EntityUtils.toString(response.getEntity());
        System.out.println(str);
    }

    @DataProvider(name = "datas")
    public Object[][] datas(){
        Object[][] datas = ReadCaseUtil.readFlie("src/test/resources/jenkins/jenkins.xlsx");
        return datas;
    }

}
