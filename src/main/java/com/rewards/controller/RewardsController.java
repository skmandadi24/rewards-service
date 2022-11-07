package com.rewards.controller;

import com.rewards.model.Customer;
import com.rewards.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rewards/api/v1")
public class RewardsController {

    @Autowired
    RewardsService rewardsService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {

        return rewardsService.getAllCustomers();
    }
}
