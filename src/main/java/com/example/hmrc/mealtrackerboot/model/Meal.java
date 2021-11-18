package com.example.hmrc.mealtrackerboot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mealsName;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;



    private Meal() {

    }

    public Meal(String mealsName, Order order) {
        this.mealsName = mealsName;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMealsName() {
        return mealsName;
    }

    public void setMealsName(String mealsName) {
        this.mealsName = mealsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(mealsName, meal.mealsName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealsName);
    }
}
