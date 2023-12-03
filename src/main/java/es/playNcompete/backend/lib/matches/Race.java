package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.results.IPointsBasedResult;
import es.playNcompete.backend.lib.scores.IRaceScore;
import es.playNcompete.backend.lib.tournaments.ITournament;
import lombok.NonNull;

public abstract class Race<T extends IRaceScore> extends PositionBasedMatch<T, IPointsBasedResult> implements IRace<T> {
    public Race(@NonNull IVenue venue, @NonNull ITournament tournament) {
        super(venue, tournament);
    }
}