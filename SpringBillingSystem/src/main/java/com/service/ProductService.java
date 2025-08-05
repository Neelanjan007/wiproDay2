package com.service;

import com.bean.Product;
import com.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductDetails(int code) {
        return productDao.getProductDetails(code);
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
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
}
