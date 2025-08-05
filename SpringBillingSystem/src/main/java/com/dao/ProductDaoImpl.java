package com.dao;

import com.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Product getProductDetails(int product_code) {
        String sql = "SELECT * FROM product WHERE product_code = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product p = new Product();
                p.setProduct_code(rs.getInt("product_code"));
                p.setProduct_name(rs.getString("product_name"));
                p.setProduct_category(rs.getString("product_category"));
                p.setProduct_description(rs.getString("product_description"));
                p.setProduct_price(rs.getDouble("product_price"));
                return p;
            }
        }, product_code);
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product p = new Product();
            p.setProduct_code(rs.getInt("product_code"));
            p.setProduct_name(rs.getString("product_name"));
            p.setProduct_category(rs.getString("product_category"));
            p.setProduct_description(rs.getString("product_description"));
            p.setProduct_price(rs.getDouble("product_price"));
            return p;
        });
    }
}
