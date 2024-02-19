package ru.petrov.rickandmorty.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.petrov.rickandmorty.domain.Character;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class RickAndMortyControllerUnitTest {


    @Autowired
    private RickAndMortyService rickAndMortyService;

    private Character character;

    @BeforeEach
    public void setUp() throws JsonProcessingException {


        character = new Character(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                null,
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                "https://rickandmortyapi.com/api/character/1",
                new Date()
        );

//        when(rickAndMortyService.getCharacter("1")).thenReturn(character);

    }

    @Test()
    @DisplayName("Get Rick Sanchez UNIT Test")
    void getCharacter() {
        Character character = rickAndMortyService.getCharacter("1");
        assertEquals(character.getName(), "Rick Sanchez");
    }

}