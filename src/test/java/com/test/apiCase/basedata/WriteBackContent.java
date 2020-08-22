package com.test.apiCase.basedata;

/**
 * 用于存储回写内容
 */
public class WriteBackContent {
    // 要回写的行
    private String caseId;
    // 要回写返回结果的列
    private String cellResponseNum;
    // 要回写的内容
    private String content;
    //断言结果
    private String flag;

    public WriteBackContent(String caseId, String cellNum, String content, String flag) {
        this.caseId = caseId;
        this.cellResponseNum = cellNum;
        this.content = content;
        this.flag = flag;
    }


    public WriteBackContent() {
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCellResponseNum() {
        return cellResponseNum;
    }

    public void setCellResponseNum(String cellResponseNum) {
        this.cellResponseNum = cellResponseNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
