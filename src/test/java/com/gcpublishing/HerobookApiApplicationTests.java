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

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HerobookApiApplicationTests {

@Autowired
MockMvc mockMvc;

@MockBean
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
 public void testFindAllHeroesWithNull() throws Exception {

     List<Hero> heroList = heroService.findAll();

 	MvcResult mvcResult = mockMvc.perform(get("/api/heroes"))
			.andExpect(status().isOk())
            .andReturn();
 	assertThat(mvcResult.getResponse().getContentAsString()).isEmpty();

 }


}
