package com.example.guestbook.controller;

import lombok.extern.log4j.Log4j2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.guestbook.dto.PageRequestDTO;
import com.example.guestbook.service.GuestbookService;

@Controller
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor
public class GuestbookController {

    private final GuestbookService service;

    @GetMapping("/")
    public String index(){
        return "redirect:/guestbook/list";
    }

    @GetMapping("/list")
    public void  list(PageRequestDTO pageRequestDTO, Model model){

        log.info("list..........." + pageRequestDTO);

        model.addAttribute("result", service.getList(pageRequestDTO));

    }
}
