/*
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2016年6月29日 下午5:22:54 创建
 */
package com.boot.demo.yjf.controller;

import com.alibaba.fastjson.JSON;
import com.yiji.openapi.message.common.deposit.DeductApplyRequest;
import com.yiji.openapi.message.common.deposit.DeductApplyResponse;
import com.yiji.openapi.sdk.YijiPayClient;
import com.yiji.openapi.sdk.common.enums.ApiServiceResultCode;
import com.yiji.openapi.sdk.common.utils.Money;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * @author zhike@yiji.com
 * @data   2016年6月29日
 */
@RestController
@RequestMapping("deductApplyService")
public class TestDeductApplyServiceController {
	@Resource
	private YijiPayClient yijiPayClient;

	public YijiPayClient getYijiPayClient() {
		return yijiPayClient;
	}

	public void setYijiPayClient(YijiPayClient yijiPayClient) {
		this.yijiPayClient = yijiPayClient;
	}
	/**
	 * 调用接口业务逻辑处理
	 * @param getRequest
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/view")
	public void view(HttpServletRequest getRequest, HttpServletResponse response) throws IOException {
		DeductApplyRequest request = new DeductApplyRequest();
		request.setUserId("20140411020055684571");
		request.setSignType("MD5");
		request.setAmount(Money.amout("310"));
		request.setBindId("000q00m01g5r9j6hlo00");
		request.setReturnUrl("https://www.baidu.com");
//		request.setNotifyUrl(ApiSdkConstants.NOTIFY_URL);
		//请求
		DeductApplyResponse deductApplyResponse = yijiPayClient.request(request);
		if(StringUtils.equals(deductApplyResponse.getResultCode(), ApiServiceResultCode.PROCESSING.getCode())||
				StringUtils.equals(deductApplyResponse.getResultCode(), ApiServiceResultCode.SUCCESS.getCode())		) {
			//TODO,业务处理成功，进行业务逻辑处理
		}else {
			//TODO,业务处理失败，进行业务逻辑处理
		}
		System.out.println("[deductApplyService]响应报文："+ JSON.toJSONString(deductApplyResponse));
	}
}

    