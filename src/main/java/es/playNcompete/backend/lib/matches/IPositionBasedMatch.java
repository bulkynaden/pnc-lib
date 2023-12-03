package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IPositionBasedScore;

public interface IPositionBasedMatch<T extends IPositionBasedScore, R extends IResult> extends IFreeForAllMatch<T, R> {
}
