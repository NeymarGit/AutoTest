package com.test.xml;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Analysisxml {
    public static void main(String[] args) throws Exception {
        //1、添加dom4j依赖,创建SAXReader对象
        SAXReader saxReader = new SAXReader();
        //2、加载xml文件
        FileInputStream fileInputStream = new FileInputStream("src/test/java/com/test/xml/Outbound.xml");
        //3、获取document对象,整个xml
        Document document = saxReader.read(fileInputStream);

        //4、获取根节点
        Element rootElement = document.getRootElement();
        //5、获取子节点
        List<Element> persons = rootElement.elements();
        for (Element ele : persons) {
            List<Element> person = ele.elements();
            //获取孙节点
            for (Element ele1 : person) {
                String name = ele1.getName();
                Object data = ele1.getData();
                System.out.println("节点名称:" + name + ",节点值:" + data);
                //获取节点的属性
                Attribute attribute = ele1.attribute("id");
                if (null != attribute) {
                    System.out.println("节点属性名称:" + attribute.getName() + "，节点属性值:" + attribute.getData());
                }
            }
            //获取节点的属性
            Attribute attribute = ele.attribute("id");
            if (null != attribute) {
                System.out.println("节点属性名称：" + attribute.getName() + "节点属性值" + attribute.getData());
            }
        }
        fileInputStream.close();

    }
}
