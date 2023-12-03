package es.playNcompete.backend.lib.exceptions;

/**
 * Exception thrown when trying to set the local participant when it is already set.
 */
public class LocalParticipantAlreadySetException extends RuntimeException {
    public LocalParticipantAlreadySetException() {
        super("Local participant is already set");
    }
}