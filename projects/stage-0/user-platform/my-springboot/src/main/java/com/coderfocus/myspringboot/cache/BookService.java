package com.coderfocus.myspringboot.cache;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface BookService {
    String findBook(String isbn);

    @Cacheable(cacheNames = "book1",key="#isbn")
    String findBook1(String isbn);

    @Cacheable(cacheNames = "book2",key="#isbn")
    @CachePut(cacheNames = "book2",key="#isbn")
    String findBook2(String isbn);
}
