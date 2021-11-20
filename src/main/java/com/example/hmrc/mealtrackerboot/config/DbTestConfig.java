package com.example.hmrc.mealtrackerboot.config;


import java.util.Arrays;

import com.example.hmrc.mealtrackerboot.enums.UserRole;
import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.model.User;
import com.example.hmrc.mealtrackerboot.repository.OrderRepo;

import com.example.hmrc.mealtrackerboot.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DbTestConfig implements CommandLineRunner {

	private OrderRepo orderRepo;
	private UserRepo userRepo;
	private PasswordEncoder passwordEncoder;

	public DbTestConfig(OrderRepo orderRepo, UserRepo userRepo, PasswordEncoder passwordEncoder) {
		this.orderRepo = orderRepo;
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void run(String... args) throws Exception {


		var order1 = new Order(1);
		var order2 = new Order(2);
		order1.getMeals().addAll(Arrays.asList("pasta","orange juice"));
		order2.getMeals().addAll(Arrays.asList("pizza","feijoada"));
		orderRepo.saveAll(Arrays.asList(order1,order2));

		var user1 = new User("jonas", passwordEncoder.encode("teste1"), UserRole.USER);
		var user2 = new User("daniel", passwordEncoder.encode("teste2"), UserRole.ADMIN);
		userRepo.saveAll(Arrays.asList(user1,user2));







	}
}
