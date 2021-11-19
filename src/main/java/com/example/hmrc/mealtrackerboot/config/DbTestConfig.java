package com.example.hmrc.mealtrackerboot.config;


import java.util.Arrays;

import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.repository.OrderRepo;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;


@Component
public class DbTestConfig implements CommandLineRunner {

	private final OrderRepo orderRepo;

	public DbTestConfig(OrderRepo orderRepo) {
		this.orderRepo = orderRepo;

	}

	@Override
	public void run(String... args) throws Exception {


		var order1 = new Order(1);
		var order2 = new Order(2);
		order1.getMeals().addAll(Arrays.asList("pasta","orange juice"));
		orderRepo.saveAll(Arrays.asList(order1,order2));







	}
}
