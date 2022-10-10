package com.boot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.boot.demo.service.TradeBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @DATE 2019/11/4 20:33
 * @Description 测试请求类
 * @Author Tian Daguang
 **/
@RestController
@RequestMapping("provider")
@Slf4j
public class DemoController {

    @Resource
    private TradeBillService tradeBillService;


    @GetMapping(path = "send/{id}")
    public String send(@PathVariable Long id) throws Exception {
        log.info("可以用了！！！");
        return JSON.toJSONString(tradeBillService.getById(id));
    }


    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

}
