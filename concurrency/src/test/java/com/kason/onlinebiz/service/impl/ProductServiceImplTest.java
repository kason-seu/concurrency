package com.kason.onlinebiz.service.impl;

import com.kason.onlinebiz.dataobject.ProductInfo;
import com.kason.onlinebiz.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    void findOne() {

        ProductInfo one = productService.findOne("123456");

        System.out.println(one);


    }

    @Test
    void findUpAll() {

        List<ProductInfo> upAll = productService.findUpAll();

        upAll.stream().forEach(System.out::println);


    }

    @Test
    void findAll() {
        PageRequest pageRequest = PageRequest.of(0,2);

        Page<ProductInfo> all = productService.findAll(pageRequest);

        System.out.println(all.getTotalElements());
    }

    @Test
    void save() {
        ProductInfo one = productService.findOne("123456");
        one.setProductName("南瓜粥");
        productService.save(one);

    }

    @Test
    void onSale() {
    }

    @Test
    void offSale() {
    }
}