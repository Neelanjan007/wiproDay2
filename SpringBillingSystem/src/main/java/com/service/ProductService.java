package com.service;

import java.util.List;

import com.bean.Product;
import com.dao.ProductDao;

public class ProductService {

    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product getProductDetails(int code) {
        return productDao.getProductDetails(code);
    }

    public double calculatePrice(int qty, double price) {
        return qty * price;
    }

    public boolean validateProductCode(int code) {
        return code > 0 && String.valueOf(code).length() == 4;
    }

    public boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
    
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

}
