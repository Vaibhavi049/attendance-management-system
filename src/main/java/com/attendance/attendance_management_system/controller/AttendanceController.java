package com.attendance.attendance_management_system.controller;

import com.attendance.attendance_management_system.dto.CheckInRequest;
import com.attendance.attendance_management_system.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        return attendanceService.getStatus();
    }

    @PostMapping("/checkin")
    public Map<String, Object> checkIn(@RequestBody CheckInRequest request) {
        return attendanceService.checkIn(request);
    }
}