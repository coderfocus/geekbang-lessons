package com.coderfocus.myspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MySpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringbootApplication.class, args);
    }


    @Autowired
    private BookService bookServiceImpl;


    @GetMapping("/findBook")
    public String findBook(String isbn){
        return bookServiceImpl.findBook(isbn);
    }

    @GetMapping("/findBook1")
    public String findBook1(String isbn){
        return bookServiceImpl.findBook1(isbn);
    }

    @GetMapping("/findBook2")
    public String findBook2(String isbn){
        return bookServiceImpl.findBook2(isbn);
    }

}
