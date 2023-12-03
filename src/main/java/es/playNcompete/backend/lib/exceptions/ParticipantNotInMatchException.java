package es.playNcompete.backend.lib.exceptions;

public class ParticipantNotInMatchException extends RuntimeException {
    public ParticipantNotInMatchException(String name) {
        super("Participant " + name + " is not in the match");
    }
}