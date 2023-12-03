package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IFreeForAllScore;

public interface IFreeForAllScoringStrategy<T extends IFreeForAllScore, R extends IResult> extends IScoringStrategy<T, R> {
}