package com.example.herokudemo.controller;

import com.example.herokudemo.exception.EntityNotFoundException;
import com.example.herokudemo.model.Account;
import com.example.herokudemo.model.User;
import com.example.herokudemo.service.AccountService;
import com.example.herokudemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.List;

@Controller
public class PageController {

    @GetMapping("/api/v1.0/time")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String getCurrentTime() {

        return Instant.now().toString();
    }

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/home", "/index"})
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Home");
        modelAndView.addObject("homeClicked", true);
        return modelAndView;
    }

    @GetMapping(value = "/task_5")
    public ModelAndView getTask5Page() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Task-5");
        modelAndView.addObject("task5Clicked", true);
        return modelAndView;
    }

    @GetMapping(value = "/task_8")
    public ModelAndView getTask8Page() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Task-8");
        modelAndView.addObject("task8Clicked", true);
        return modelAndView;
    }

    @GetMapping(value = "/all/accounts")
    @ResponseBody
    public List<Account> getAllAccounts() {
        return accountService.getAll();
    }

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable long id) {
        try {
            return userService.getById(id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @GetMapping(value = "/richest-users")
    @ResponseBody
    public List<User> getRichestUsers() {
        return userService.getRichestUsers();
    }

    @GetMapping(value = "/accounts-sum")
    @ResponseBody
    public double getAccountsSum() {
        return accountService.getAccountsSum();
    }
}
