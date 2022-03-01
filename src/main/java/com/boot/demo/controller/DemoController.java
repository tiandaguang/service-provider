package com.boot.demo.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @DATE 2019/11/4 20:33
 * @Description 测试请求类
 * @Author Tian Daguang
 **/
@RestController
@RequestMapping("demo")
@Slf4j
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;


//    @Autowired
//    private EtcMonitorMessageService monitorMessageHandlerImpl;

//    @PostMapping("send")
//    public String send(@RequestBody MonitorMessageRequest request) throws Exception {
//        Consumer<MonitorMessageRequest> f5 = new Consumer<MonitorMessageRequest>() {
//            @Override
//            public void accept(MonitorMessageRequest request) {
//                String content = request.getContent();
//                content = content.concat("-->").concat(com.etc.utils.DateUtil.getDateTimeFormat(new Date()));
//                request.setContent(content);
//            }
//        };
//
//        f5.accept(request);
//        return JSON.toJSONString(monitorMessageHandlerImpl.sendMessage(request));
//    }
//
//    @PostMapping("rest")
//    public String rest(@RequestBody MonitorMessageRequest request) throws Exception {
//        log.info("send%%%%%%%%%%%%%%%%%>request:{}", request.toString());
//        HttpHeaders httpHeaders = restTemplate.headForHeaders("http://localhost:8080/demo/to");
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        JsonResponse rr = restTemplate.postForObject("http://localhost:8080/demo/to", request, JsonResponse.class);
//        return JSON.toJSONString(rr);
//    }
//
//    @PostMapping("to")
//    public JsonResponse to(@RequestBody MonitorMessageRequest request) throws Exception {
//        return JsonResponse.fail("接收rest请求成功");
//    }

    @PostMapping("send")
    public String send() throws Exception {
        log.info("可以用了！！！");
        Map<String, Object> mp = new HashMap<>();
        mp.put("code", 100);
        return JSON.toJSONString(mp);
    }
}
