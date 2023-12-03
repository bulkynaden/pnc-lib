package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.results.IPointsBasedResult;
import es.playNcompete.backend.lib.scores.IRaceScore;

public interface IRaceScoringStrategy<T extends IRaceScore> extends IPositionBasedScoringStrategy<T, IPointsBasedResult> {
    int getMaxPoints();

    void setMaxPoints(int maxPoints);

    int getPointsDecrease();

    void setPointsDecrease(int pointsDecrease);

    int getPointsBestLap();

    void setPointsBestLap(int pointsBestLap);

    int getPointsForPosition(int position);
}