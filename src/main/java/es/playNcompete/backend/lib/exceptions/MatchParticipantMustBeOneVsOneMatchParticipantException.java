package es.playNcompete.backend.lib.exceptions;

public class MatchParticipantMustBeOneVsOneMatchParticipantException extends RuntimeException {
    public MatchParticipantMustBeOneVsOneMatchParticipantException() {
        super("MatchParticipant must be an instance of OneVsOneMatchParticipant");
    }
}