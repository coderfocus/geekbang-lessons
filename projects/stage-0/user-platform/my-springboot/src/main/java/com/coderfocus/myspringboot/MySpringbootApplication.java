package com.coderfocus.myspringboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.coderfocus.myspringboot.cache.BookService;
import com.coderfocus.myspringboot.mybatis.EnableMyBatis;
import com.coderfocus.myspringboot.mybatis.entity.Item;
import com.coderfocus.myspringboot.mybatis.interceptor.QueryPlugin;
import com.coderfocus.myspringboot.mybatis.service.ItemService;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
@EnableMyBatis(dataSource = "dataSource",
        configLocation = "classpath:mybatis/mybatis-config.xml",
        mapperLocations = {"classpath:mybatis/mappers/*.xml"},
        environment = "development",
        plugins = "plugins")
@MapperScan("com.coderfocus.myspringboot.mybatis.mapper")
public class MySpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringbootApplication.class, args);
    }


    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        return datasource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public Interceptor[] plugins(){
        List<Interceptor> pluginList = new ArrayList<>();
        pluginList.add(new QueryPlugin());
        pluginList.add(new QueryPlugin());
        return pluginList.toArray(new Interceptor[0]);
    }

    @Bean
    public Interceptor queryPlugin(){
        return new QueryPlugin();
    }

    @Autowired
    private BookService bookService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/selectItem")
    public List<Item> selectItem(){
        return itemService.selectItem();
    }

    @GetMapping("/findBook")
    public String findBook(String isbn){
        return bookService.findBook(isbn);
    }

    @GetMapping("/findBook1")
    public String findBook1(String isbn){
        return bookService.findBook1(isbn);
    }

    @GetMapping("/findBook2")
    public String findBook2(String isbn){
        return bookService.findBook2(isbn);
    }

}
