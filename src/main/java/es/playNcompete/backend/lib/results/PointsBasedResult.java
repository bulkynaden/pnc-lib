package es.playNcompete.backend.lib.results;

import es.playNcompete.backend.lib.participants.IParticipant;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * A {@link Result} that is based on points.
 */
@Getter
public class PointsBasedResult extends Result implements IPointsBasedResult {
    @Setter
    private Map<IParticipant, Integer> pointsPerParticipant = new HashMap<>();

    /**
     * Adds points to a participant.
     *
     * @param participant The participant to add points to.
     * @param points      The points to add.
     */
    @Override
    public void addPointsToParticipant(IParticipant participant, Integer points) {
        pointsPerParticipant.put(participant, points);
    }

    /**
     * Removes points from a participant.
     *
     * @param participant The participant to remove points from.
     */
    @Override
    public void removePointsToParticipant(IParticipant participant) {
        pointsPerParticipant.remove(participant);
    }
}