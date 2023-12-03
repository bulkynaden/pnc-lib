package es.playNcompete.backend.lib.scoring_strategy;

import es.playNcompete.backend.lib.matches.IChessScore;
import es.playNcompete.backend.lib.matches.IMatch;
import es.playNcompete.backend.lib.results.IResult;


public class ChessGameScoringStrategy extends OneVsOneScoringStrategy<IChessScore, IResult> implements IOneVsOneScoringStrategy<IChessScore, IResult> {
    public static final ChessGameScoringStrategy INSTANCE = new ChessGameScoringStrategy();

    private ChessGameScoringStrategy() {
    }

    public static ChessGameScoringStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public IResult calculateResult(IMatch<IChessScore, IResult> match) {
        return match.getResult();
    }
}