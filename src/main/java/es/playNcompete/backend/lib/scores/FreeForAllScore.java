package es.playNcompete.backend.lib.scores;

import es.playNcompete.backend.lib.participants.IParticipant;
import lombok.NonNull;

public class FreeForAllScore extends Score implements IFreeForAllScore {
    public FreeForAllScore(@NonNull IParticipant participant) {
        this(participant, false);
    }

    public FreeForAllScore(IParticipant participant, boolean isDisqualified) {
        super(participant, isDisqualified);
    }
}