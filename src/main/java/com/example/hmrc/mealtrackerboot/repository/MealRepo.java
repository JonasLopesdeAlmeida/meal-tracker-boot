package com.example.hmrc.mealtrackerboot.repository;


import com.example.hmrc.mealtrackerboot.model.Meal;
import com.example.hmrc.mealtrackerboot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepo extends JpaRepository<Meal, Long> {


}
