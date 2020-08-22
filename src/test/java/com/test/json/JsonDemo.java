package com.test.json;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java对象和json字符串转换
 */
public class JsonDemo {
    public static void main(String[] args) {
        //json字符串转换为对象
        String str = "{name : \"liuyanghe\",age : \"18\",high : \"1.78\"}";
        Student stu = JSONObject.parseObject(str, Student.class);
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getHigh());

        //对象转换为json字符串
        Student s1 = new Student("wushaugn",16,1.60);
        String json = JSONObject.toJSONString(s1);
        System.out.println(json);

        //map转json字符串
        Map<String , String > map = new HashMap<String, String>();
        map.put("name","liu");
        map.put("age","18");
        map.put("high","1.99");
        String json1 = JSONObject.toJSONString(map);
        System.out.println(json1);



        //json字符串转换为List,Lsit里面放对象
        String str1 = "[{name : \"阳\",age : \"11\",high : \"1.18\"},{name : \"和\",age : \"12\",high : \"1.28\"}]";
        List<Student> list = JSONObject.parseArray(str1, Student.class);
        for (Student s:list){
            System.out.println(s.getName());
            System.out.println(s.getAge());
            System.out.println(s.getHigh());
        }
        System.out.println(list);
    }
}
