package com.boot.demo.yjf.test;

import com.boot.demo.stream.function.Teacher;
import com.yiji.openapi.tool.YijifuGateway;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class TestSign {
    private static String key = "55013b3352*************b24ed4303";
    public static void main(String[] args) {
        //字符串请求签名
        String waitSignStr = "age=28&name=wck";
        String strSign = YijifuGateway.getOpenApiClientService().sign(waitSignStr, key);
        System.out.println("字符串签名："+strSign);

        //list请求签名
        List<String> listStr = new ArrayList<String>();
        listStr.add("age=28");
        listStr.add("name=wck");
        String listSign = YijifuGateway.getOpenApiClientService().sign(listStr, key);
        System.out.println("list签名："+listSign);

        //map请求签名
        Map<String,String> mapStr = new HashMap<String,String>();
        mapStr.put("age", "28");
        mapStr.put("name", "wck");
        String mapSign = YijifuGateway.getOpenApiClientService().sign(mapStr, key);
        System.out.println("map签名："+mapSign);

        //对象请求签名
        Teacher te = Teacher.builder().name("tianda").build();

        String objectSign = YijifuGateway.getOpenApiClientService().sign(te, key);
       log.info("对象签名:{}", objectSign);
    }
}