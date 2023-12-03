package es.playNcompete.backend.lib.participants;

import es.playNcompete.backend.lib.matches.IMatch;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IScore;
import lombok.NonNull;

public interface IMatchHolder {
    <T extends IScore, R extends IResult> IMatch<T, R> getMatch();

    <T extends IScore, R extends IResult> void setMatch(@NonNull IMatch<T, R> match);

    void removeMatch();
}