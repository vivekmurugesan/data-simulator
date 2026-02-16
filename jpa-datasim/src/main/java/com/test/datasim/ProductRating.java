package com.test.datasim;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class ProductRating {

    public enum Rating {one, two, three, four, five};

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="cust_id", referencedColumnName = "id")
    private Customer custId;
    @ManyToOne
    @JoinColumn(name="prod_id", referencedColumnName = "id")
    private Product prodId;
    private Date ratingTime;
    @Enumerated(EnumType.ORDINAL)
    private Rating rating;

    public ProductRating(){}

    public ProductRating(Customer custId, Product prodId, Date ratingTime, Rating rating) {
        this.custId = custId;
        this.prodId = prodId;
        this.ratingTime = ratingTime;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
    }

    public Product getProdId() {
        return prodId;
    }

    public void setProdId(Product prodId) {
        this.prodId = prodId;
    }

    public Date getRatingTime() {
        return ratingTime;
    }

    public void setRatingTime(Date ratingTime) {
        this.ratingTime = ratingTime;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
