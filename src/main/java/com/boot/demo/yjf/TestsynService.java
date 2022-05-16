package com.boot.demo.yjf;

import com.yiji.openapi.tool.YijifuGateway;
import com.yiji.openapi.tool.YijipayConstants;
import com.yiji.openapi.tool.util.Ids;

import java.util.HashMap;
import java.util.Map;

public class TestsynService {
    private static String partnerId = "2014*************750";
    private static String key = "55013b3352*************b24ed4303";
    private static String url = "https://openapi.yijifu.net/gateway.html";

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(YijipayConstants.ORDER_NO, Ids.oid());
        map.put(YijipayConstants.PARTNER_ID, partnerId);
        map.put("service", "bankNoQuery");
        map.put("bankId", "CCB");
        map.put("districtName", "宁波市");
        // 同步请求
        try {
            //集成了签名和验签
            String responseStr = YijifuGateway.getOpenApiClientService().doPost(url,map, key);
            System.out.println("响应报文:" + responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}