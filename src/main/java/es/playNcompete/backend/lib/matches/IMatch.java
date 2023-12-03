package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.match_participants.IMatchParticipant;
import es.playNcompete.backend.lib.match_participants.IMatchParticipantCollectionHolder;
import es.playNcompete.backend.lib.participants.IParticipant;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IScore;
import es.playNcompete.backend.lib.scoring_strategy.IScoringStrategy;
import es.playNcompete.backend.lib.tournaments.ITournamentHolder;
import lombok.NonNull;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Set;

public interface IMatch<T extends IScore, R extends IResult> extends IMatchParticipantCollectionHolder, ITournamentHolder {
    IVenue getVenue();

    void setVenue(IVenue venue);

    ZonedDateTime getDate();

    void setDate(ZonedDateTime date);

    Set<T> getScores();

    void setScores(Set<T> scores);

    void addScore(@NonNull T score);

    void removeScore(@NonNull T score);

    R getResult();

    void setResult(@NonNull R result);

    IScoringStrategy<T, R> getScoringStrategy();

    MatchState getState();

    void setState(@NonNull MatchState state);

    default Collection<IParticipant> getParticipants() {
        return getMatchParticipants()
                .stream()
                .map(IMatchParticipant::getParticipant)
                .collect(java.util.stream.Collectors.toList());
    }
}