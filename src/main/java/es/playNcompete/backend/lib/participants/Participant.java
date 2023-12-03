package es.playNcompete.backend.lib.participants;

import es.playNcompete.backend.lib.match_participants.IMatchParticipant;
import es.playNcompete.backend.lib.team_participants.ITeamParticipant;
import es.playNcompete.backend.lib.tournament_participants.ITournamentParticipant;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;

@Getter
public abstract class Participant implements IParticipant {
    @EqualsAndHashCode.Exclude
    private final Collection<ITournamentParticipant> tournamentParticipants = new HashSet<>();
    @EqualsAndHashCode.Exclude
    private final Collection<IMatchParticipant> matchParticipants = new HashSet<>();
    @EqualsAndHashCode.Exclude
    private final Collection<ITeamParticipant> teamParticipants = new HashSet<>();
    @Setter
    private String name;

    @Override
    public void addMatchParticipant(@NonNull IMatchParticipant matchParticipant) {
        matchParticipants.add(matchParticipant);
        if (matchParticipant.getParticipant() != this) {
            matchParticipant.setParticipant(this);
        }
    }

    @Override
    public void removeMatchParticipant(@NonNull IMatchParticipant matchParticipant) {
        matchParticipants.remove(matchParticipant);
    }

    @Override
    public void addTournamentParticipant(@NonNull ITournamentParticipant tournamentParticipant) {
        this.tournamentParticipants.add(tournamentParticipant);
        if (!tournamentParticipant.getParticipant().equals(this)) {
            tournamentParticipant.setParticipant(this);
        }
    }

    @Override
    public void removeTournamentParticipant(@NonNull ITournamentParticipant tournamentParticipant) {
        this.tournamentParticipants.remove(tournamentParticipant);
    }

    @Override
    public void addTeamParticipant(@NonNull ITeamParticipant teamParticipant) {
        this.teamParticipants.add(teamParticipant);
        if (!teamParticipant.getParticipant().equals(this)) {
            teamParticipant.setParticipant(this);
        }
    }

    @Override
    public void removeTeamParticipant(@NonNull ITeamParticipant teamParticipant) {
        this.teamParticipants.remove(teamParticipant);
    }
}