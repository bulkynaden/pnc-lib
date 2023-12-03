package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IOneVsOneScore;

public interface IOneVsOneScoringStrategy<T extends IOneVsOneScore, R extends IResult> extends IScoringStrategy<T, R> {
}