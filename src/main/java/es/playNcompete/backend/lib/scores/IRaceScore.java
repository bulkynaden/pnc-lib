package es.playNcompete.backend.lib.scores;

import java.time.Duration;

public interface IRaceScore extends IPositionBasedScore {
    Duration getBestLapTime();

    void setBestLapTime(Duration bestLapTime);
}