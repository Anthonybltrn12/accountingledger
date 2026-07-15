package com.yearup.SkillsSprint_accountingledger.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transactionId")
    private Integer transactionId;

    private String description;

    private String vendor;

    private Integer amount;

    @Column(name = "category_id")
    private Integer categoryId;

    @CreationTimestamp
    private LocalDateTime date;

    public Transaction(){

    }
    public Transaction(Integer transactionId, String description, String vendor, Integer amount,Integer categoryId, LocalDateTime date) {
        this.transactionId = transactionId;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.categoryId = categoryId;
        this.date = date;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = LocalDateTime.now();
    }
}
