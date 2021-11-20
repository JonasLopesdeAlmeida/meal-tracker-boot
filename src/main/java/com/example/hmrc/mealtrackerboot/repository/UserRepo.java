package com.example.hmrc.mealtrackerboot.repository;


import com.example.hmrc.mealtrackerboot.enums.OrdersStatus;
import com.example.hmrc.mealtrackerboot.enums.UserRole;
import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findByRole(UserRole role);
    Optional<User> findByUsername(String username);


}
