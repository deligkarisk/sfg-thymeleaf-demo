package com.deligkarisk.sfgthymeleafdemo.services;

import com.deligkarisk.sfgthymeleafdemo.domain.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(Integer id);

    List<Product> listProducts();
}