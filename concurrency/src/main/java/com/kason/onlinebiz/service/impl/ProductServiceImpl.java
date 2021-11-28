package com.kason.onlinebiz.service.impl;

import com.kason.onlinebiz.dataobject.ProductInfo;
import com.kason.onlinebiz.enums.ProducrStatusEnum;
import com.kason.onlinebiz.repository.ProductInfoRepository;
import com.kason.onlinebiz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoRepository productInfoRepository;
    @Override
    public ProductInfo findOne(String productId) {

        Optional<ProductInfo> byId = productInfoRepository.findById(productId);
        return byId.orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProducrStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {

        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo onSale(String productId) {
        return null;
    }

    @Override
    public ProductInfo offSale(String productId) {
        return null;
    }
}
