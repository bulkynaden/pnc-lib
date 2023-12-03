package es.playNcompete.backend.lib.tournaments;

import lombok.NonNull;

import java.util.Collection;

public interface ITournamentCollectionHolder {
    Collection<ITournament> getTournaments();

    default <T extends ITournament> void setTournaments(Collection<T> tournaments) {
        tournaments.forEach(this::addTournament);
    }

    void addTournament(@NonNull ITournament tournament);

    void removeTournament(@NonNull ITournament tournament);
}