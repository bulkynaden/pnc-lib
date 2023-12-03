package es.playNcompete.backend.lib.factories;

import es.playNcompete.backend.lib.Venue;
import es.playNcompete.backend.lib.matches.KartRace;
import es.playNcompete.backend.lib.tournaments.Tournament;

public class KartRaceFactory {
    public static KartRace create(Venue venue, Tournament tournament) {
        return new KartRace(venue, tournament);
    }
}