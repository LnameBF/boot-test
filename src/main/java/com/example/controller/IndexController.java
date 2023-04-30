package com.example.controller;

import com.example.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
     *
     * @return
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session) {
        //判断账号和密码不为空
        if (StringUtils.hasLength(user.getUsername()) && StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("LoginUser", user);
            return "redirect:/main.html";
        } else {
            //回到登录页面
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String gotoPage(HttpSession session) {
        return "main";
    }
}
