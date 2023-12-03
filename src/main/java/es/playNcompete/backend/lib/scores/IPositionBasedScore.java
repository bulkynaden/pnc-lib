package es.playNcompete.backend.lib.scores;

public interface IPositionBasedScore extends IFreeForAllScore {
    int getPosition();

    void setPosition(int position);
}