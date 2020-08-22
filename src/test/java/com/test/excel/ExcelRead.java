package com.test.excel;

import org.apache.poi.hpsf.MissingSectionException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelRead {
    public static void main(String[] args) throws Exception {
        //1、找到excel
        FileInputStream fis = new FileInputStream("src/test/java/com/test/excel/student.xlsx");

        //2、打开excel
        Workbook workbook = WorkbookFactory.create(fis);

        //3、获取sheet
        Sheet sheet = workbook.getSheet("1月份工资");

//        //4、获取行
//        Row row = sheet.getRow(0);
//
//        //5、获取单元格
//        Cell cellId = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);//如果单元格空则创建一个cell返回,避免空指针
//        cellId.setCellType(CellType.STRING); //设置单元格格式为String
//        System.out.println(cellId.getStringCellValue());
//        Cell cellname = row.getCell(1);
//        System.out.println(cellname.getStringCellValue());
//        Cell cellSalary = row.getCell(2);
//        System.out.println(cellSalary.getStringCellValue());

        //6、取出所有单元格内容
        int lastRowNum = sheet.getLastRowNum(); //获取最大行数
        for (int i = 0; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            short lastCellNum = row.getLastCellNum(); //获取当前行的最后一个单元格
            for (int j = 0; j < lastCellNum; j++) {
                Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);
                String cellValue = cell.getStringCellValue();
                System.out.print(cellValue+",");
            }
            System.out.println();
        }
        fis.close();
    }
}
