package com.rayweb.proposedtalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProposedTalkController {

    @GetMapping(value="/")
    public String home() {
        return "talks";
    }
    
}