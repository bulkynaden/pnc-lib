package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IPositionBasedScore;

public interface IPositionBasedScoringStrategy<T extends IPositionBasedScore, R extends IResult> extends IFreeForAllScoringStrategy<T, R> {
}