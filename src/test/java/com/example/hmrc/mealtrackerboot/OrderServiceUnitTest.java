package com.example.hmrc.mealtrackerboot;

import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.repository.OrderRepo;
import com.example.hmrc.mealtrackerboot.service.OrderService;
import com.example.hmrc.mealtrackerboot.validation.OrderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class OrderServiceUnitTest {

    private OrderService service;
    private OrderRepo mockRepo;
    private OrderValidator mockValidator;

    @BeforeEach
    public void setUp(){
        mockRepo = Mockito.mock(OrderRepo.class);
        mockValidator = Mockito.mock(OrderValidator.class);
        service = new OrderService(mockRepo, mockValidator);
    }

    @Test
    public void mustAddNewOrder(){
        var order = startOrder();
        when(mockValidator.isValid(order)).thenReturn(true);
        when(mockRepo.save(order)).thenReturn(order);
        assertEquals(order, service.addNewOrder(order));
        verify(mockValidator, times(1)).isValid(order);
    }

    @Test
    public void mustFindAOrderById() {
        long id = 1l;
        var order = startOrder();
        order.setId(id);
        when(mockRepo.findById(id)).thenReturn(Optional.of(order));
        Optional<Order> result = service.findById(1l);
        assertTrue(result.isPresent());
    }

    public Order startOrder() {
        var order1 = new Order(1);
        order1.getMeals().addAll(Arrays.asList("pasta","orange juice"));
        return mockRepo.save(order1);
    }



}
