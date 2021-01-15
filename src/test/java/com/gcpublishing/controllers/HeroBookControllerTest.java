package com.gcpublishing.controllers;

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
class HeroBookControllerTest {

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

    /**
     * Rule: Heroes have an image, real name, hero name, height, weight, special power, intelligence, strength, power, speed, agility, description, and story.
     *
     * Given I have the name of a hero
     * When I retreive the hero
     * Then I can view all the details for that hero
     *

     */

    @Test
    public void testFindHeroByName() throws Exception {
        Hero hero = buildHero();
        heroService.addHero(hero);
        mockMvc.perform(get("/api/heroes/name/{name}","Rocky"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id").value(hero.getId()))
                .andExpect(jsonPath("$.agility").value(hero.getAgility()))
                .andExpect(jsonPath("$.description").value(hero.getDescription()))
                .andExpect(jsonPath("$.height").value(hero.getHeight()))
                .andExpect(jsonPath("$.name").value(hero.getName()))
                .andExpect(jsonPath("$.realName").value(hero.getRealName()))
                .andExpect(jsonPath("$.height").value(hero.getHeight()))
                .andExpect(jsonPath("$.weight").value(hero.getWeight()))
                .andExpect(jsonPath("$.specialPower").value(hero.getSpecialPower()))
                .andExpect(jsonPath("$.speed").value(hero.getSpeed()))
                .andExpect(jsonPath("$.strength").value(hero.getStrength()))
                .andExpect(jsonPath("$.story").value(hero.getStory()))
                .andExpect(jsonPath("$.intelligence").value(hero.getIntelligence()))
                .andExpect(jsonPath("$.image").value(hero.getImage()));

    }

    /**
     * Given I have an incorrect hero name
     * When I retreive details for that hero
     * Then I receive a message that it doesn't exist
     */

    @Test
    public void testFindHeroByNameNotFound() throws Exception {
        Hero hero = buildHero();
        heroService.addHero(hero);
        MvcResult mvcResult = mockMvc.perform(get("/api/heroes/name/{name}", "Rocky1"))
                .andExpect(status().isNotFound())
                .andDo(print())
                .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString()).isEmpty();
    }


    private Hero buildHero() {
        Hero hero = new Hero(1, "Rocky");
        hero.setImage("Rocky-image");
        hero.setRealName("Rocky-realName");
        hero.setHeight(160);
        hero.setWeight(200);
        hero.setSpecialPower("Rocky-sp");
        hero.setIntelligence("Rocky-intelligent");
        hero.setStrength("Rocky-strength");
        hero.setPower("Rocky-power");
        hero.setSpeed(200);
        hero.setAgility("Rocky-agility");
        hero.setDescription("Rocky-description");
        hero.setStory("Rocky-story");

        return hero;
    }

}
