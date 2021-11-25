package com.example.hmrc.mealtrackerboot.service;

import com.example.hmrc.mealtrackerboot.enums.OrdersStatus;
import com.example.hmrc.mealtrackerboot.enums.UserRole;
import com.example.hmrc.mealtrackerboot.excption.BusinessNegotiationException;
import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.model.User;
import com.example.hmrc.mealtrackerboot.repository.OrderRepo;
import com.example.hmrc.mealtrackerboot.repository.UserRepo;
import com.example.hmrc.mealtrackerboot.service.port.UserServicePort;
import com.example.hmrc.mealtrackerboot.validation.OrderValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@Transactional
public class UserService implements UserServicePort {

    private UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public User addNewUser(User user) {
            return repo.save(user);
    }

    public void updateUser(User user) {
        Objects.requireNonNull(user.getId());
            repo.save(user);
    }

    public Page<User> findAllUsers(Pageable pageable) {
        Page<User>pages = repo.findAll(pageable);
        return pages;
    }

    public Optional<User>findOneUserById(Long id) {
        Optional<User> user = repo.findById(id);
        if(user.isPresent()){
            return user;
        }else{
            return Optional.empty();
        }
    }

    @Override
    public List<User> findUsersByRole(UserRole role) {
        return repo.findByRole(role);
    }


    public void deleteUser(User id) {
        repo.delete(id);
    }

}