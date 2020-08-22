package com.test.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * 不同方法共用一个dataprovider
 */
public class DataProvider2 {

//    @Test(dataProvider = "datas")
    public void getFirst(String a,String b){
        System.out.println(a);
        System.out.println(b);
    }

    @Test(dataProvider = "datas")
    public void getSecond(String a,String b){
        System.out.println(a);
        System.out.println(b);
    }

    @DataProvider(name = "datas")
    public Object[][] datas(Method method){
       Object[][] objects;
        if(method.getName().equals("getFirst")){
            objects = new Object[][] {{"liu","111"},{"yang","222"}};
            return objects;
        }else if(method.getName().equals("getSecond")){
            return new Object[][] {{"he","333"},{"shuag","444"}};
        }
        return  null;
    }

}
