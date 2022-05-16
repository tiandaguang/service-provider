package com.boot.demo.yjf;

import com.yiji.openapi.tool.YijifuGateway;
import com.yiji.openapi.tool.YijipayConstants;
import com.yiji.openapi.tool.util.Ids;

import java.util.HashMap;
import java.util.Map;

public class TestSynServiceRedirect {
    private static String partnerId = "2014*************750";
    private static String key = "55013b3352*************b24ed4303";
    private static String url = "https://openapi.yijifu.net/gateway.html";

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(YijipayConstants.PARTNER_ID, partnerId);
        map.put(YijipayConstants.ORDER_NO, Ids.oid());
        map.put("service", "mpayResetLoginPasswordRedirect");
        map.put("outOrderNo", "outNo20160526173456");
        map.put("userId", "20160*************90322");
        map.put(YijipayConstants.RETURN_URL,
            "http://*************:8080/returnView.html");
        map.put(YijipayConstants.NOTIFY_URL,
            "http://*************:8080/testNotify.html");
        // 跳转请求
        try {
            //集成了签名
            String redirectUrl = YijifuGateway.getOpenApiClientService().redirect(url, map, key);
            System.out.println("跳转地址:" + redirectUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}