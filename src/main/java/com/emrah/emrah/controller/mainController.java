package com.emrah.emrah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/index")
    public String index (Model model){
        //model.addAttribute("message", "Emrah");
        return "index";
    }
    @GetMapping("/menu")
    public String menu (Model model){
        return "menu";
    }
    @GetMapping("/about")
    public String about(Model model){
        return "about";
    }
    @GetMapping("/contact")
    public String contact(Model model){
        return "contact";
    }
    @GetMapping("/reservation")
    public String reservation(Model model){
        return "reservation";
    }
}


