package com.kason.onlinebiz.service;


import com.kason.onlinebiz.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    // 分页查询
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存


    //减库存


    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);
}
