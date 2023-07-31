package com.springboot.anjaeyi.exam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserViewController {

    @GetMapping({"/login"})
    public String login() {
        return "login";
    }

    @GetMapping({"/signup"})
    public String signup() {
        return "signup";
    }
}
