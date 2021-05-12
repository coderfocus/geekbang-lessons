package com.coderfocus.myspringboot.mybatis.service;

import com.coderfocus.myspringboot.mybatis.entity.Item;
import com.coderfocus.myspringboot.mybatis.mapper.ItemMapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface ItemService {

    List<Item> selectItem();

}
