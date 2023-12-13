package es.playNcompete.backend.lib.tournaments;

import lombok.NonNull;

import java.util.Collection;

/**
 * The ITournamentCollectionHolder interface represents a collection holder for tournaments.
 * It provides methods to get tournaments, add a tournament, and remove a tournament.
 */
public interface ITournamentCollectionHolder {
    /**
     * Retrieves a collection of tournaments.
     *
     * @return A collection of tournaments.
     */
    Collection<ITournament> getTournaments();

    /**
     * Sets the tournaments in the collection holder.
     *
     * @param tournaments A collection of tournaments to set in the collection holder.
     * @param <T>         The type of tournaments that extend ITournament.
     */
    default <T extends ITournament> void setTournaments(Collection<T> tournaments) {
        tournaments.forEach(this::addTournament);
    }

    /**
     * Adds a tournament to the collection holder.
     *
     * @param tournament The tournament to be added.
     */
    void addTournament(@NonNull ITournament tournament);

    /**
     * Removes a tournament from the collection holder.
     *
     * @param tournament The tournament to be removed.
     * @throws NullPointerException if the tournament is null.
     */
    void removeTournament(@NonNull ITournament tournament);
}