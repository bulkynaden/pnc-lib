package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IScore;

public abstract class ScoringStrategy<T extends IScore, R extends IResult> implements IScoringStrategy<T, R> {
}