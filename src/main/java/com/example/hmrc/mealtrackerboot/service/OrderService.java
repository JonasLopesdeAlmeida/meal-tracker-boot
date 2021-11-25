package com.example.hmrc.mealtrackerboot.service;

import com.example.hmrc.mealtrackerboot.enums.OrdersStatus;
import com.example.hmrc.mealtrackerboot.excption.BusinessNegotiationException;
import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.repository.OrderRepo;
import com.example.hmrc.mealtrackerboot.service.port.OrderServicePort;
import com.example.hmrc.mealtrackerboot.validation.OrderValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@Transactional
public class OrderService implements OrderServicePort {

    private OrderRepo repo;
    private OrderValidator validator;

    public OrderService(OrderRepo repo, OrderValidator validator) {
        this.repo = repo;
        this.validator = validator;
    }


    public Order addNewOrder(Order order) {
        if(validator.isValid(order)) {
//            order.setStatus(OrdersStatus.NOT_STARTED);
//            order.setDateAndTime(LocalDateTime.now());
            return repo.save(order);
        }else {
            throw new BusinessNegotiationException("Sorry!! no more tables available!");
        }
    }

    public void updateOrder(Order order) {
        Objects.requireNonNull(order.getId());
        if(validator.isValid(order)) {
            repo.save(order);
        }else {
            throw new BusinessNegotiationException("Sorry!! order not updated!");
        }

    }

    public Page<Order> findAllOrders(Pageable pageable) {
        Page<Order> pages = repo.findAll(pageable);
        return pages;
    }

    public Optional<Order> findOneOrderById(Long id) {
        Optional<Order> order = repo.findById(id);
        if(order.isPresent()){
            return order;
        }else{
            return Optional.empty();
        }
    }

    public List<Order> findOrderByStatus(OrdersStatus status){
        return repo.findByStatus(status);
    }

    public void deleteOrder(Order id) {
        repo.delete(id);
    }

    public List<Order> findAllCurrentOrder() {
        return repo.findByStatusNot(OrdersStatus.COMPLETED);
    }


}