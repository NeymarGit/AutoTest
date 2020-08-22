package com.test.apiCase.constant;

/**
 * 常量类
 */
public class Constant {
    // Excel的地址
    public static final String EXCEL_PATH = "src/test/resources/apiCase/apiCase.xlsx";

    // Excel中的sheet页
    public static final int SHEET_API  = 0;
    public static final int SHEET_CASE  = 1;

    // caseinfo中的API_ID
    public static final String JENKINS_REGISTE = "1";
    public static final String WATER_QUALITY = "2";
    public static final String JENKINS_LOGIN = "3";
    public static final String JENKINS_BUILD = "4";
    public static final String ZUOWEN = "5";


    // 回写内容到Excel中的列号
    public static final String EXCEL_CELL_RESPONSE = "6";

    // 回写断言结果的列号
    public static final String EXCEL_CELL_ASSERT = "7";

    //数据库连接信息
    public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/mysql01?serverTimezone=UTC&characterEncoding=utf-8";
    public static final String MYSQL_USER_NAME = "root";
    public static final String MYSQL_PASSWORD = "root1234";



}
