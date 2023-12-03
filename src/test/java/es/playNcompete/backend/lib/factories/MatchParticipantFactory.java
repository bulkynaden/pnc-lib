package es.playNcompete.backend.lib.factories;

import es.playNcompete.backend.lib.match_participants.MatchParticipant;
import es.playNcompete.backend.lib.matches.IMatch;
import es.playNcompete.backend.lib.participants.IParticipant;

public class MatchParticipantFactory {
    public static MatchParticipant createMatchParticipant(IMatch<?, ?> match, IParticipant participant) {
        return new MatchParticipant(match, participant);
    }
}