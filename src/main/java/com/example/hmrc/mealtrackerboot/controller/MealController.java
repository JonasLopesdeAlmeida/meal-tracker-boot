package com.example.hmrc.mealtrackerboot.controller;


import com.example.hmrc.mealtrackerboot.service.MealService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/meals")
public class MealController {


    private final MealService service;


    public MealController(MealService service) {
        this.service = service;
    }
}
