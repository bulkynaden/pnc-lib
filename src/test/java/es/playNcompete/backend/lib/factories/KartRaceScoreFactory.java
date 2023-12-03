package es.playNcompete.backend.lib.factories;

import es.playNcompete.backend.lib.participants.Participant;
import es.playNcompete.backend.lib.scores.KartRaceScore;

import java.time.Duration;

public class KartRaceScoreFactory {
    public static KartRaceScore create() {
        return new KartRaceScore(ParticipantFactory.createIndividual());
    }

    public static KartRaceScore create(Participant participant) {
        return new KartRaceScore(participant);
    }

    public static KartRaceScore create(Participant participant, Duration bestLapTime, boolean isDisqualified) {
        return new KartRaceScore(participant, bestLapTime, isDisqualified);
    }

    public static KartRaceScore create(Participant participant, int position, Duration bestLapTime, boolean isDisqualified) {
        return new KartRaceScore(participant, position, bestLapTime, isDisqualified);
    }
}