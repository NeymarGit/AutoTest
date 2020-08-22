package com.test.apiCase.basedata;

/**
 * 断言表达式单元格内容的映射
 */
public class AssertJson {
    // 期望值
    private String value;
    // 断言表达式
    private String expression;

    public AssertJson(String value, String expression) {
        this.value = value;
        this.expression = expression;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
