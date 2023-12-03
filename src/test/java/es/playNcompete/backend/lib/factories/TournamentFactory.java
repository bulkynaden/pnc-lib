package es.playNcompete.backend.lib.factories;

import es.playNcompete.backend.lib.tournaments.Tournament;

public class TournamentFactory {
    public static Tournament createKartTournament() {
        return new Tournament(SportFactory.createKartRacing());
    }
}