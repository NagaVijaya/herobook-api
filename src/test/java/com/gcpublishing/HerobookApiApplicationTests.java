package com.gcpublishing;

import com.gcpublishing.entity.Hero;
import com.gcpublishing.service.HeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class HerobookApiApplicationTests {

@Autowired
MockMvc mockMvc;

@Autowired
HeroService heroService;
/**
 *
 *
 * 	As a visitor, I can view all the heroes.
 *
 * When I view all the heros
 * Then I can see names of all heros
 *
 */

    @Test
    public void testFindAllHeroesWithEmptyList() throws Exception {

          mockMvc.perform(get("/api/heroes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(0)));

    }

    @Test
    public void testFindAllHeroesWithOneHero() throws Exception {

        heroService.addHero(new Hero());
        mockMvc.perform(get("/api/heroes"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$",hasSize(1)));

    }

    @Test
    public void testFindAllHeroesWithMultipleHeroes() throws Exception {

        heroService.addHero(new Hero(1,"hero1"));
        heroService.addHero(new Hero(2,"hero2"));
        heroService.addHero(new Hero(3,"hero3"));
        heroService.addHero(new Hero(4,"hero4"));
        heroService.addHero(new Hero(5,"hero5"));
        mockMvc.perform(get("/api/heroes"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("hero1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("hero2"))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].name").value("hero3"))
                .andExpect(jsonPath("$[3].id").value(4))
                .andExpect(jsonPath("$[3].name").value("hero4"))
                .andExpect(jsonPath("$[4].id").value(5))
                .andExpect(jsonPath("$[4].name").value("hero5"));


    }




}
