package com.capgemini.pfe.repositories;

import com.capgemini.pfe.entities.GameEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface GameRepository extends ReactiveMongoRepository<GameEntity,String> {

}
