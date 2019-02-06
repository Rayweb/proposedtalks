package com.rayweb.proposedtalk.service;

import com.rayweb.proposedtalk.domain.ProposedTalk;
import com.rayweb.proposedtalk.repository.ProposedTalkRepository;

import org.springframework.stereotype.Service;

@Service
public class ProposedTalkService {

    private final ProposedTalkRepository proposedTalkRepository;

    public ProposedTalkService(ProposedTalkRepository proposedTalkRepository){
        this.proposedTalkRepository = proposedTalkRepository;
    }

    public ProposedTalk create(ProposedTalk request) {
        return this.proposedTalkRepository.save(request);
    }
}