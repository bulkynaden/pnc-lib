package es.playNcompete.backend.lib.scores;

/**
 * A score that is based on a position.
 */
public interface IPositionBasedScore extends IFreeForAllScore {
    /**
     * The position of the participant.
     *
     * @return The position of the participant.
     */
    int getPosition();

    /**
     * Sets the position of the participant.
     *
     * @param position The position of the participant.
     */
    void setPosition(int position);
}