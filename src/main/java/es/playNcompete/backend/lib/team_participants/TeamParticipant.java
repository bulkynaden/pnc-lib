package es.playNcompete.backend.lib.team_participants;

import es.playNcompete.backend.lib.exceptions.ObjectCantBeRemovedException;
import es.playNcompete.backend.lib.participants.IParticipant;
import es.playNcompete.backend.lib.team.ITeam;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamParticipant implements ITeamParticipant {
    @EqualsAndHashCode.Exclude
    @NonNull
    private ITeam team;
    @EqualsAndHashCode.Exclude
    @NonNull
    private IParticipant participant;

    @Override
    public void setTeam(@NonNull ITeam team) {
        if (this.team != team) {
            this.team.removeTeamParticipant(this);
            this.team = team;
            this.team.addTeamParticipant(this);
        }
    }

    @Override
    public void removeTeam() {
        throw new ObjectCantBeRemovedException("Team");
    }

    @Override
    public void setParticipant(@NonNull IParticipant participant) {
        if (this.participant != participant) {
            this.participant.removeTeamParticipant(this);
            this.participant = participant;
            this.participant.addTeamParticipant(this);
        }
    }

    @Override
    public void removeParticipant() {
        throw new ObjectCantBeRemovedException("Participant");
    }
}