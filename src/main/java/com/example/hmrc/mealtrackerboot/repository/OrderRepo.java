package com.example.hmrc.mealtrackerboot.repository;


import com.example.hmrc.mealtrackerboot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {


}
