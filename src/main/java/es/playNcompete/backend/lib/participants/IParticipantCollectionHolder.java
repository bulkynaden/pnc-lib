package es.playNcompete.backend.lib.participants;

import java.util.Collection;

public interface IParticipantCollectionHolder {
    Collection<IParticipant> getParticipants();

    default <T extends IParticipant> void setParticipants(Collection<T> participants) {
        participants.forEach(this::addParticipant);
    }

    void addParticipant(IParticipant participant);

    void removeParticipant(IParticipant participant);
}