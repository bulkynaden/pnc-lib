package es.playNcompete.backend.lib.exceptions;

public class ParticipantNotInTournamentException extends RuntimeException {
    public ParticipantNotInTournamentException(String name) {
        super("Participant " + name + " is not in the tournament");
    }
}