package com.example.demo.neo4j.persistence;

import com.example.demo.neo4j.domain.Actor;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface ActorRepository extends GraphRepository<Actor> {

}
