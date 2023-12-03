package es.playNcompete.backend.lib.factories;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.matches.KartRace;
import es.playNcompete.backend.lib.tournaments.ITournament;

public class KartRaceFactory {
    public static KartRace create(IVenue venue, ITournament tournament) {
        return new KartRace(venue, tournament);
    }
}