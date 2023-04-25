package com.example.controller;

import com.example.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    /**
     * 进入登录页面
     *
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    /**
     * 登录成功后重定向道main页面 ，防止表单重复提交
     * @return
     */
    @PostMapping("/login")
    public String main(@RequestBody User user, HttpSession session) {
        System.out.println(user.getUsername());
        return "redirect:/main.html";
    }

    @GetMapping("/main.html")
    public String gotoPage(){


        return "main";
    }

}
