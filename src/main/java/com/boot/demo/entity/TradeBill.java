package com.boot.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 对账文件表
 * </p>
 *
 * @author ***
 * @since 2022-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("trade_bill")
public class TradeBill implements Serializable {


    private static final long serialVersionUID = -5626752318032889074L;
    /**
     * 商户编号
     */
    private Long id;
    /**
     * 商户编号
     */
    private String merchantNo;

    /**
     * 业务日期
     */
    private String busDate;

    /**
     * 交易笔数
     */
    private String tradeCount;

    /**
     * 支付总金额
     */
    private BigDecimal tradeAmounts;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 0有效1无效
     */
    private Integer isValiate;

    /**
     * 修改人员ID
     */
    private String operUserId;

    /**
     * 修改人员姓名
     */
    private String operUserName;


}
