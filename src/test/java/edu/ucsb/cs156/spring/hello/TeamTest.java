package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assert(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_object() {
        String str = "test";
        assert(!team.equals(str));
    }

    @Test
    public void equals_returns_true_for_same_team() {
        team.addMember("Ethan S");
        team.addMember("Fahim Z");

        Team team2 = new Team("test-team");
        team2.addMember("Ethan S");
        team2.addMember("Fahim Z");
        assert(team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_different_team_members() {
        team.addMember("Ethan S");
        team.addMember("Fahim Z");

        Team team2 = new Team("test-team");
        team2.addMember("Ethan S");
        team2.addMember("Fahim Z");
        team2.addMember("Jeremiah W");
        assert(!team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_different_team_name() {
        team.addMember("Ethan S");
        team.addMember("Fahim Z");

        Team team2 = new Team("test-team-2");
        team2.addMember("Ethan S");
        team2.addMember("Fahim Z");
        assert(!team.equals(team2));
    }

    @Test
    public void hashCode_values() {
        // instantiate t as a Team object
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }

}
