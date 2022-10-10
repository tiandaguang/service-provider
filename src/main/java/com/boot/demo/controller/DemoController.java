package com.boot.demo.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//import com.boot.demo.stream.function.Teacher;

/**
 * @DATE 2019/11/4 20:33
 * @Description 测试请求类
 * @Author Tian Daguang
 **/
@RestController
@RequestMapping("provider")
@Slf4j
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;
    private static String key = "55013b3352*************b24ed4303";

    @GetMapping(path = "send")
    public String send() throws Exception {

        log.info("可以用了！！！");
        Map<String, Object> mp = new HashMap<>();
        mp.put("code", "tdg");

        return JSON.toJSONString(mp);
    }


    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

}
