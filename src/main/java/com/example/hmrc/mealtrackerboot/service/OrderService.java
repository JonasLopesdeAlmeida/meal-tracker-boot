package com.example.hmrc.mealtrackerboot.service;

import com.example.hmrc.mealtrackerboot.enums.OrdersStatus;
import com.example.hmrc.mealtrackerboot.excption.BusinessNegotiationException;
import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.repository.OrderRepo;
import com.example.hmrc.mealtrackerboot.validation.OrderValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
//@Transactional
public class OrderService {

    private OrderRepo repo;
    private OrderValidator validator;

    public OrderService(OrderRepo repo, OrderValidator validator) {
        this.repo = repo;
        this.validator = validator;
    }


    public Order addNewOrder(Order order) {
        if(validator.isValid(order)) {
            return repo.save(order);
        }else {
            throw new BusinessNegotiationException("Sorry!! no more tables available!");
        }
    }


    public void updateOrder(Order order) {
        Objects.requireNonNull(order.getId());
        repo.save(order);
    }


    public Page<Order> findAll(Pageable pageable) {
        Page<Order> pages = repo.findAll(pageable);
        return pages;
    }


    public Optional<Order> findById(Long id) {

        return repo.findById(id);
    }


}