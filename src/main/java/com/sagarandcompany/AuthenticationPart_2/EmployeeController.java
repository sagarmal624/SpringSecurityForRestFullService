package com.sagarandcompany.AuthenticationPart_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/hello")
    public String hello() {
        return "i am calling from user hello view";
    }

    @GetMapping("/emp")
    public String emp() {
        return "i am calling from user emp view";
    }

    @GetMapping("/user")
    public String user() {
        return "i am calling from user view";
    }

}
