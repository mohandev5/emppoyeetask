package com.task.employeeSystem.controller;

import com.task.employeeSystem.entity.LoginDetails;
import com.task.employeeSystem.service.LoginDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginDetailsController {
    @Autowired
   private LoginDetailsService loginDetailsService;


    @GetMapping("/logindetails/{loginId}")
    public List<LoginDetails> findData(@PathVariable("loginId") int loginId) {
        return loginDetailsService.findTime(loginId);
    }
}
