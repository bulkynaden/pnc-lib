package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IPositionBasedScore;
import es.playNcompete.backend.lib.tournaments.ITournament;
import lombok.NonNull;

public abstract class PositionBasedMatch<T extends IPositionBasedScore, R extends IResult> extends FreeForAllMatch<T, R> implements IPositionBasedMatch<T, R> {
    public PositionBasedMatch(@NonNull IVenue venue, @NonNull ITournament tournament) {
        super(venue, tournament);
    }

    @Override
    public void addScore(@NonNull T score) {
        processNewScorePosition(score);
        super.addScore(score);
    }

    @Override
    public void removeScore(@NonNull T score) {
        adjustPositionsAfterRemoval(score.getPosition());
        super.removeScore(score);
    }

    private void processNewScorePosition(T score) {
        if (score.getPosition() == 0) {
            score.setPosition(determineLastPosition() + 1);
        } else {
            adjustPositionsForNewEntry(score.getPosition());
        }
    }

    private void adjustPositionsForNewEntry(int position) {
        getScores()
                .stream()
                .filter(s -> s.getPosition() >= position)
                .forEach(s -> s.setPosition(s.getPosition() + 1));
    }

    private void adjustPositionsAfterRemoval(int position) {
        getScores()
                .stream()
                .filter(s -> s.getPosition() > position)
                .forEach(s -> s.setPosition(s.getPosition() - 1));
    }

    private int determineLastPosition() {
        return getScores()
                .stream()
                .mapToInt(IPositionBasedScore::getPosition)
                .max().orElse(0);
    }
}