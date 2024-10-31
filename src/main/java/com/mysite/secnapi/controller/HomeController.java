package com.mysite.secnapi.controller;

import com.mysite.secnapi.domain.Role;
import com.mysite.secnapi.domain.User;
import com.mysite.secnapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @GetMapping("/")
    public String home() {
        log.info("home controller...");
        return "home";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
 // 사용자 목록
    @GetMapping("/users")
    public String userList(Model model) {
        List<User> users = userMapper.findAll(); // findAll 메서드 추가 필요
        model.addAttribute("users", users);
        return "user-list";
    }

}
