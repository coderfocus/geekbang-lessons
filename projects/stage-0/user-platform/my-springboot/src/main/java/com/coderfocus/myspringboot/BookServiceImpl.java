package com.coderfocus.myspringboot;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BookServiceImpl implements BookService{

    @Override
    @Cacheable(cacheNames = "book",key="#isbn")
    public String findBook(String isbn){
        return isbn;
    }

    @Override
    @Cacheable(cacheNames = "book1Cacheable",key="#isbn")
    @CachePut(cacheNames = "book1CachePut",key="#isbn")
    public String findBook1(String isbn) {
        return null;
    }

    @Override
    public String findBook2(String isbn) {
        return null;
    }


}
