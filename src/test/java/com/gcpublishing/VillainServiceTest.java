package com.gcpublishing;

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
    public void testFindAllVillainsWithNullValue(){
       when(villainRepository.findAll()).thenReturn(null);
       List<Villain> villainList = villainService.findAllVillains();
       assertThat(villainList).isNull();
       verify(villainRepository,times(1)).findAll();
    }

    @Test
    public void testFindAllVillainsWithZeroValue(){
        List<Villain> villainList = villainService.findAllVillains();
        assertThat(villainList).isNotNull();
        assertThat(villainList.size()).isEqualTo(0);
    }

    @Test
    public void testFindAllVillainsWithOneValue(){
        List<Villain> expectedVillainList = buildVillainList(1);
        when(villainRepository.findAll()).thenReturn(expectedVillainList);
        List<Villain> villainList = villainService.findAllVillains();
        assertThat(villainList).isNotNull();
        assertThat(villainList.size()).isEqualTo(1);
        assertThat(villainList).isSameAs(expectedVillainList);
        verify(villainRepository,times(1)).findAll();
    }

    @Test
    public void testFindAllVillainsWithMultipleValue(){
        List<Villain> expectedVillainList = buildVillainList(5);
        when(villainRepository.findAll()).thenReturn(expectedVillainList);
        List<Villain> villainList = villainService.findAllVillains();
        assertThat(villainList).isNotNull();
        assertThat(villainList.size()).isEqualTo(5);
        assertThat(villainList).isSameAs(expectedVillainList);
        verify(villainRepository,times(1)).findAll();
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
            villainList.add(villain);
        }
        return villainList;
    }

}
