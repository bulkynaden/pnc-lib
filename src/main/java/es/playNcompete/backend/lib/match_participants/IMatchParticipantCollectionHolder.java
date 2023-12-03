package es.playNcompete.backend.lib.match_participants;

import lombok.NonNull;

import java.util.Collection;

public interface IMatchParticipantCollectionHolder {
    Collection<IMatchParticipant> getMatchParticipants();

    default <S extends IMatchParticipant> void setMatchParticipants(Collection<S> matchParticipants) {
        matchParticipants.forEach(this::addMatchParticipant);
    }

    void addMatchParticipant(@NonNull IMatchParticipant matchParticipant);

    void removeMatchParticipant(@NonNull IMatchParticipant matchParticipant);
}