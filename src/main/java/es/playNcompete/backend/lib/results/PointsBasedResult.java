package es.playNcompete.backend.lib.results;

import es.playNcompete.backend.lib.participants.IParticipant;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class PointsBasedResult extends Result implements IPointsBasedResult {
    @Setter
    private Map<IParticipant, Integer> pointsPerParticipant = new HashMap<>();

    @Override
    public void addPointsToParticipant(IParticipant participant, Integer points) {
        pointsPerParticipant.put(participant, points);
    }

    @Override
    public void removePointsToParticipant(IParticipant participant) {
        pointsPerParticipant.remove(participant);
    }
}