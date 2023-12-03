package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scoring_strategy.ChessGameScoringStrategy;
import es.playNcompete.backend.lib.scoring_strategy.IScoringStrategy;
import es.playNcompete.backend.lib.tournaments.ITournament;
import lombok.NonNull;

/**
 * A chess game is a one vs one match.
 */
public class ChessGame extends OneVsOneMatch<IChessScore, IResult> implements IChessGame {

    /**
     * Creates a new chess game.
     *
     * @param venue      The venue where the match is played.
     *                   It cannot be null.
     * @param tournament The tournament where the match is played.
     *                   It cannot be null.
     */
    public ChessGame(@NonNull IVenue venue, @NonNull ITournament tournament) {
        super(venue, tournament);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IScoringStrategy<IChessScore, IResult> getScoringStrategy() {
        return ChessGameScoringStrategy.getInstance();
    }
}