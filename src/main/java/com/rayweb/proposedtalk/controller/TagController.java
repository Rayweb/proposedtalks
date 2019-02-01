package com.rayweb.proposedtalk.controller;

import java.util.List;

import com.rayweb.proposedtalk.domain.Tag;
import com.rayweb.proposedtalk.service.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping(value = "/")
    public String getPage(Model model) {
        List<Tag> tags = tagService.findAll();
        model.addAttribute("tags",tags);
        return "tags";
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Tag> postMethodName(@RequestParam String topic) {
        Tag tag = tagService.createTag(topic);
        return ResponseEntity.ok(tag);
    }

}