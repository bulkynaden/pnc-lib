package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.matches.IMatch;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IScore;

public interface IScoringStrategy<T extends IScore, R extends IResult> {
    R calculateResult(IMatch<T, R> match);
}