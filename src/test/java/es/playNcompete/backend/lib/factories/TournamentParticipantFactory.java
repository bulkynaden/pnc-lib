package es.playNcompete.backend.lib.factories;

import es.playNcompete.backend.lib.participants.Participant;
import es.playNcompete.backend.lib.tournament_participants.TournamentParticipant;
import es.playNcompete.backend.lib.tournaments.Tournament;

public class TournamentParticipantFactory {
    public static TournamentParticipant createTournamentParticipant(Tournament tournament, Participant participant) {
        return new TournamentParticipant(tournament, participant);
    }
}