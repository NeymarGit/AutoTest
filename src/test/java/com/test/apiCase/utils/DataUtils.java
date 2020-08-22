package com.test.apiCase.utils;

import com.test.apiCase.basedata.ApiInfo;
import com.test.apiCase.basedata.CaseInfo;
import com.test.apiCase.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 将API和case关联起来，返回二维数组,供dataprovider用
 */
public class DataUtils {
    public static Object[][] getINfoList(String path, String apiId) {

        ApiInfo api = new ApiInfo();
        // 一个API对应多个Caseinfo，所以加List
        List<CaseInfo> caselist = new ArrayList<CaseInfo>();
        // Excel中获取到的所有API放到List中
        List<ApiInfo> apiInfos = ExcelUtil.excel2Api(path, Constant.SHEET_API, ApiInfo.class);
        // Excel中获取到的所有Case放到List中
        List<CaseInfo> caseInfos = ExcelUtil.excel2Api(path, Constant.SHEET_CASE, CaseInfo.class);

        // 遍历API的list，发现传入的apiId跟LIst中的apiId一致，则取出来
        for (ApiInfo apiInfo : apiInfos) {
            if(apiId.equals(apiInfo.getApiId())){
                api = apiInfo;
            }
        }

        // 遍历case的list，发现传入的apiId跟LIst中的apiId一致，则取出来，放到新的list中
        for (CaseInfo caseInfo : caseInfos) {
            if(apiId.equals(caseInfo.getApiId())){
               caselist.add(caseInfo);
            }
        }

        // 将API对象 和Case对象通过apiId对应起来，放到二维数组中，作为dataProvider数据
        Object[][] datas = new Object[caselist.size()][2];
        for (int i = 0; i < caselist.size(); i++) {
            datas[i][0] = api;
            datas[i][1] = caselist.get(i);
        }
        return datas;
    }


}
