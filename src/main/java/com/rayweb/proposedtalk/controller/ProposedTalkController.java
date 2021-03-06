package com.rayweb.proposedtalk.controller;

import java.util.List;
import com.rayweb.proposedtalk.domain.ProposedTalk;
import com.rayweb.proposedtalk.domain.Tag;
import com.rayweb.proposedtalk.service.ProposedTalkService;
import com.rayweb.proposedtalk.service.TagService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proposedtalks")
public class ProposedTalkController {

    private final ProposedTalkService proposedTalkService;
    private final TagService tagService;

    public ProposedTalkController(ProposedTalkService proposedTalkService, TagService tagService) {
        this.proposedTalkService = proposedTalkService;
        this.tagService = tagService;
    }

    @GetMapping(value = "/")
    public String getProposedTalks(Model model) {
        List<ProposedTalk> pts = this.proposedTalkService.findAll();
        model.addAttribute("proposedTalks",pts);
        return "proposedTalks";
    }

    @GetMapping(value = "/add")
    public String addTalk(Model model) {
        List<Tag> tags = tagService.findAll();
        model.addAttribute("tags", tags);
        return "addTalk";
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ProposedTalk> addTalk(@RequestBody ProposedTalk proposedTalk) {
        return ResponseEntity.ok(proposedTalkService.create(proposedTalk));
    }

    @GetMapping(value = "/{id}")
    public String getProposedTalk(@PathVariable("id") Long id, Model model) {
        this.proposedTalkService.findById(id).ifPresent(pt -> model.addAttribute("proposedTalk", pt));
        return "proposedTalk";
    }

}