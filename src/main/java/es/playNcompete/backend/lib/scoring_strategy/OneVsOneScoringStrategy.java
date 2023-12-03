package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IOneVsOneScore;

public abstract class OneVsOneScoringStrategy<T extends IOneVsOneScore, R extends IResult> extends ScoringStrategy<T, R> implements IOneVsOneScoringStrategy<T, R> {
}