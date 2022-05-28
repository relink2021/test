package com.kurong.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class RelationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllRelationTest() throws Exception {
        String response = this.mvc.perform(get("/getRelation?username=12345"))
                .andReturn().getResponse().getContentAsString();
    }
}
