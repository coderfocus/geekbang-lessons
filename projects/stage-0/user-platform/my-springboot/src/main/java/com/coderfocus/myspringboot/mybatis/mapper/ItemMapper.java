package com.coderfocus.myspringboot.mybatis.mapper;

import com.coderfocus.myspringboot.mybatis.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<Item> selectItem();
}
