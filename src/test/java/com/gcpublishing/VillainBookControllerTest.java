package com.gcpublishing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class VillainBookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testFindAllVillains() throws Exception {

        mockMvc.perform(get("/api/villains"))
                .andExpect(status().isOk());
    }

}
