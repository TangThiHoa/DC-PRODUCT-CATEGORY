package com.example.testcategory.dao;

import com.example.testcategory.db.JDBCUtil;
import com.example.testcategory.model.CategoryDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDetailDao {
    private static CategoryDetailDao instance = new CategoryDetailDao();

    public static CategoryDetailDao getInstance() {
        return instance;
    }

    private CategoryDAO categoryDAO = CategoryDAO.getInstance();

    private CategoryDetailDao() {
    }

    public CategoryDetail selectById(int categoryDetailId) {
        CategoryDetail categoryDetail = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM categorydetail WHERE category_id = ?";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                categoryDetail = new CategoryDetail(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryDetail;
    }

    public int insert(CategoryDetail categoryDetail) {
        int id = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO categorydetail (name) VALUES ('" + categoryDetail.getName() + "')";
            statement.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            connection.close();
            System.out.println("Insert successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public int update(CategoryDetail categoryDetail) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "UPDATE category_detail SET name = '" + categoryDetail.getName() + "' WHERE category_id = '" + categoryDetail.getCategory_id() + "'";
            result = statement.executeUpdate(sql);
            connection.close();
            System.out.println("Update successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(CategoryDetail categoryDetail) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM categorydetail WHERE category_id = '" + categoryDetail.getId() + "'";
            result = statement.executeUpdate(sql);
            connection.close();
            System.out.println("Delete successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<CategoryDetail> selectAll() {
        List<CategoryDetail> categoryDetails = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM category_detail";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                CategoryDetail categoryDetail = new CategoryDetail(id, name);
                categoryDetails.add(categoryDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryDetails;
    }

    public List<CategoryDetail> selectByCondition(String condition) {
        List<CategoryDetail> categoryDetails = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM categorydetail WHERE " + condition;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                CategoryDetail categoryDetail = new CategoryDetail(id, name);
                categoryDetails.add(categoryDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryDetails;
    }

    public List<CategoryDetail> searchByCategoryDeTailName(String name) {
        List<CategoryDetail> categoryDetails = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM categorydetail WHERE name LIKE '%" + name + "%'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("categoryDetailId");
                String cate = resultSet.getString("name");
                CategoryDetail categoryDetail = new CategoryDetail(id, cate);
                categoryDetails.add(categoryDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryDetails;
    }
}
