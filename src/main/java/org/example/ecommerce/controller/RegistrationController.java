//package org.example.ecommerce.controller;
//
//import org.example.ecommerce.domain.User;
//import org.example.ecommerce.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/register")
//public class RegistrationController {@Autowired
//private UserService userService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @GetMapping
//    public String showRegistrationForm() {
//        return "register";}
//    @PostMapping
//    public String registerUser(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password,
//            @RequestParam("confirmPassword") String confirmPassword,
//            @RequestParam("email") String email) {
//        if (!password.equals(confirmPassword)) {
//            // 비밀번호 불일치 처리
//            return "redirect:/register?error";}
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
//        user.setEmail(email);
//        userService.saveUser(user);
//        return "redirect:/user/login";  // 회원가입 후 로그인 페이지로 리다이렉트
//    }}