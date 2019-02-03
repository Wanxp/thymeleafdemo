package com.wanxp.thymeleafdemo.repository;

import com.wanxp.thymeleafdemo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository  {

    private static ProductRepository productRepository;

    private ProductRepository() {

    }

    public ProductRepository getIntance() {
        if (productRepository == null) {
            synchronized (productRepository) {
                if (productRepository == null)
                    productRepository = new ProductRepository();
            }
        }
        return productRepository;
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        return null;
    }


}
