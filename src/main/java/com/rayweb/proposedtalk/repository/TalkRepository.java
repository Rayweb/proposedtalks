package com.rayweb.proposedtalk.repository;

import com.rayweb.proposedtalk.domain.Talk;
import org.springframework.data.repository.CrudRepository;

public interface TalkRepository extends CrudRepository<Talk, Long> {

}