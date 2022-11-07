package com.rewards.service;

import com.rewards.dao.CustomerDAO;
import com.rewards.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardsService {

    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> getAllCustomers() {

        return customerDAO.findAll();
    }
}
