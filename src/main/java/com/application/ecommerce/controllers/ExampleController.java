package com.application.ecommerce.controllers;

import com.application.ecommerce.models.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/example")
    @Transactional
    public String example(Model model) {
        User user = User.builder()
                .name("John Doe")
                .email("correo@correo.com")
                .build();
        entityManager.persist(user);
        model.addAttribute("user", user);
        return "example";
    }

}
