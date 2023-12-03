package es.playNcompete.backend.lib.exceptions;

public class VisitorParticipantAlreadySetException extends RuntimeException {
    public VisitorParticipantAlreadySetException() {
        super("Visitor participant is already set");
    }
}