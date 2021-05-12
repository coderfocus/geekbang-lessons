package com.coderfocus.myspringboot.mybatis.service;

import com.coderfocus.myspringboot.mybatis.entity.Item;
import com.coderfocus.myspringboot.mybatis.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> selectItem(){
        return itemMapper.selectItem();
    }

}
