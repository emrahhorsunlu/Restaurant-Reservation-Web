package com.emrah.emrah.controller;

import com.emrah.emrah.model.AdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class AdminLoginController {

    @GetMapping("/admin/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/admin/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "123".equals(password)) {
            return new ModelAndView("redirect:/admin/reservationlist");
        } else {
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("error", "Kullanıcı adı veya parola yanlış!");
            return mav;
        }
    }
}
