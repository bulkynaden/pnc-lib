package es.playNcompete.backend.lib.exceptions;

public class LocalParticipantAlreadySetException extends RuntimeException {
    public LocalParticipantAlreadySetException() {
        super("Local participant is already set");
    }
}