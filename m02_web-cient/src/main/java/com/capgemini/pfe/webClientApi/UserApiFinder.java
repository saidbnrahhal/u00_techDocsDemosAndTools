package com.capgemini.pfe.webClientApi;

import com.capgemini.pfe.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service()
public class UserApiFinder {

    public static final String api = "https://jsonplaceholder.typicode.com/users";


    private final UserService userService;

    WebClient webClient = WebClient.builder()
            .baseUrl(api)
            .defaultCookie("cookie-name", "cookie-value")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    public UserApiFinder(UserService userService) {
        this.userService = userService;
    }

    public void getUserApiList() {

    }

    public void sertLoadingUsers() {
        webClient.get()
                .uri("")
                .retrieve()
                .bodyToFlux(UserApi.class)
                .subscribe(userApi -> {
                    userService.publish(userApi);
                });
    }
}
