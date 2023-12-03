package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.participants.IParticipant;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IOneVsOneScore;

public interface IOneVsOneMatch<T extends IOneVsOneScore, R extends IResult> extends IMatch<T, R> {
    IParticipant getLocal();

    IParticipant getVisitor();
}