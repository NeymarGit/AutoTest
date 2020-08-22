package com.test.excel;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWrite {
    public static void main(String[]args)throws Exception{

        //1.找到excel
        FileInputStream fis=new FileInputStream("src/test/java/com/test/excel/student.xlsx");
        //2.打开excel
        Workbook workbook=WorkbookFactory.create(fis);

        //3.获取sheet
        Sheet sheet=workbook.getSheet("2月份工资");

        //4.获取单元格
        Row row = sheet.getRow(2);
        if(row == null){ //做非空判断，防止空指针
            row = sheet.createRow(2);
        }
        Cell cell = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

        //5.修改值
        cell.setCellValue("1502");

        //6.输出流写出到Excel
        FileOutputStream fos = new FileOutputStream("src/test/java/com/test/excel/student.xlsx");
        workbook.write(fos); //输出流

        fis.close();
        fos.close();
    }
}
