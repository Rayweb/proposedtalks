package com.rayweb.proposedtalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProposedTalkController {

    @GetMapping(value="/")
    public String home() {
        return "talks";
    }
    
}