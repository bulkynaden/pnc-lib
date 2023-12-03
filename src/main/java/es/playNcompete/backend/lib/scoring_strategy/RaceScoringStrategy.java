package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.matches.IMatch;
import es.playNcompete.backend.lib.results.IPointsBasedResult;
import es.playNcompete.backend.lib.results.PointsBasedResult;
import es.playNcompete.backend.lib.scores.IRaceScore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@AllArgsConstructor
public abstract class RaceScoringStrategy<T extends IRaceScore> extends PositionBasedScoringStrategy<T, IPointsBasedResult> implements IRaceScoringStrategy<T> {
    @Setter
    private int maxPoints;
    @Setter
    private int pointsDecrease;
    @Setter
    private int pointsBestLap;

    @Override
    public IPointsBasedResult calculateResult(IMatch<T, IPointsBasedResult> match) {
        IPointsBasedResult result = new PointsBasedResult();

        for (T score : match.getScores()) {
            int positionPoints = getPointsForPosition(score.getPosition());

            boolean isBestLap = isBestLap(match, score);

            int bestLapPoints = isBestLap ? pointsBestLap : 0;

            int totalPoints = positionPoints + bestLapPoints;

            if (score.isDisqualified()) {
                totalPoints = 0;
            }
            result.addPointsToParticipant(score.getParticipant(), totalPoints);
        }
        return result;
    }

    @Override
    public int getPointsForPosition(int position) {
        if (position <= 0) {
            return 0;
        }

        int points = maxPoints;
        int currentDecrease = pointsDecrease;

        for (int i = 1; i < position; i++) {
            points -= currentDecrease;
            if (currentDecrease > 1) {
                currentDecrease--;
            }
        }
        return points;
    }

    private boolean isBestLap(IMatch<T, IPointsBasedResult> match, IRaceScore score) {
        return !score.isDisqualified() && score.getBestLapTime() == getBestLap(match);
    }

    protected Duration getBestLap(IMatch<T, IPointsBasedResult> match) {
        Duration bestLap = null;
        for (T score : match.getScores()) {
            if (score.getBestLapTime() != null && !score.isDisqualified()) {
                if (bestLap == null) {
                    bestLap = score.getBestLapTime();
                } else {
                    if (score.getBestLapTime().compareTo(bestLap) < 0) {
                        bestLap = score.getBestLapTime();
                    }
                }
            }
        }
        return bestLap;
    }
}