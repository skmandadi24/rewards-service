package com.rewards.controller;

import com.rewards.dao.CustomerDAO;
import com.rewards.model.Customer;
import com.rewards.service.RewardsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertNull;

@SpringBootTest
class RewardsControllerTest {

	@Mock
	private RewardsController rewardsController;

	@Mock
	private RewardsService rewardsService;

	@Mock
	CustomerDAO customerDAO;

	@Test
	void contextLoads() {
		assertThat(rewardsController).isNotNull();
	}

	@Test
	void testGetAllCustomers_notNull() {

		Customer  customer = new Customer(Integer.valueOf(1), "TestUser1");
		customerDAO.save(customer);

		List<Customer> customers = rewardsService.getAllCustomers();

		assertNotNull("Customer cannot be null",customers);
	}

	@Test
	void testAllCustomers_null() {
		Customer customer = null;
		customerDAO.save(customer);

		List<Customer> customers = rewardsService.getAllCustomers();

		assertNull("Null Object",customer);
	}
}
