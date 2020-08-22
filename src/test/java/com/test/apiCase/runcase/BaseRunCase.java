package com.test.apiCase.runcase;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.test.apiCase.basedata.ApiInfo;
import com.test.apiCase.basedata.AssertJson;
import com.test.apiCase.basedata.CaseInfo;
import com.test.apiCase.basedata.WriteBackContent;
import com.test.apiCase.utils.ExcelUtil;
import com.test.apiCase.utils.HttpUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装调用接口方法 和 添加回写内容到Content中
 */

public class BaseRunCase {
    // log4j日志
    protected Logger log = Logger.getLogger(BaseRunCase.class);

    //调用接口方法
    public String call(ApiInfo apiInfo, CaseInfo caseInfo) {
        String apiurl = apiInfo.getApiUrl();
        String apiMethod = apiInfo.getApiMethod();
        String paraType = apiInfo.getParameType();
        String para = caseInfo.getPara();

        CloseableHttpResponse response = HttpUtil.httpUtils(apiurl, apiMethod, paraType, para);
        try {
            // bug：一个httpclient返回的response只能用一次
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 传入接口响应和 caseinfo中的期望值和断言表达式
    public String assertWay(String response, CaseInfo caseInfo) {
        List<Boolean> flagList = new ArrayList<>();
        try {
            if(caseInfo.getAsserts() == null){
                return null;
            }else {
                // 将Excel中的期望值和断言表达式单元格中内容，转换成java对象 存放到list中
                List<AssertJson> assertJsonList = JSONObject.parseArray(caseInfo.getAsserts(), AssertJson.class);
                for (AssertJson aj : assertJsonList) {
                    // 利用jsonpath获取响应结果中的 实际值
                    Object actualValue = JSONPath.read(response, aj.getExpression());
                    // 比较期望值和实际值
                    boolean flag = aj.getValue().equalsIgnoreCase(actualValue.toString());
                    log.info("期望结果:" + aj.getValue());
                    log.info("实际结果:" + actualValue.toString());
                    log.info(flag);
                    flagList.add(flag);
                }
                return flagList.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 添加需要回写的内容到list中
    public void addWriteBackContent(CaseInfo caseInfo, String cellNum, String response, String flag) {
        // 将需要回写的内容转换成WriteBackContent对象
        WriteBackContent wbc = new WriteBackContent(caseInfo.getCaseId(), cellNum, response, flag);
        // 添加到list中
        ExcelUtil.contentList.add(wbc);
    }

}
