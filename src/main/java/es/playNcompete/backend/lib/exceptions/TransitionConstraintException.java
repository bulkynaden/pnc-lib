package es.playNcompete.backend.lib.exceptions;

public class TransitionConstraintException extends RuntimeException {
    public TransitionConstraintException(String fromState, String toState) {
        super("Cannot transition from " + fromState + " to " + toState);
    }
}