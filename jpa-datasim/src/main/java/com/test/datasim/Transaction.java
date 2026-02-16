package com.test.datasim;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="cust_id", referencedColumnName = "id")
    private Customer custId;
    @ManyToOne
    @JoinColumn(name="prod_id", referencedColumnName = "id")
    private Product prodId;
    private Date purchaseTime;
    private Integer quantity;

    public Transaction(){}

    public Transaction(Customer custId, Product prodId, Date purchaseTime, Integer quantity) {
        this.custId = custId;
        this.prodId = prodId;
        this.purchaseTime = purchaseTime;
        this.quantity = quantity;
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

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
