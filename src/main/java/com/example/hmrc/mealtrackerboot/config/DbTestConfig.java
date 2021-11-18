package com.example.hmrc.mealtrackerboot.config;


import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.example.hmrc.mealtrackerboot.model.Meal;
import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.repository.MealRepo;
import com.example.hmrc.mealtrackerboot.repository.OrderRepo;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
public class DbTestConfig implements CommandLineRunner {

	private final OrderRepo orderRepo;

	private final MealRepo mealRepo;

	public DbTestConfig(OrderRepo orderRepo, MealRepo mealRepo) {
		this.orderRepo = orderRepo;
		this.mealRepo = mealRepo;
	}

	@Override
	public void run(String... args) throws Exception {

		var order1 = new Order(1);
		var order2 = new Order(2);
		orderRepo.saveAll(Arrays.asList(order1,order2));

		var meal1 = new Meal("pasta", order1);
		var meal2 = new Meal("pizza", order1);
		mealRepo.saveAll(Arrays.asList(meal1,meal2));

		order1.getMeals().addAll(Arrays.asList(meal1,meal2));

	}
}
