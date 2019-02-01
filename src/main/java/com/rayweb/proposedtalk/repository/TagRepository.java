package com.rayweb.proposedtalk.repository;

import com.rayweb.proposedtalk.domain.Tag;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}