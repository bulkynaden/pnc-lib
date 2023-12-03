package es.playNcompete.backend.lib.factories;

import es.playNcompete.backend.lib.participants.IParticipant;
import es.playNcompete.backend.lib.tournament_participants.TournamentParticipant;
import es.playNcompete.backend.lib.tournaments.ITournament;

public class TournamentParticipantFactory {
    public static TournamentParticipant createTournamentParticipant(ITournament tournament, IParticipant participant) {
        return new TournamentParticipant(tournament, participant);
    }
}