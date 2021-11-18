package com.example.hmrc.mealtrackerboot.archive;

import com.example.hmrc.mealtrackerboot.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderServiceImplement implements OrderRepo{

    private final List<Order> orders = new ArrayList<>();

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Order update(Order order) {
        return order;
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }


    @Override
    public Optional<Order> findById(Long id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst();
    }
}
