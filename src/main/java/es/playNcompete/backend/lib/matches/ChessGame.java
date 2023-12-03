package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scoring_strategy.ChessGameScoringStrategy;
import es.playNcompete.backend.lib.scoring_strategy.IScoringStrategy;
import es.playNcompete.backend.lib.tournaments.ITournament;
import lombok.NonNull;

public class ChessGame extends OneVsOneMatch<IChessScore, IResult> implements IChessGame {
    public ChessGame(@NonNull IVenue venue, @NonNull ITournament tournament) {
        super(venue, tournament);
    }

    @Override
    public IScoringStrategy<IChessScore, IResult> getScoringStrategy() {
        return ChessGameScoringStrategy.getInstance();
    }
}