package com.emrah.emrah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminReservationController {

    @GetMapping("/admin/reservationlist")
    public ModelAndView showReservationList() {
        return new ModelAndView("reservationlist");
    }
}
