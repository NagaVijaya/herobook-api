package com.gcpublishing.services;


import com.gcpublishing.entity.Hero;
import com.gcpublishing.repository.HeroRepository;
import com.gcpublishing.service.HeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = HeroService.class)
public class HeroServiceTest {

    @Autowired
    private HeroService heroService;

    @MockBean
    private HeroRepository heroRepository;

    @Test
    public void testFindHeroByName() {
        Hero hero = buildHero();
        when(heroRepository.findByName("Rocky")).thenReturn(hero);
        Hero actualHero = heroService.findByName("Rocky");
        assertThat(actualHero.getId()).isEqualTo(hero.getId());
        assertThat(actualHero.getName()).isEqualTo(hero.getName());
        assertThat(actualHero.getAgility()).isEqualTo(hero.getAgility());
        assertThat(actualHero.getDescription()).isEqualTo(hero.getDescription());
        assertThat(actualHero.getHeight()).isEqualTo(hero.getHeight());
        assertThat(actualHero.getWeight()).isEqualTo(hero.getWeight());
        assertThat(actualHero.getRealName()).isEqualTo(hero.getRealName());
        assertThat(actualHero.getImage()).isEqualTo(hero.getImage());
        assertThat(actualHero.getIntelligence()).isEqualTo(hero.getIntelligence());
        assertThat(actualHero.getPower()).isEqualTo(hero.getPower());
        assertThat(actualHero.getStory()).isEqualTo(hero.getStory());
        assertThat(actualHero.getSpecialPower()).isEqualTo(hero.getSpecialPower());
        assertThat(actualHero.getSpeed()).isEqualTo(hero.getSpeed());
    }

    @Test
    public void testFindHeroByNameWithNullValue() {
        Hero hero = null;
        when(heroRepository.findByName("Rocky")).thenReturn(hero);
        Hero actualHero = heroService.findByName("Rocky");
        verify(heroRepository, times(1)).findByName("Rocky");
        assertThat(actualHero).isNull();
    }

    @Test
    public void testFindHeroByNameWithNoValue() {
        Hero hero = new Hero();
        when(heroRepository.findByName("Rocky")).thenReturn(hero);
        Hero actualHero = heroService.findByName("Rocky");
        verify(heroRepository, times(1)).findByName("Rocky");
        assertThat(actualHero.getId()).isEqualTo(0);
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
