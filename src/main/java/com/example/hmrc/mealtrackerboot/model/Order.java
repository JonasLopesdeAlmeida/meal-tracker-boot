package com.example.hmrc.mealtrackerboot.model;

import com.example.hmrc.mealtrackerboot.enums.OrdersStatus;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int tableNumber;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private LocalDateTime dateAndTime;

    @Enumerated(value = EnumType.STRING)
    private OrdersStatus status;

    @ElementCollection
    private List<String> meals = new ArrayList<>();

    private Order() {
        this.dateAndTime = LocalDateTime.now();
        this.status = OrdersStatus.NOT_STARTED;
    }

    public Order(int tableNumber) {
        this.tableNumber = tableNumber;
        this.dateAndTime = LocalDateTime.now();
        this.status = OrdersStatus.NOT_STARTED;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public OrdersStatus getStatus() {
        return status;
    }

    public void setStatus(OrdersStatus status) {
        this.status = status;
    }

    public List<String> getMeals() {
        return meals;
    }

    public void setMeals(List<String> meals) {
        this.meals = meals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

}
