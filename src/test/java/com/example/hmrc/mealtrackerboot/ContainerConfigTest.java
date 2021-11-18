package com.example.hmrc.mealtrackerboot;


import com.example.hmrc.mealtrackerboot.repository.OrderRepo;
import com.example.hmrc.mealtrackerboot.service.OrderService;
import com.example.hmrc.mealtrackerboot.validation.OrderValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ContainerConfigTest {

    @Autowired
    private ApplicationContext ioContainer;


    @Test
    public void mustRepoAndServiceNotNull(){
        assertNotNull(ioContainer.getBean(OrderRepo.class));
        assertNotNull(ioContainer.getBean(OrderValidator.class));
        assertNotNull(ioContainer.getBean(OrderService.class));
    }
}
