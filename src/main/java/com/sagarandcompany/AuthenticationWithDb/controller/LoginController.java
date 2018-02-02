package com.sagarandcompany.AuthenticationWithDb.controller;

import com.sagarandcompany.AuthenticationWithDb.model.User;
import com.sagarandcompany.AuthenticationWithDb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "Called Login Controller";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public Object createNewUser(@Valid User user, BindingResult bindingResult) {
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            return bindingResult;
        } else {
            userService.saveUser(user);
            return user;
        }
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String home() {
        return "admin Home";
    }


}
