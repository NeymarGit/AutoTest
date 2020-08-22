package com.test.apiCase.runcase;

import com.test.apiCase.basedata.ApiInfo;
import com.test.apiCase.basedata.CaseInfo;
import com.test.apiCase.constant.Constant;
import com.test.apiCase.utils.DataUtils;
import com.test.apiCase.utils.ExcelUtil;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class RunJenkinsRegist extends BaseRunCase {

    @Test(dataProvider = "datas")
    public void run(ApiInfo apiInfo, CaseInfo caseInfo){
        String response = call(apiInfo, caseInfo);
        log.info("--------·µ»ØÄÚÈÝ--------" + response);
        String way = assertWay(response, caseInfo);
        addWriteBackContent(caseInfo, Constant.EXCEL_CELL_RESPONSE,response,way);
    }

    @AfterSuite
    public void finish(){
        ExcelUtil.writeBack(Constant.EXCEL_PATH);
    }

    @DataProvider(name = "datas")
    public Object[][] getDatas(){
        Object[][] datas = DataUtils.getINfoList(Constant.EXCEL_PATH, Constant.JENKINS_REGISTE);
        return datas;
    }
        
}
