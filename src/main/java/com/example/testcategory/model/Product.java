package com.example.testcategory.model;

public class Product {
    private int id;
    private String name;
    private int price;

    CategoryDetail categoryDetail_id;

    public Product() {

    }

    public Product(int id, String name, int price, CategoryDetail categoryDetail_id) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryDetail_id = categoryDetail_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CategoryDetail getCategoryDetail_id() {
        return categoryDetail_id;
    }

    public void setCategoryDetail_id(CategoryDetail categoryDetail_id) {
        this.categoryDetail_id = categoryDetail_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryDetail_id=" + categoryDetail_id +
                '}';
    }
}
