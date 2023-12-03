package es.playNcompete.backend.lib.team_participants;

import lombok.NonNull;

import java.util.Collection;

public interface ITeamParticipantCollectionHolder {
    Collection<ITeamParticipant> getTeamParticipants();

    default <T extends ITeamParticipant> void setTeamParticipants(Collection<T> teamParticipants) {
        teamParticipants.forEach(this::addTeamParticipant);
    }

    void addTeamParticipant(@NonNull ITeamParticipant teamParticipant);

    void removeTeamParticipant(@NonNull ITeamParticipant teamParticipant);
}