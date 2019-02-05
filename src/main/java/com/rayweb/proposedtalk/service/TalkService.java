package com.rayweb.proposedtalk.service;

import com.rayweb.proposedtalk.domain.Talk;
import com.rayweb.proposedtalk.repository.TalkRepository;
import org.springframework.stereotype.Service;

@Service
public class TalkService {

    private final TalkRepository talkRepository;

    public TalkService(TalkRepository talkRepository){
        this.talkRepository = talkRepository;
    }

    public Talk create(Talk request) {
        return this.talkRepository.save(request);
    }
}