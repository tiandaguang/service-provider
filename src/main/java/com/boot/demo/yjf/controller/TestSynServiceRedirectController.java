package com.boot.demo.yjf.controller;

import com.yiji.openapi.tool.YijifuGateway;
import com.yiji.openapi.tool.YijipayConstants;
import com.yiji.openapi.tool.util.Ids;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("redirectController")
@Slf4j
public class TestSynServiceRedirectController {


    private static String partnerId = "2014*************750";
    private static String key = "55013b3352*************b24ed4303";
    private static String url = "https://openapi.yijifu.net/gateway.html";

    @PostMapping("demo")
    public void demo() {
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

        map = new HashMap<String, String>();
        map.put(YijipayConstants.ORDER_NO, Ids.oid());
        map.put(YijipayConstants.PARTNER_ID, partnerId);
        map.put("service", "bankNoQuery");
        map.put("bankId", "CCB");
        map.put("districtName", "宁波市");
        // 同步请求
        try {
            //集成了签名和验签
            String responseStr = YijifuGateway.getOpenApiClientService().doPost(url, map, key);
            log.info("响应报文:{}", responseStr);
        } catch (Exception e) {
            log.error("bankNoQuery error:", e);
        }
    }
}
