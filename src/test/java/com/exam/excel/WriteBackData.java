package com.exam.excel;

public class WriteBackData {
    private int rowNum;
    private int cellNum;
    private String content;

    public WriteBackData(int rowNum, int cellNum, String content) {
        this.rowNum = rowNum;
        this.cellNum = cellNum;
        this.content = content;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public void setCellNum(int cellNum) {
        this.cellNum = cellNum;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getCellNum() {
        return cellNum;
    }

    public String getContent() {
        return content;
    }
}
