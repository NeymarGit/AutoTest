package com.test.dataprovider;

import org.testng.annotations.Test;

public class DataProvider {

    @Test(dataProvider = "datas")
    public void  login(String uname,String pwd){
        System.out.println("µÇÂ¼½Ó¿Ú");
        System.out.println(uname);
        System.out.println(pwd);
    }

    @org.testng.annotations.DataProvider(name = "datas")
    public Object[][] datas(){
        Object[][] datas = {{"liu","123123"},{"yang","456456"},{"he","789789"}};
        return datas;

    }

}
