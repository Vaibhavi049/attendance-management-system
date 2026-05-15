package com.attendance.attendance_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Attendance Management System Running Successfully!";
    }

    @GetMapping("/test")
    public String test() {
        return "CI/CD Pipeline Deployment Successful!";
    }
}