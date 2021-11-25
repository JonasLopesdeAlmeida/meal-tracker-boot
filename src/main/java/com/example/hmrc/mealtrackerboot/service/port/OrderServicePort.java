package com.example.hmrc.mealtrackerboot.service.port;

import com.example.hmrc.mealtrackerboot.enums.OrdersStatus;
import com.example.hmrc.mealtrackerboot.excption.BusinessNegotiationException;
import com.example.hmrc.mealtrackerboot.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface OrderServicePort {

     Order addNewOrder(Order order);

     void updateOrder(Order order);

     Page<Order> findAllOrders(Pageable pageable);

     Optional<Order> findOneOrderById(Long id);

     List<Order> findOrderByStatus(OrdersStatus status);

     void deleteOrder(Order id);

     List<Order> findAllCurrentOrder();

}
