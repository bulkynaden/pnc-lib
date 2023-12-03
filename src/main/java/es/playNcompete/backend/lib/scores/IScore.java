package es.playNcompete.backend.lib.scores;

import es.playNcompete.backend.lib.participants.IParticipantHolder;

public interface IScore extends IParticipantHolder {
    boolean isDisqualified();

    void setDisqualified(boolean isDisqualified);
}
