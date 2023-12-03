package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.results.IPointsBasedResult;
import es.playNcompete.backend.lib.scores.IKartRaceScore;
import es.playNcompete.backend.lib.scoring_strategy.IScoringStrategy;
import es.playNcompete.backend.lib.scoring_strategy.KartRaceScoringStrategy;
import es.playNcompete.backend.lib.tournaments.ITournament;
import lombok.NonNull;

public class KartRace extends Race<IKartRaceScore> implements IKartRace {
    public KartRace(@NonNull IVenue venue, @NonNull ITournament tournament) {
        super(venue, tournament);
    }

    @Override
    public IScoringStrategy<IKartRaceScore, IPointsBasedResult> getScoringStrategy() {
        return KartRaceScoringStrategy.getInstance();
    }
}