package es.playNcompete.backend.lib.factories;

import es.playNcompete.backend.lib.match_participants.MatchParticipant;
import es.playNcompete.backend.lib.matches.IMatch;
import es.playNcompete.backend.lib.participants.Participant;

public class MatchParticipantFactory {
    public static MatchParticipant createMatchParticipant(IMatch<?, ?> match, Participant participant) {
        return new MatchParticipant(match, participant);
    }
}