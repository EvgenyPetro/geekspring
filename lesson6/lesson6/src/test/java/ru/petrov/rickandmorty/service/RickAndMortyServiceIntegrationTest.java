package ru.petrov.rickandmorty.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import ru.petrov.rickandmorty.domain.Character;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(RickAndMortyService.class)
class RickAndMortyServiceIntegrationTest {


    @Autowired
    private RickAndMortyService rickAndMortyService;


    @Autowired
    private MockRestServiceServer mockRestServiceServer;


    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        mockRestServiceServer = MockRestServiceServer.createServer(new RestTemplate());

        String character = objectMapper.writeValueAsString(new Character(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                null,
                "Male",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                "https://rickandmortyapi.com/api/character/1",
                new Date()
        ));

        mockRestServiceServer.expect(requestTo("/character/1"))
                .andRespond(withSuccess(character, MediaType.APPLICATION_JSON));
    }

    @Test()
    @DisplayName("Get Rick Sanchez INTEGRATION Test")
    void getCharacter() {
        Character character = rickAndMortyService.getCharacter("1");
        assertEquals(character.getName(),"Rick Sanchez");
    }

}