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

    /**
     *
     * As a visitor, I can view all the villains.
     *
     * When I view all the villains
     * Then I can see names of all villains
     *
     *
     */

    @Test
    public void testFindAllVillainsWithMultipleVillains() throws Exception {

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

    /**
     *
     * As a visitor, I can view all the villains.
     *
     * When I view all the villains
     * Then I can see names of all villains
     *
     *
     */

    @Test
    public void testFindAllVillainsWithEmptyList() throws Exception {

        mockMvc.perform(get("/api/villains"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(0)));

    }

    /**
     *
     * As a visitor, I can view all the villains.
     *
     * When I view all the villains
     * Then I can see names of all villains
     *
     *
     */

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

    /**
     * As a visitor, I can see information about any individual hero so that I can see their stats.
     *
     * Rule: Villains have an arch rival, image, real name, hero name, height, weight, special power, intelligence, strength, power, speed, agility, description, and story.
     *
     * Given I have the name of a villain
     * When I retreive the villain
     * Then I can view all the details for that villain
     *
     * Given I have an incorrect villain name
     * When I retreive details for that villain
     * Then I receive a message that it doesn't exist
     */

    @Test
    public void testFindByNameFound() throws Exception {
        mockMvc.perform(get("/api/villains/name/{name}","Villain1"))
                .andExpect(status().isOk())
                .andDo(print());


    }



}
