package com.example.testcategory.dao;

import com.example.testcategory.model.Product;

import java.util.List;

public class ProductDAO implements DAOInterface<Product> {

    public static ProductDAO getInstance() {
        return new ProductDAO();
    }

    private CategoryDetailDao categoryDetailDao = CategoryDetailDao.getInstance();

    @Override
    public int insert(Product product) {
        return 0;
    }

    @Override
    public int update(Product product) {
        return 0;
    }

    @Override
    public int delete(Product product) {
        return 0;
    }

    @Override
    public List<Product> selectAll() {
        return null;
    }

    @Override
    public Product selectById(Product product) {
        return null;
    }

    @Override
    public List<Product> selectByCondition(String condition) {
        return null;
    }
}
