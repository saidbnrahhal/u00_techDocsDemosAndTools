package com.capgemini.pfe.controllers;

import com.capgemini.pfe.repositories.GameRepository;
import com.capgemini.pfe.entities.GameEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/game")
    public Flux<GameEntity> findAll() {
        return gameRepository.findAll();
    }

    @GetMapping("/game/{id}")
    public Mono<GameEntity> findOne(@PathVariable String id) {
        return gameRepository.findById(id);
    }

    @PostMapping("/game")
    public Mono<GameEntity> addGame(@RequestBody GameEntity game) {
        return gameRepository.insert(game);
    }

    @DeleteMapping("/game/{id}")
    public Mono<Void> deleteGame(@PathVariable String id) {
        GameEntity game = new GameEntity();
        game.setId(id);
        return gameRepository.delete(game);
    }

    @PutMapping("/game/{id}")
    public Mono<GameEntity> updateGame(@PathVariable String id, @RequestBody GameEntity game) {
        game.setId(id);
        return gameRepository.save(game);
    }
}
