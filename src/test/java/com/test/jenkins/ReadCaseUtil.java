package com.test.jenkins;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读取TestCase数据
 */
public class ReadCaseUtil {

    public static Object[][] readFlie(String path) {
        Object[][] object = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            object = new Object[lastRowNum][2]; //bug:未初始化数组
            for (int i = 1; i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);
                Cell cellUrl = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK); //获取第四列的URL
                object[i - 1][0] = cellUrl.getStringCellValue();
                Cell cellParams = row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK); // 获取第五列的params
                object[i - 1][1] = cellParams.getStringCellValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(fis);
        }
        return object;
    }

    //关闭流资源
    public static void close(InputStream is){
        if(is != null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
