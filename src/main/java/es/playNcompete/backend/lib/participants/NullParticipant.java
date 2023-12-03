package es.playNcompete.backend.lib.participants;

import es.playNcompete.backend.lib.match_participants.IMatchParticipant;
import es.playNcompete.backend.lib.team_participants.ITeamParticipant;
import es.playNcompete.backend.lib.tournament_participants.ITournamentParticipant;
import lombok.NonNull;

import java.util.Collection;
import java.util.HashSet;

public class NullParticipant implements IParticipant {
    @Override
    public String getName() {
        return "Not found";
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public Collection<IMatchParticipant> getMatchParticipants() {
        return new HashSet<>();
    }

    @Override
    public void addMatchParticipant(@NonNull IMatchParticipant matchParticipant) {

    }

    @Override
    public void removeMatchParticipant(@NonNull IMatchParticipant matchParticipant) {

    }

    @Override
    public Collection<ITournamentParticipant> getTournamentParticipants() {
        return new HashSet<>();
    }

    @Override
    public void addTournamentParticipant(@NonNull ITournamentParticipant participant) {

    }

    @Override
    public void removeTournamentParticipant(@NonNull ITournamentParticipant participant) {

    }

    @Override
    public Collection<ITeamParticipant> getTeamParticipants() {
        return new HashSet<>();
    }

    @Override
    public void addTeamParticipant(@NonNull ITeamParticipant participant) {

    }

    @Override
    public void removeTeamParticipant(@NonNull ITeamParticipant participant) {

    }
}