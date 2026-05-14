package com.attendance.attendance_management_system.service;

import com.attendance.attendance_management_system.dto.CheckInRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class AttendanceService {

    public Map<String, Object> getStatus() {

        Map<String, Object> response = new HashMap<>();

        response.put("service", "Attendance Management System");
        response.put("status", "ACTIVE");
        response.put("timestamp", LocalDateTime.now());

        return response;
    }

    public Map<String, Object> checkIn(CheckInRequest request) {

        Map<String, Object> response = new HashMap<>();

        response.put("message", "Check-in successful");
        response.put("employeeId", request.getEmployeeId());
        response.put("employeeName", request.getEmployeeName());
        response.put("checkInTime", LocalDateTime.now());

        return response;
    }
}