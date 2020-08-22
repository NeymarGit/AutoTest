package com.test.apiCase.utils;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.test.apiCase.constant.Constant;
import com.test.apiCase.basedata.WriteBackContent;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 1。将Excel读取出来，映射成java对象
 * 传入excel地址，sheet页，类信息，返回这个类对应对象的List
 * <p>
 * 2。将返回的信息回写到Excel
 */

public class ExcelUtil {
    // 存储回写的内容到list，便于批量回写，提高效率
    public static List<WriteBackContent> contentList = new ArrayList<WriteBackContent>();

    // 取出excel中的数据转换成java对象
    public static <T> List<T> excel2Api(String path, int sheetIndex, Class<T> clazz) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            //导入参数对象（默认值：取且只取第一个sheet，表头只取第一行）
            ImportParams params = new ImportParams();
            params.setStartSheetIndex(sheetIndex);
            // params.setNeedVerfiy(true); // 非空校验
            // 解析excel封装成List对象
            List<T> list = ExcelImportUtil.importExcel(fis, clazz, params);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(fis);
        }
        return null;
    }

    //回写response到Excel
    public static void writeBack(String path) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1、找到excel
            fis = new FileInputStream(path);
            //2、打开excel
            Workbook workbook = WorkbookFactory.create(fis);
            //3、获取sheet
            Sheet sheet = workbook.getSheetAt(Constant.SHEET_CASE);
            //4、获取单元格
            // 遍历contentList中的数据,获取到行号，列号和内容
            for (WriteBackContent wbc : contentList) {
                Row row = sheet.getRow(Integer.parseInt(wbc.getCaseId()));
                if (row == null) { //做非空判断，防止空指针
                    row = sheet.createRow(Integer.parseInt(wbc.getCaseId()));
                }
                // 获取回写返回内容的列
                Cell cell1 = row.getCell(Integer.parseInt(wbc.getCellResponseNum()), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                // 获取回写断言结果的列
                Cell cell2 = row.getCell(Integer.parseInt(wbc.getCellResponseNum())+1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                //5、修改值
                cell1.setCellValue(wbc.getContent());
                cell2.setCellValue(wbc.getFlag());

            }
            //6、输出流写出到Excel
            fos = new FileOutputStream(path);
            workbook.write(fos); //输出流

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(fis);
            close(fos);
        }
    }

    // 关闭IO流
    public static void close(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}
