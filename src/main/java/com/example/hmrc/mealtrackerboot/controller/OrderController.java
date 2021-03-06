package com.example.hmrc.mealtrackerboot.controller;

import com.example.hmrc.mealtrackerboot.service.OrderService;
import com.example.hmrc.mealtrackerboot.service.port.OrderServicePort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderServicePort service;

    public OrderController(OrderServicePort service) {
        this.service = service;
    }

    @GetMapping
    public String showOrdersPage(Model model) {
        model.addAttribute("orders", service.findAllCurrentOrder());
        return "orders";
    }
}
