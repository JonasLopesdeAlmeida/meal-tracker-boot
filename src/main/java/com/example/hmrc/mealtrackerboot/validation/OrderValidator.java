package com.example.hmrc.mealtrackerboot.validation;

import com.example.hmrc.mealtrackerboot.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {


    private final int numOfTables = 20;

    public boolean isValid(Order order){
        return order.getTableNumber() >=1 && order.getTableNumber() <= numOfTables;
    }
}