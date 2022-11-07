package com.rewards.dao;

import com.rewards.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
