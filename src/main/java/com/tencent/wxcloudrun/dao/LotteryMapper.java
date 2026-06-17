package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Lottery_en;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LotteryMapper {
    void insert(@Param("name") String name, @Param("item") String item);

    Lottery_en select(@Param("name")String name);
}
