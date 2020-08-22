package com.exam.list;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class Json2List {
    public static void main(String[] args) throws Exception {
        String str1 = "[{\"value\":0,\"expression\":\"$.code\"},{\"value\":\"OK\",\"expression\":\"$.msg\"},{\"value\":\"OK\",\"expression\":\"OK\"}]";
//        String str2 = "[{\"value\":0,\"expression\":\"$.code\"},{\"value\":\"OK\",\"expression\":\"$.msg\"},{\"value\":\"OK\",\"expression\":\"OK\"}]";
        json2List(str1);
//        json2List(str2);

    }

    public static void json2List(String str) throws Exception {
//        JSONArray jsonArray = JSONArray.parseArray(str); //String转JSONArray
//        String JSONStr = JSON.toJSONString(jsonArray); //JSONArray转String

        //json字符串转List<JsonValidate>
//        List<JsonValidate> list = JSON.parseObject(str, new TypeReference<List<JsonValidate>>() {}); //
        List<JsonValidate> list =  JSONObject.parseArray(str,JsonValidate.class);
        for (JsonValidate jv : list) {
            System.out.println(jv.getValue());
            System.out.println(jv.getExpression());
            if(jv.getValue().equals(jv.getExpression())){
                System.out.println("pass");
            }else {
                System.out.println("fail");
            }
        }

    }
}