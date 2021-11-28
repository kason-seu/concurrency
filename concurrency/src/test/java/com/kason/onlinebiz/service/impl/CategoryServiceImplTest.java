package com.kason.onlinebiz.service.impl;

import com.kason.onlinebiz.dataobject.ProductCategory;
import com.kason.onlinebiz.service.CategoryService;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;
    @Test
    void findOne() {
        ProductCategory one = categoryService.findOne(2);

        System.out.println(one);
        Assert.assertTrue(one != null);
    }

    @Test
    void findAll() {

        List<ProductCategory> all = categoryService.findAll();

        all.stream().forEach(System.out::println);

    }

    @Test
    void findByCategoryTypeIn() {
        List<Integer> categoryIds = Lists.newArrayList(4);
        List<ProductCategory> byCategoryTypeIn = categoryService.findByCategoryTypeIn(categoryIds);

        byCategoryTypeIn.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        ProductCategory one = categoryService.findOne(2);

        one.setCategoryName("男女都爱");

        categoryService.save(one);
    }
}