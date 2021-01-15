package com.gcpublishing.services;

import com.gcpublishing.entity.Hero;
import com.gcpublishing.entity.Villain;
import com.gcpublishing.repository.VillainRepository;
import com.gcpublishing.service.VillainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = VillainService.class)
public class VillainServiceTest {

    @Autowired
    VillainService villainService;

    @MockBean
    VillainRepository villainRepository;

    @Test
    public void testFindAllVillainsWithNullValue() {
        when(villainRepository.findAll()).thenReturn(null);
        List<Villain> villainList = villainService.findAllVillains();
        assertThat(villainList).isNull();
        verify(villainRepository, times(1)).findAll();
    }

    @Test
    public void testFindAllVillainsWithZeroValue() {
        List<Villain> villainList = villainService.findAllVillains();
        assertThat(villainList).isNotNull();
        assertThat(villainList.size()).isEqualTo(0);
    }

    @Test
    public void testFindAllVillainsWithOneValue() {
        List<Villain> expectedVillainList = buildVillainList(1);
        when(villainRepository.findAll()).thenReturn(expectedVillainList);
        List<Villain> villainList = villainService.findAllVillains();
        assertThat(villainList).isNotNull();
        assertThat(villainList.size()).isEqualTo(1);
        assertThat(villainList).isSameAs(expectedVillainList);
        verify(villainRepository, times(1)).findAll();
    }

    @Test
    public void testFindAllVillainsWithMultipleValue() {
        List<Villain> expectedVillainList = buildVillainList(5);
        when(villainRepository.findAll()).thenReturn(expectedVillainList);
        List<Villain> villainList = villainService.findAllVillains();
        assertThat(villainList).isNotNull();
        assertThat(villainList.size()).isEqualTo(5);
        assertThat(villainList).isSameAs(expectedVillainList);
        verify(villainRepository, times(1)).findAll();
    }


    @Test
    public void testFindVillainByNameNotFound() {
        assertThat(villainService.findByName("Villain1")).isNull();
    }

    @Test
    public void testFindVillainByNameFound() {
        Villain villain = buildVillain();
        when(villainRepository.findByName("Villain")).thenReturn(villain);
        Villain actualVillain = villainService.findByName("Villain");
        assertThat(actualVillain).isNotNull();
        assertThat(actualVillain.getId()).isEqualTo(villain.getId());
        assertThat(actualVillain.getName()).isEqualTo(villain.getName());
        assertThat(actualVillain.getAgility()).isEqualTo(villain.getAgility());
        assertThat(actualVillain.getDescription()).isEqualTo(villain.getDescription());
        assertThat(actualVillain.getHeight()).isEqualTo(villain.getHeight());
        assertThat(actualVillain.getWeight()).isEqualTo(villain.getWeight());
        assertThat(actualVillain.getRealName()).isEqualTo(villain.getRealName());
        assertThat(actualVillain.getImage()).isEqualTo(villain.getImage());
        assertThat(actualVillain.getIntelligence()).isEqualTo(villain.getIntelligence());
        assertThat(actualVillain.getPower()).isEqualTo(villain.getPower());
        assertThat(actualVillain.getStory()).isEqualTo(villain.getStory());
        assertThat(actualVillain.getSpecialPower()).isEqualTo(villain.getSpecialPower());
        assertThat(actualVillain.getSpeed()).isEqualTo(villain.getSpeed());
        assertThat(actualVillain.getArchRival()).isEqualTo(villain.getArchRival());
        verify(villainRepository, times(1)).findByName("Villain");
    }

    @Test
    public void testFindHeroByNameWithNoValue() {
        Villain villain = new Villain();
        when(villainRepository.findByName("Villain")).thenReturn(villain);
        Villain actualVillain = villainService.findByName("Villain");
        verify(villainRepository, times(1)).findByName("Villain");
        assertThat(actualVillain.getId()).isEqualTo(0);
    }

    private Villain buildVillain() {
        Villain villain = new Villain();
        villain.setName("Villain");
        villain.setId(1);
        villain.setImage("Villain-image");
        villain.setRealName("Villain-realName");
        villain.setHeight(160);
        villain.setWeight(200);
        villain.setSpecialPower("Villain-sp");
        villain.setIntelligence("Villain-intelligent");
        villain.setStrength("Villain-strength");
        villain.setPower("Villain-power");
        villain.setSpeed(200);
        villain.setAgility("Villain-agility");
        villain.setDescription("Villain-description");
        villain.setStory("Villain-story");
        villain.setArchRival("Villain-archRival");
        return villain;
    }


    private List<Villain> buildVillainList(int count){
        List<Villain> villainList = new ArrayList<>();
        for (int i=0;i<count;i++) {
            Villain villain = new Villain();
            villain.setName("Villain"+i);
            villain.setId(1);
            villain.setImage("Villain"+i+"-image");
            villain.setRealName("Villain"+i+"-realName");
            villain.setHeight(i+160);
            villain.setWeight(i+200);
            villain.setSpecialPower("Villain"+i+"-sp");
            villain.setIntelligence("Villain"+i+"-intelligent");
            villain.setStrength("Villain"+i+"-strength");
            villain.setPower("Villain"+i+"-power");
            villain.setSpeed(200+i);
            villain.setAgility("Villain"+i+"-agility");
            villain.setDescription("Villain"+i+"-description");
            villain.setStory("Villain"+i+"-story");
            villain.setArchRival("Villain"+i+"-archRival");
            villainList.add(villain);
        }
        return villainList;
    }

}
