package es.playNcompete.backend.lib.tournaments;

import lombok.NonNull;

public interface ITournamentHolder {
    ITournament getTournament();

    void setTournament(@NonNull ITournament tournament);

    void removeTournament();
}