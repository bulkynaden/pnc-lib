package es.playNcompete.backend.lib.tournament_participants;

import lombok.NonNull;

import java.util.Collection;

public interface ITournamentParticipantCollectionHolder {
    Collection<ITournamentParticipant> getTournamentParticipants();

    default <T extends ITournamentParticipant> void setTournamentParticipants(Collection<T> tournamentParticipants) {
        tournamentParticipants.forEach(this::addTournamentParticipant);
    }

    void addTournamentParticipant(@NonNull ITournamentParticipant tournamentParticipant);

    void removeTournamentParticipant(@NonNull ITournamentParticipant tournamentParticipant);
}