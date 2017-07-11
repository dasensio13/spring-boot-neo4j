package com.example.demo.neo4j.domain;

import java.util.List;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Actor {

    @GraphId
    Long id;

    String name;

    private List<Role> playedIn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getPlayedIn() {
        return playedIn;
    }

    public void setPlayedIn(List<Role> playedIn) {
        this.playedIn = playedIn;
    }
}
