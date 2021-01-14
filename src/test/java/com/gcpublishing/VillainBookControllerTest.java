package com.gcpublishing;

import com.gcpublishing.entity.Hero;
import com.gcpublishing.entity.Villain;
import com.gcpublishing.service.VillainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class VillainBookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    VillainService villainService;

    @Test
    public void testFindAllVillains() throws Exception {

        villainService.addVillain(new Villain(1, "villain1"));
        villainService.addVillain(new Villain(2, "villain2"));
        mockMvc.perform(get("/api/villains"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("villain1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("villain2"));

    }

    @Test
    public void testFindAllVillainsWithEmptyList() throws Exception {

        mockMvc.perform(get("/api/villains"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(0)));

    }

    @Test
    public void testFindAllVillainsWithOneValue() throws Exception {

        villainService.addVillain(new Villain(1, "villain1"));

        mockMvc.perform(get("/api/villains"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("villain1"));


    }
}
