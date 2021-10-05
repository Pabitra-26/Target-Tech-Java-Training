package com.target.training.model;

public class Product {

    private int id;
    private String name;
    private String description;
    private Double prices;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", prices=" + prices +
                '}';
    }
}
