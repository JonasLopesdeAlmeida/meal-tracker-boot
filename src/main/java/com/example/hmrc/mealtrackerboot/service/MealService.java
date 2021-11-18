package com.example.hmrc.mealtrackerboot.service;

import com.example.hmrc.mealtrackerboot.enums.OrdersStatus;
import com.example.hmrc.mealtrackerboot.excption.BusinessNegotiationException;
import com.example.hmrc.mealtrackerboot.model.Meal;
import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.repository.MealRepo;
import com.example.hmrc.mealtrackerboot.repository.OrderRepo;
import com.example.hmrc.mealtrackerboot.validation.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Component
public class MealService {

    private final MealRepo repo;

    public MealService(MealRepo repo) {
        this.repo = repo;
    }


    public Meal addNewOrder(Meal meal) {

            return repo.save(meal);

    }


    public void updateOrder(Meal meal) {
        Objects.requireNonNull(meal.getId());
        repo.save(meal);
    }


    public Page<Meal> findAll(Pageable pageable) {
        Page<Meal> pages = repo.findAll(pageable);
        return pages;
    }


    public Optional<Meal> findById(Long id) {

        return repo.findById(id);
    }
}
