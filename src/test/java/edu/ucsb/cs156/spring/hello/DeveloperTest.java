package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Ethan S", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_github_id() {
        assertEquals("ethansolomon49", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team() {
        Team team = Developer.getTeam();
        assertEquals("s25-04", team.getName());
        assertEquals(6, team.getMembers().size());
        assertTrue(team.getMembers().contains("Ethan S"), "Team does not contain Ethan S");
        assertTrue(team.getMembers().contains("Fahim Z"), "Team does not contain Fahim Z");
        assertTrue(team.getMembers().contains("Jeremiah W"), "Team does not contain Jeremiah W");
        assertTrue(team.getMembers().contains("Joe L"), "Team does not contain Joe L");
        assertTrue(team.getMembers().contains("Montgomery F"), "Team does not contain Montgomery F");
        assertTrue(team.getMembers().contains("Renbo Z"), "Team does not contain Renbo Z");
    }

}
