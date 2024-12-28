package com.example.schoolservice.controller;

import com.example.schoolservice.entity.SchoolExcursion;
import com.example.schoolservice.entity.Student;
import com.example.schoolservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findHealthStudentStatus")
    public String getHealthStatusFromStudentService() {
        String studentServiceUrl = "http://localhost:8081/api/student/healthStatus";
        return restTemplate.getForObject(studentServiceUrl, String.class);
    }

    @PostMapping("/registerStudent")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
        try {
            String studentServiceUrl2 = "http://localhost:8081/api/student/add";
            ResponseEntity<String> response = restTemplate.postForEntity(studentServiceUrl2, student, String.class);

            if (response.getBody() == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No response from StudentService");
            }

            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

        @DeleteMapping("/deleteStudent/{id}")
        public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
            try {
                String studentServiceUrl = "http://localhost:8081/api/student/delete/" + id;

                restTemplate.delete(studentServiceUrl);

                return ResponseEntity.ok("Student deleted successfully.");

            } catch (Exception e) {

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error while deleting student: " + e.getMessage());
            }
        }

    }




