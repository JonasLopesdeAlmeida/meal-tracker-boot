package com.example.hmrc.mealtrackerboot.controller;


import com.example.hmrc.mealtrackerboot.enums.OrdersStatus;
import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.service.OrderService;
import com.example.hmrc.mealtrackerboot.service.port.OrderServicePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/orders/v1")
public class OrderRestController {

    private final OrderServicePort service;

    public OrderRestController(OrderServicePort service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Page<Order>> findAllOrders(
            @PageableDefault(page=0, size = 5, sort = "id",direction = Sort.Direction.DESC)Pageable pageable){
        return new ResponseEntity<>(service.findAllOrders(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findOrderById( @PathVariable("id") Long id){
        Optional<Order> order = service.findOneOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(order.get());
    }

    @PostMapping
    public ResponseEntity<Order> saveNewOrder(@RequestBody Order order){
        return new ResponseEntity<>(service.addNewOrder(order), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateOrderById(@RequestBody Order order , @PathVariable("id") Long id){
        order.setId(id);
        service.updateOrder(order);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable("id") Order id){
        service.deleteOrder(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/status/")
    public ResponseEntity<List<Order>> findAllOrdersByStatus(@RequestParam(value = "statusName",defaultValue = "") String statusName, OrdersStatus status){
        return new ResponseEntity<>(service.findOrderByStatus(status), HttpStatus.OK);
    }


}
