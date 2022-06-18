package com.example.Task311.controller;

import com.example.Task311.model.User;
import com.example.Task311.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        model.addAttribute("users",userService.findAll());
        return "user-list";
    }
    @GetMapping("/user-create")
    public String createUserForm(Model model){
        model.addAttribute("user", new User());
        return "user-create";
    }
    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable ("id") Long id, Model model){
        model.addAttribute("user",userService.findById(id));
        return "/user-update";
    }
    @PostMapping("/user-update/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}
