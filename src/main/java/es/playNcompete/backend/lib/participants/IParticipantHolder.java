package es.playNcompete.backend.lib.participants;

import lombok.NonNull;

public interface IParticipantHolder {
    IParticipant getParticipant();

    void setParticipant(@NonNull IParticipant participant);

    void removeParticipant();
}