package com.example.hmrc.mealtrackerboot.service.port;

import com.example.hmrc.mealtrackerboot.enums.UserRole;
import com.example.hmrc.mealtrackerboot.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface UserServicePort {

    User addNewUser(User user);

    void updateUser(User user);

    Page<User> findAllUsers(Pageable pageable);

    Optional<User> findOneUserById(Long id);

    List<User> findUsersByRole(UserRole role);

    void deleteUser(User id);
}

