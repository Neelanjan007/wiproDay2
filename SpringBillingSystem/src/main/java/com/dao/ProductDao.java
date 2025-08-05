package com.dao;

import java.util.List;

import com.bean.Product;

public interface ProductDao {
    Product getProductDetails(int product_code);
    
    List<Product> getAllProducts();

}
