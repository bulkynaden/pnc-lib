package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.results.IPointsBasedResult;
import es.playNcompete.backend.lib.scores.IPositionBasedScore;

public abstract class PositionBasedScoringStrategy<T extends IPositionBasedScore, R extends IPointsBasedResult> extends FreeForAllScoringStrategy<T, R> implements IPositionBasedScoringStrategy<T, R> {
}