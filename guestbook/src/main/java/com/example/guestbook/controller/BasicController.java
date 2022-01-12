package com.example.guestbook.controller;

import lombok.extern.log4j.Log4j2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
public class BasicController {

    @GetMapping("/")
    public String home() {return "redirect:/guestbook/list";}
}
