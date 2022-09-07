package com.boot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.boot.demo.core.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
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
@RefreshScope
public class DemoController {
    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @NacosValue(value = "${name:tdg}", autoRefreshed = true)
    private String name;

    @Autowired
    private RestTemplate restTemplate;
    private static String key = "55013b3352*************b24ed4303";

//    @Value("${yijipay.partnerId}")
//    private String partnerId;

//    @Resource
//    private JyfPro jyfPro;

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

    @PostMapping(path = "send", produces = MediaType.APPLICATION_JSON_VALUE)
    public String send(@Valid @RequestBody User user, BindingResult result) throws Exception {
        log.info("hasErrors=={}", result.getAllErrors());

        for (ObjectError error : result.getAllErrors()) {
            log.info("ssss:{}", error.getDefaultMessage());
        }
        log.info("可以用了！！！---useLocalCache:{}", useLocalCache);
        Map<String, Object> mp = new HashMap<>();
        mp.put("code", name);
//        Teacher teacher = Teacher.builder()
//                .name("tianda").build();
//        mp.put("Teacher", teacher);

//        log.info("partnerId==:{}", partnerId);
//        log.info("partnerId=222=:{}", jyfPro.getPartnerId());

//        //字符串请求签名
//        String waitSignStr = "agegit=28&name=wck";
//        String strSign = YijifuGateway.getOpenApiClientService().sign(waitSignStr, key);
//        System.out.println("字符串签名:" + strSign);
//        return JSONObject.toJSONString(mp);
        return JSON.toJSONString(mp);
    }


    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

}
