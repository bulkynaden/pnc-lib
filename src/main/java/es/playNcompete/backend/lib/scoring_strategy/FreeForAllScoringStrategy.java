package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IFreeForAllScore;

public abstract class FreeForAllScoringStrategy<T extends IFreeForAllScore, R extends IResult> extends ScoringStrategy<T, R> implements IFreeForAllScoringStrategy<T, R> {
}