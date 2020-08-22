package com.test.dataprovider;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 测试testng利用xml文件参数化
 */
public class testLiu {

    @Test
    @Parameters(value = {"type","version"})
    public void test(String type,String version){
        System.out.println("测试开始");
        System.out.println(type);
        System.out.println(version);

    }


}
