package es.playNcompete.backend.lib.team;

import es.playNcompete.backend.lib.participants.Participant;
import es.playNcompete.backend.lib.team_participants.ITeamParticipant;
import lombok.Getter;
import lombok.NonNull;

import java.util.Collection;
import java.util.HashSet;

@Getter
public class Team extends Participant implements ITeam {
    private final Collection<ITeamParticipant> teamParticipants = new HashSet<>();

    @Override
    public void addTeamParticipant(@NonNull ITeamParticipant teamParticipant) {
        teamParticipants.add(teamParticipant);
        if (!teamParticipant.getTeam().equals(this)) {
            teamParticipant.setTeam(this);
        }
    }

    @Override
    public void removeTeamParticipant(@NonNull ITeamParticipant teamParticipant) {
        teamParticipants.remove(teamParticipant);
    }
}