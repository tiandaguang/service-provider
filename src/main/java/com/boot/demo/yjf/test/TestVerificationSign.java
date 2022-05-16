package com.boot.demo.yjf.test;

import com.yiji.openapi.tool.YijifuGateway;

public class TestVerificationSign {
    private static String key = "55013b3352*************b24ed4303";

    public static void main(String[] args) {
        String waitSignStr = "age=28&name=wck&signType=MD5";
        String strSign = YijifuGateway.getOpenApiClientService().sign(waitSignStr, key);
        System.out.println("签名结果:" + strSign);
        String responseStr = "{\"signType\":\"MD5\",\"age\":\"28\",\"name\":\"wck\",\"sign\":\"" + strSign + "\"}";
        boolean isPass = YijifuGateway.getOpenApiClientService().verificationSign(responseStr, key);
        System.out.println("验签结果：" + isPass);
    }
}