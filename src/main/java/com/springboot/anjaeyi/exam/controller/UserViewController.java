package com.springboot.anjaeyi.exam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
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
