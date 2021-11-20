package com.example.hmrc.mealtrackerboot.controller;


import com.example.hmrc.mealtrackerboot.enums.OrdersStatus;
import com.example.hmrc.mealtrackerboot.enums.UserRole;
import com.example.hmrc.mealtrackerboot.model.Order;
import com.example.hmrc.mealtrackerboot.model.User;
import com.example.hmrc.mealtrackerboot.service.OrderService;
import com.example.hmrc.mealtrackerboot.service.UserService;
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
@RequestMapping(value = "/api/users/v1")
public class UserRestController {

    private final UserService service;

    public UserRestController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Page<User>> findAllUsers(
            @PageableDefault(page=0, size = 5, sort = "id",direction = Sort.Direction.DESC)Pageable pageable){
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById( @PathVariable("id") Long id){
        Optional<User> user = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @PostMapping
    public ResponseEntity<User> saveNewUser(@RequestBody User user){
        return new ResponseEntity<>(service.addNewOrder(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUserById(@RequestBody User user , @PathVariable("id") Long id){
        user.setId(id);
        service.updateOrder(user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") User id){
        service.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/role/")
    public ResponseEntity<List<User>> findAllUsersByRole(@RequestParam(value = "roleName",defaultValue = "") String roleName, UserRole role){
        return new ResponseEntity<>(service.findUserByRole(role), HttpStatus.OK);
    }


}
