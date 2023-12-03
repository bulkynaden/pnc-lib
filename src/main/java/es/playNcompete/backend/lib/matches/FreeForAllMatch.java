package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.exceptions.ObjectCantBeRemovedException;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IFreeForAllScore;
import es.playNcompete.backend.lib.tournaments.ITournament;
import lombok.Getter;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Getter
public abstract class FreeForAllMatch<T extends IFreeForAllScore, R extends IResult> extends Match<T, R> implements IFreeForAllMatch<T, R> {
    public FreeForAllMatch(@NonNull IVenue venue, @NonNull ITournament tournament) {
        this(venue, null, tournament, null);
    }

    public FreeForAllMatch(IVenue venue, ZonedDateTime date, @NonNull ITournament tournament, R result) {
        super(venue, date, tournament, result);
    }

    @Override
    public void removeTournament() {
        throw new ObjectCantBeRemovedException("Tournament");
    }
}