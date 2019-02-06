package com.rayweb.proposedtalk.repository;

import com.rayweb.proposedtalk.domain.ProposedTalk;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposedTalkRepository extends JpaRepository<ProposedTalk, Long> {

}