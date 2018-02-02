package com.sagarandcompany.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/hello")
    public String hello() {
        return "calling from hello action";
    }

    @GetMapping("/emp")
    public String emp() {
        return "calling from emp action";
    }
}
