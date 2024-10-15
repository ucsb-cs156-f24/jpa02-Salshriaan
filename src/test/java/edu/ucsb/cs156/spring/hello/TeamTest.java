package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void equals_correctly_compares_teams() {
        //check if team is equal to itself
        Team team1 = new Team("Team 1");
        team1.addMember("bob");
        assertTrue(team1.equals(team1), "A team object should be equal to itself.");

        //check if different classes
        Team team2 = new Team("Team 2");
        team1.addMember("bob");
        String notATeam = "Not a Team";
        assertFalse(team2.equals(notATeam), "A Team should not be equal to an object of a different class.");

        //check if both teams and have same data
        Team team3 = new Team("Team 3");
        team3.addMember("bob");

        Team team4 = new Team("Team 3");
        team4.addMember("bob");

        assertTrue(team3.equals(team4), "Two team objects with the same data should be equal.");

        //check if both teams and have different data

        //same name but different members
        Team team5 = new Team("Team 5");
        team5.addMember("bob");

        Team team6 = new Team("Team 5");
        team6.addMember("foo");

        assertFalse(team5.equals(team6), "Two team objects with different data should not be equal.");

        //same members but different names
        Team team7 = new Team("Team 7");
        team7.addMember("bob");

        Team team8 = new Team("Team 8");
        team8.addMember("bob");


        //different names and members
        Team team9 = new Team("Team 9");
        team9.addMember("bob");

        Team team10 = new Team("Team 10");
        team10.addMember("foo");

        assertFalse(team9.equals(team10), "Two team objects with different data should not be equal.");
    }


    @Test
    public void hashcode_returns_correct_hashcode() {
        Team team1 = new Team("Team 1");
        team1.addMember("bob");

        Team team2 = new Team("Team 1");
        team2.addMember("bob");

        assertEquals(team1.hashCode(), team2.hashCode(), "Two team objects with the same data should have the same hashcode.");
        
        Team team3 = new Team("Team 3");
        team3.addMember("bob");
        int result = team3.hashCode();
        int expectedResult = -1793753132;
        assertEquals(expectedResult, result);
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
