package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.results.IPointsBasedResult;
import es.playNcompete.backend.lib.scores.IRaceScore;

public interface IRace<T extends IRaceScore> extends IPositionBasedMatch<T, IPointsBasedResult> {
}