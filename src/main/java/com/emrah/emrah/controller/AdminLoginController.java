package com.emrah.emrah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController {

    @GetMapping("/admin/reservationlist")
    public String showReservationList() {
        return "reservationlist"; // return the reservationlist.html template
    }
}
