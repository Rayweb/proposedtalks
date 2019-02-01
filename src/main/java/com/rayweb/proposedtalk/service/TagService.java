package com.rayweb.proposedtalk.service;

import java.util.List;

import com.rayweb.proposedtalk.domain.Tag;
import com.rayweb.proposedtalk.repository.TagRepository;

import org.springframework.stereotype.Service;

@Service
public class TagService {

    private TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag createTag(String topic) {
        Tag tag = new Tag();
        tag.setName(topic);
        return tagRepository.save(tag);
    }

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }
}