package com.rewards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Transaction extends Rewards {
    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn //foreign key to customer
    private Customer customer;
    private Double total;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tranDate;

    public Transaction(Long id, Customer customer, Double total, String description, Date date) {
        super();
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.description = description;
        this.tranDate = date;
    }

    public Date getTranDate() {
        return tranDate;
    }
    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Long getPoints() {
        this.points = 0l;

        if (this.total > 50 && this.total <= 100) {
            this.points += (this.total.intValue() - 50);

        }

        if (this.total > 100) {
            this.points += 50;
            this.points += (this.total.intValue() - 100) * 2L;
        }

        return this.points;
    }

    @Override
    public String toString() {
        return String.format("MyTransaction [id=%s, customer=%s, total=%s, description=%s, saveDate=%s]", id, customer,
                total, description, tranDate);
    }

}
