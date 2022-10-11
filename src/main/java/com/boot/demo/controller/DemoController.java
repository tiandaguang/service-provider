package com.boot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.boot.demo.entity.TradeBill;
import com.boot.demo.service.TradeBillService;
import com.boot.demo.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;


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
        return JSON.toJSONString(tradeBillService.list());
    }


    @GetMapping(path = "add")
    public void send() throws Exception {
        log.info("可以用了！！！");
        TradeBill bill = new TradeBill();
        bill.setBusDate("2022-06-30");
        bill.setId(RandomUtils.nextLong(1L, 100L));
        bill.setMerchantNo(UUIDUtil.generate());
        bill.setTradeAmounts(new BigDecimal("10.11"));
        bill.setCreateTime(new Date());
        tradeBillService.saveOrUpdate(bill);
    }


    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

}
