package com.example.demo.neo4j.persistence;

import com.example.demo.neo4j.domain.Actor;
import com.example.demo.neo4j.domain.Movie;
import com.example.demo.neo4j.domain.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class ActorRepositoryTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActorRepositoryTests.class);

    @Autowired
    private ActorRepository actorRepository;

    private Actor actor;

    @Before
    public void init() {
        Movie movie1 = new Movie();
        movie1.setTitle("Star Wars: Episode IV");

        Movie movie2 = new Movie();
        movie2.setTitle("Star Wars: Episode V");

        actor = new Actor();
        actor.setName("Harrison Ford");

        Role role1 = new Role();
        role1.setActor(actor);
        role1.setMovie(movie1);
        role1.setTitle("Han Solo");

        Role role2 = new Role();
        role2.setActor(actor);
        role2.setMovie(movie2);
        role2.setTitle("Han Solo");

        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);
        actor.setPlayedIn(roles);

        actorRepository.save(actor);
        LOGGER.debug("actor id {}", actor.getId());
    }

    @Test
    public void findActor() {
        Actor retrievedActor = actorRepository.findOne(actor.getId());
        Assert.assertNotNull(retrievedActor);
        Assert.assertEquals(2, retrievedActor.getPlayedIn().size());
        //Test passed :-)
        LOGGER.debug("actor id {}", actor.getId());
        retrievedActor.getPlayedIn().stream().forEach(x -> LOGGER
                .debug("{} played in '{}' as '{}'", x.getActor().getName(), x.getMovie().getTitle(), x.getTitle()));
    }
}
