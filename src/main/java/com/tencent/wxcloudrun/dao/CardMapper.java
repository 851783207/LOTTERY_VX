package com.tencent.wxcloudrun.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.tencent.wxcloudrun.model.Card;

import java.util.List;
@Mapper
public interface CardMapper {
    int changeStatus(@Param("name") String name);
    List<Card> getAll();

    Card select(@Param("id")String id);
}
