package com.boot.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.demo.entity.TradeBill;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 对账文件表 Mapper 接口
 * </p>
 *
 * @author ***
 * @since 2022-10-10
 */
@Mapper
public interface TradeBillMapper extends BaseMapper<TradeBill> {

}
