package com.example.testcategory.main;

import com.example.testcategory.dao.CategoryDAO;
import com.example.testcategory.dao.ProductDAO;

public class Test {
    public static void main(String[] args) {


        CategoryDAO.getInstance().searchByCategory("A").forEach(System.out::println);

//        Test searchByCategoryDetail
//        CategoryDetailDao.getInstance().searchByCategoryDeTailName("s").forEach(System.out::println);

//        Test searchByProduct
//        ProductDAO.getInstance().search("Iphone").forEach(System.out::println);

//        Test searchByPrice

    }
}