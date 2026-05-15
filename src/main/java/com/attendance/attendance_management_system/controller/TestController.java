package com.attendance.attendance_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/attendance/status")
    public String status() {
        return "Attendance Service is Running";
    }

    @PostMapping("/attendance/checkin")
    public String checkin() {
        return "Employee Checked In Successfully";
    }
}