package es.playNcompete.backend.lib.scores;

import es.playNcompete.backend.lib.participants.IParticipant;
import lombok.NonNull;

import java.time.Duration;

public class KartRaceScore extends RaceScore implements IKartRaceScore {
    public KartRaceScore(@NonNull IParticipant participant) {
        this(participant, 0, Duration.ZERO, false);
    }

    public KartRaceScore(@NonNull IParticipant participant, Duration bestLapTime, boolean isDisqualified) {
        this(participant, 0, bestLapTime, isDisqualified);
    }

    public KartRaceScore(@NonNull IParticipant participant, int position, Duration bestLapTime, boolean isDisqualified) {
        super(participant, position, bestLapTime, isDisqualified);
    }
}