package com.springboot.anjaeyi.exam.controller;

import com.springboot.anjaeyi.exam.model.dto.AddUserRequest;
import com.springboot.anjaeyi.exam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {
    private final UserService userService;

    @PostMapping({"/user"})
    public String signup(AddUserRequest request) {
        this.userService.save(request);
        return "redirect:/login";
    }
}
