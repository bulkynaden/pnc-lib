package es.playNcompete.backend.lib.scores;

import es.playNcompete.backend.lib.participants.IParticipant;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.Duration;

@Getter
public abstract class RaceScore extends PositionBasedScore implements IRaceScore {
    @Setter
    private Duration bestLapTime;

    public RaceScore(@NonNull IParticipant participant) {
        this(participant, 0, Duration.ZERO, false);
    }

    public RaceScore(IParticipant participant, int position, Duration bestLapTime, boolean isDisqualified) {
        super(participant, position, isDisqualified);
        setBestLapTime(bestLapTime);
    }
}