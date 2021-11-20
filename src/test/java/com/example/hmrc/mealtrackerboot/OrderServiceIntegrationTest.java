package com.example.hmrc.mealtrackerboot;

import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.repository.OrderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

//public class OrderServiceIntegrationTest {
//    private OrderRepo mockRepo;
//
//
//    @BeforeEach
//    public void setUp(){
//        mockRepo = Mockito.mock(OrderRepo.class);
//    }
//
//    @Test
//    public void mustAddNewOrder(){
//        var order = startOrder();
//        when(mockRepo.save(order)).thenReturn(order);
//        assertNotNull(order.getId());
//    }



//}
