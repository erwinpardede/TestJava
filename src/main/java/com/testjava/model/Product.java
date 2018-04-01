package com.testjava.model;

/**
 * Created by erwin on 3/30/18.
 */
public class Product {

    private Integer id;
    private String name;
    private String description;
    private Category category;
    private Integer stock;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, String description, Category category, Integer stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
