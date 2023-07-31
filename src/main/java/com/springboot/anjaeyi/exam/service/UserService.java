package com.springboot.anjaeyi.exam.service;

import com.springboot.anjaeyi.exam.model.User;
import com.springboot.anjaeyi.exam.model.dto.AddUserRequest;
import com.springboot.anjaeyi.exam.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest request) {
        return userRepository.save(User.builder()
                .email(request.getEmail())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .build()
        ).getId();
    }

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
}
