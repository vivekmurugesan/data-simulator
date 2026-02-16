package com.test.datasim;

import jakarta.persistence.*;

@Entity
public class Product {

    public enum ProductCategory {electroinc("electronic"), book("book"), apparel("apparel");
        private final String value;

        ProductCategory(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }

        public String toString(){
            return value;
        }
    };

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private String name;
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public Product(){}

    public Product(ProductCategory category, String name, Integer price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

}
