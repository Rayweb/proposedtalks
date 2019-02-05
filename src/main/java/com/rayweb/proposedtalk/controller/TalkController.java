package com.rayweb.proposedtalk.controller;

import com.rayweb.proposedtalk.domain.Talk;
import com.rayweb.proposedtalk.service.TalkService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/talks")
public class TalkController {

    private final TalkService talkservice;

    public TalkController(TalkService talkService){
        this.talkservice = talkService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Talk> addTalk(@RequestBody Talk request){
        Talk talk = talkservice.create(request);
        return ResponseEntity.ok(talk);
    }

}
