package com.capgemini.pfe.webClientApi;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service()
public class UserApiFinder {

    public static final String api = "https://jsonplaceholder.typicode.com/users";

    WebClient webClient = WebClient.builder()
            .baseUrl(api)
            .defaultCookie("cookie-name", "cookie-value")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    public List<UserApi> getUserApiList() {
       return webClient.get()
                .uri("")
                .retrieve()
                .bodyToFlux(UserApi.class)
                .collectList().block();
    }
}
