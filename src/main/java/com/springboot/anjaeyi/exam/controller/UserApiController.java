package com.springboot.anjaeyi.exam.controller;

import com.springboot.anjaeyi.exam.model.dto.AddUserRequest;
import com.springboot.anjaeyi.exam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PostMapping({"/user"})
    public String signup(AddUserRequest request) {
        this.userService.save(request);
        return "redirect:/login";
    }
}
