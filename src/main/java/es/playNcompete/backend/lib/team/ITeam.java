package es.playNcompete.backend.lib.team;

import es.playNcompete.backend.lib.participants.IParticipant;
import es.playNcompete.backend.lib.team_participants.ITeamParticipant;
import es.playNcompete.backend.lib.team_participants.ITeamParticipantCollectionHolder;

import java.util.Collection;
import java.util.stream.Collectors;

public interface ITeam extends ITeamParticipantCollectionHolder {
    default Collection<IParticipant> getParticipants() {
        return getTeamParticipants()
                .stream()
                .map(ITeamParticipant::getParticipant)
                .collect(Collectors.toSet());
    }
}