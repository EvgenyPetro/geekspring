package ru.petrov.rickandmorty.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.petrov.rickandmorty.domain.Character;
import ru.petrov.rickandmorty.domain.Response;

@Service
public class RickAndMortyService {

    private final RestClient restClient;

    public RickAndMortyService(@Value("${api.rickandmorty}") String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public Response getAllCharacters(Integer page) {
        return restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/character")
                        .queryParam("page", page)
                        .build())
                .retrieve()
                .body(Response.class);
    }

    public Character getCharacter(String id) {
        return restClient
                .get()
                .uri("/character/{id}", id)
                .retrieve()
                .body(Character.class);
    }
}
