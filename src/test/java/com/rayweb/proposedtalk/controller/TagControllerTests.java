package com.rayweb.proposedtalk.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.rayweb.proposedtalk.domain.Tag;
import com.rayweb.proposedtalk.service.TagService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(TagController.class)

public class TagControllerTests {

    @MockBean 
    TagService tagService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void create_tag_should_return_StatusOK() throws Exception {
        Tag tag = new Tag(4,"Test Tag");
        when(tagService.createTag(any(String.class))).thenReturn(tag);
        mockMvc.perform(post("/tags/add?topic=Test Tag")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }

}