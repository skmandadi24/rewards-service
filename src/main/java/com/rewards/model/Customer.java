package com.rewards.model;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Transaction> transactions;
    @JsonInclude
    @Transient
    private Long rewardPoints;
    @JsonInclude
    @Transient
    private Double totalPurchases;

    public Customer() {
        super();
    }
    public Customer(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
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
    public Set<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }



}
