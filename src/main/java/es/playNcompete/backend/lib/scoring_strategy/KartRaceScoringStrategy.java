package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.scores.IKartRaceScore;

public class KartRaceScoringStrategy extends RaceScoringStrategy<IKartRaceScore> implements IKartRaceScoringStrategy<IKartRaceScore> {
    public static final KartRaceScoringStrategy INSTANCE = new KartRaceScoringStrategy();
    private static final int DEFAULT_MAX_POINTS = 45;
    private static final int DEFAULT_POINTS_DECREASE = 5;
    private static final int DEFAULT_POINTS_BEST_LAP = 1;

    private KartRaceScoringStrategy() {
        super(DEFAULT_MAX_POINTS, DEFAULT_POINTS_DECREASE, DEFAULT_POINTS_BEST_LAP);
    }

    public static KartRaceScoringStrategy getInstance() {
        return INSTANCE;
    }
}