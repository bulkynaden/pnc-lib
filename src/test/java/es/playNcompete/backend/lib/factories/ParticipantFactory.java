package es.playNcompete.backend.lib.factories;

import es.playNcompete.backend.lib.participants.Individual;
import es.playNcompete.backend.lib.participants.Participant;
import es.playNcompete.backend.lib.team.Team;

public class ParticipantFactory {
    private static int individualCounter = 0;
    private static int teamCounter = 0;

    public static Participant createIndividual() {
        Individual individual = new Individual();
        individual.setName("Test Individual " + individualCounter++);
        return individual;
    }

    public static Participant createTeam() {
        Team team = new Team();
        team.setName("Test Team " + teamCounter++);
        return team;
    }
}