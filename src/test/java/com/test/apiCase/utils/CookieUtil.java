package com.test.apiCase.utils;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取Cookie及给给请求头添加cookie
 */

public class CookieUtil {
    // 环境变量
    private static Map<String,String> cookieMap = new HashMap<String,String>();


    // 保存获取到的cookie
    public static void setCookie(CloseableHttpResponse response){
        // 从返回信息中获取Cookie
        Header[] cookies = response.getHeaders("Set-Cookie");
        if(cookies.length != 0){
            for(Header cookie : cookies){
                // 截取需要的cookie
                String value = cookie.getValue().substring(0,43);
                cookieMap.put("cookie",value);
            }
        }
    }

    // 添加cookie到请求头中
    public  static void addCookie(HttpRequestBase request){
        if(cookieMap.size() != 0){
            String cookie = cookieMap.get("cookie");
            request.addHeader("Cookie",cookie);
        }
    }

}
