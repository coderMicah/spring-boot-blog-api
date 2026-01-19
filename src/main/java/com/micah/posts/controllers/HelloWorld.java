package com.micah.posts.controllers;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello-world")
    public String getHello(@AuthenticationPrincipal Jwt jwt) {
        String name = jwt.getClaimAsString("name");
        String email = jwt.getClaimAsString("email");

        return "Hello World!! User with name: " + name + " and email: " + email + " is autheticated";
    }
}
