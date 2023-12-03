package es.playNcompete.backend.lib.match_participants;

import es.playNcompete.backend.lib.exceptions.ObjectCantBeRemovedException;
import es.playNcompete.backend.lib.matches.IMatch;
import es.playNcompete.backend.lib.participants.IParticipant;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IScore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class MatchParticipant implements IMatchParticipant {
    @EqualsAndHashCode.Exclude
    private IMatch<?, ?> match;
    @EqualsAndHashCode.Exclude
    private IParticipant participant;

    public MatchParticipant(@NonNull IMatch<?, ?> match, @NonNull IParticipant participant) {
        setParticipant(participant);
        setMatch(match);
    }

    @Override
    public <T extends IScore, R extends IResult> void setMatch(@NonNull IMatch<T, R> match) {
        if (this.match != match) {
            if (this.match != null) {
                this.match.removeMatchParticipant(this);
            }
            this.match = match;
            match.addMatchParticipant(this);
        }
    }

    @Override
    public void removeMatch() {
        throw new ObjectCantBeRemovedException("Match");
    }

    @Override
    public void setParticipant(@NonNull IParticipant participant) {
        if (this.participant != participant) {
            if (this.participant != null) {
                this.participant.removeMatchParticipant(this);
            }
            this.participant = participant;
            this.participant.addMatchParticipant(this);
        }
    }

    @Override
    public void removeParticipant() {
        throw new ObjectCantBeRemovedException("Participant");
    }
}