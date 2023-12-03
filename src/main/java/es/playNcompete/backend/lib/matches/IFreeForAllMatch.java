package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.match_participants.IMatchParticipantCollectionHolder;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IFreeForAllScore;

public interface IFreeForAllMatch<T extends IFreeForAllScore, R extends IResult> extends IMatch<T, R>, IMatchParticipantCollectionHolder {
}