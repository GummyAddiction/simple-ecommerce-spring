package com.project.ecommerce.controller;

import com.project.ecommerce.model.Category;
import com.project.ecommerce.model.UserRequest;
import com.project.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity login(@RequestBody UserRequest usr){
//        return ResponseEntity.ok(userService.login(usr));
        HashMap<String, String> map = new HashMap<>();
        map.put("role",userService.login(usr));
        return ResponseEntity.ok(map);
    }
}
