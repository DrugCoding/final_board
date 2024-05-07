package org.example.finalboard.controller;

import jakarta.servlet.http.HttpSession;
import org.example.finalboard.dto.SignupDto;
import org.example.finalboard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 메인 홈페이지(index)
    @GetMapping("/")
    public String homePage(HttpSession httpSession) {
        return "index";
    }

    // 회원가입 시작(signup)
    // 회원가입 페이지(Get)
    @GetMapping("/signup")
    public String signupForm(HttpSession httpSession) {
        if (httpSession.getAttribute("username") != null and)
        return "signup";
    }
    // 회원가입 페이지(Post)
    @PostMapping("/signip")
    public String saveSignup(SignupDto signupDto) {
        userService.saveUser(signupDto);
        return "redirect:/";
    }
}
