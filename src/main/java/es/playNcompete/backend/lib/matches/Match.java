package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.exceptions.ParticipantNotInMatchException;
import es.playNcompete.backend.lib.exceptions.ParticipantNotInTournamentException;
import es.playNcompete.backend.lib.exceptions.TransitionConstraintException;
import es.playNcompete.backend.lib.match_participants.IMatchParticipant;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IScore;
import es.playNcompete.backend.lib.tournaments.ITournament;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public abstract class Match<T extends IScore, R extends IResult> implements IMatch<T, R> {
    private static final MatchState DEFAULT_STATE = MatchState.SCHEDULED;
    private Collection<IMatchParticipant> matchParticipants = new HashSet<>();
    @Setter
    @EqualsAndHashCode.Exclude
    private IVenue venue;
    @Setter
    private ZonedDateTime date;
    @NonNull
    @EqualsAndHashCode.Exclude
    private ITournament tournament;
    @Setter
    @EqualsAndHashCode.Exclude
    private R result;
    @NonNull
    private MatchState state;
    @Setter
    @EqualsAndHashCode.Exclude
    private Set<T> scores = new HashSet<>();

    public Match(@NonNull IVenue venue, @NonNull ITournament tournament) {
        this(venue, null, tournament, null);
    }

    public Match(@NonNull IVenue venue, ZonedDateTime date, @NonNull ITournament tournament, R result) {
        setVenue(venue);
        setDate(date);
        setTournament(tournament);
        setResult(result);
        updateResult();
        this.state = DEFAULT_STATE;
    }

    @Override
    public void setTournament(@NonNull ITournament tournament) {
        if (this.tournament != tournament) {
            this.tournament = tournament;
            this.tournament.addMatch(this);
        }
    }

    @Override
    public void setState(@NonNull MatchState state) {
        if (getState().canTransitionTo(state)) {
            this.state = state;
        } else {
            throw new TransitionConstraintException(this.state.getName(), state.getName());
        }
    }

    @Override
    public void addMatchParticipant(@NonNull IMatchParticipant matchParticipant) {
        if (!tournament.getParticipants().contains(matchParticipant.getParticipant())) {
            throw new ParticipantNotInTournamentException(matchParticipant.getParticipant().getName());
        }

        matchParticipants.add(matchParticipant);
        if (!matchParticipant.getMatch().equals(this)) {
            matchParticipant.setMatch(this);
        }
    }

    @Override
    public void removeMatchParticipant(@NonNull IMatchParticipant matchParticipant) {
        if (!tournament.getParticipants().contains(matchParticipant.getParticipant())) {
            throw new ParticipantNotInTournamentException(matchParticipant.getParticipant().getName());
        }

        matchParticipants.remove(matchParticipant);
        if (matchParticipant.getParticipant().getMatchParticipants().contains(matchParticipant)) {
            matchParticipant.getParticipant().removeMatchParticipant(matchParticipant);
        }
    }

    @Override
    public void addScore(@NonNull T score) {
        if (matchParticipants.stream().noneMatch(iMatchParticipant -> iMatchParticipant.getParticipant().equals(score.getParticipant()))) {
            throw new ParticipantNotInMatchException(score.getParticipant().getName());
        }
        scores.add(score);
        updateResult();
    }

    @Override
    public void removeScore(@NonNull T score) {
        if (matchParticipants.stream().noneMatch(iMatchParticipant -> iMatchParticipant.getParticipant().equals(score.getParticipant()))) {
            throw new ParticipantNotInMatchException(score.getParticipant().getName());
        }
        scores.remove(score);
        updateResult();
    }

    private void updateResult() {
        setResult(getScoringStrategy().calculateResult(this));
    }
}