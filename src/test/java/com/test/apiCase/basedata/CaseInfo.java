package com.test.apiCase.basedata;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.validation.constraints.NotNull;

/**
 * 接口用例信息类
 */

public class CaseInfo {
    @Excel(name = "用例编号")
    @NotNull
    private String caseId;

    @Excel(name = "用例描述")
    @NotNull
    private String caseDec;

    @Excel(name = "接口参数")
    @NotNull
    private String para;

    @Excel(name = "接口编号")
    @NotNull
    private String apiId;

    @Excel(name = "期望值和断言表达式")
    @NotNull
    private String asserts;

    public CaseInfo(String caseId, String caseDec, String para, String apiId, String asserts) {
        this.caseId = caseId;
        this.caseDec = caseDec;
        this.para = para;
        this.apiId = apiId;
        this.asserts = asserts;
    }

    public CaseInfo() {
    }


    public String getAsserts() {
        return asserts;
    }

    public void setAsserts(String asserts) {
        this.asserts = asserts;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseDec() {
        return caseDec;
    }

    public void setCaseDec(String caseDec) {
        this.caseDec = caseDec;
    }

    @Override
    public String toString() {
        return "CaseInfo{" +
                "caseId='" + caseId + '\'' +
                ", caseDec='" + caseDec + '\'' +
                ", para='" + para + '\'' +
                ", apiId='" + apiId + '\'' +
                '}';
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }
}
