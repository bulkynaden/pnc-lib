package es.playNcompete.backend.lib.scores;

import es.playNcompete.backend.lib.participants.IParticipant;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class PositionBasedScore extends FreeForAllScore implements IPositionBasedScore {
    @Setter
    private int position;

    public PositionBasedScore(@NonNull IParticipant participant) {
        this(participant, 0, false);
    }

    public PositionBasedScore(IParticipant participant, int position, boolean isDisqualified) {
        super(participant, isDisqualified);
        setPosition(position);
    }
}