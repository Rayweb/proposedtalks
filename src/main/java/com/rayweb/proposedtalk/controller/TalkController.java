package com.rayweb.proposedtalk.controller;

import java.util.List;

import com.rayweb.proposedtalk.domain.Tag;
import com.rayweb.proposedtalk.domain.Talk;
import com.rayweb.proposedtalk.service.TagService;
import com.rayweb.proposedtalk.service.TalkService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/talks")
public class TalkController {

    private final TalkService talkService;
    private final TagService tagService;

    public TalkController(TalkService talkService,TagService tagService){
        this.talkService = talkService;
        this.tagService = tagService;
    }

    @GetMapping(value = "/add")
    public String addTalk(Model model){
        List<Tag> tags = tagService.findAll();
        model.addAttribute("tags",tags);
        return "addTalk";
    }


    @PostMapping(value = "/add")
    public ResponseEntity<Talk> addTalk(@RequestBody Talk proposedTalk){
        Talk talk = talkService.create(proposedTalk);
        return ResponseEntity.ok(talk);
    }

}
