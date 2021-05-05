package com.coderfocus.myspringboot;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    @Cacheable(cacheNames = "book",key="#isbn")
    public String findBook(String isbn){
        return isbn;
    }
}
