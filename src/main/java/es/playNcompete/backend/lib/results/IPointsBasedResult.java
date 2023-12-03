package es.playNcompete.backend.lib.results;

import es.playNcompete.backend.lib.participants.IParticipant;

import java.util.Map;

public interface IPointsBasedResult extends IResult {
    Map<IParticipant, Integer> getPointsPerParticipant();

    void setPointsPerParticipant(Map<IParticipant, Integer> pointsPerParticipant);

    void addPointsToParticipant(IParticipant participant, Integer points);

    void removePointsToParticipant(IParticipant participant);
}