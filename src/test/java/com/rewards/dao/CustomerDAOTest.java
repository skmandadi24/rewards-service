package com.rewards.dao;

import com.rewards.model.Customer;
import com.rewards.model.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerDAOTest {

    @Autowired
    CustomerDAO customerDAO;

    @Test
    void test_createCustomer() {

        Customer  customer = new Customer(1, "TestUser1");

        Transaction transaction = new Transaction(1L, customer, 101.10, "Test Transaction",new Date());
        Set<Transaction> transactionSet = new HashSet<>();
        transactionSet.add(transaction);

        customer.setTransactions(transactionSet);

        customerDAO.save(customer);

        assertThat(customerDAO.findById(1)).isNotNull();
    }
    @Test
    void test_findAll() {
        List<Customer> customerList = customerDAO.findAll();
        assertThat(customerList).isNotNull();
    }
}
