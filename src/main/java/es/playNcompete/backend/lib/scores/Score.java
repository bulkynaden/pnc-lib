package es.playNcompete.backend.lib.scores;

import es.playNcompete.backend.lib.exceptions.ObjectCantBeRemovedException;
import es.playNcompete.backend.lib.participants.IParticipant;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public abstract class Score implements IScore {
    private static final boolean DEFAULT_IS_DISQUALIFIED = false;
    private IParticipant participant;
    @Setter
    private boolean isDisqualified = DEFAULT_IS_DISQUALIFIED;

    public Score(@NonNull IParticipant participant) {
        this(participant, DEFAULT_IS_DISQUALIFIED);
    }

    public Score(IParticipant participant, boolean isDisqualified) {
        setParticipant(participant);
        setDisqualified(isDisqualified);
    }

    @Override
    public void setParticipant(@NonNull IParticipant participant) {
        if (this.participant != participant) {
            this.participant = participant;
        }
    }

    @Override
    public void removeParticipant() {
        throw new ObjectCantBeRemovedException("Participant");
    }
}