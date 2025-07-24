package com.paymentdemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class authcontroller {

    private Map<String, String> datalogged = new HashMap<>();

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String uname, @RequestParam String pass, Model model) {
        if (datalogged.containsKey(uname)) {
            model.addAttribute("error", "User already exists");
            return "register";
        }

        datalogged.put(uname, pass);
        model.addAttribute("message", "Registration successful.");
        return "login";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String uname, @RequestParam String pass, Model model) {
        if (datalogged.containsKey(uname) && datalogged.get(uname).equals(pass)) {
            model.addAttribute("user", uname);
            return "welcome"; // Make sure you have welcome.html in templates
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}
