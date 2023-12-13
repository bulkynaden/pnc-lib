package es.playNcompete.backend.lib.tournaments;

import es.playNcompete.backend.lib.exceptions.ObjectCantBeRemovedException;
import es.playNcompete.backend.lib.exceptions.ParameterCantBeBlankException;
import es.playNcompete.backend.lib.matches.IMatch;
import es.playNcompete.backend.lib.sports.ISport;
import es.playNcompete.backend.lib.tournament_participants.ITournamentParticipant;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;

@Getter
public class Tournament implements ITournament {
    @EqualsAndHashCode.Exclude
    private final Collection<ITournamentParticipant> tournamentParticipants = new HashSet<>();
    @EqualsAndHashCode.Exclude
    private final Collection<IMatch<?, ?>> matches = new HashSet<>();
    @EqualsAndHashCode.Exclude
    private ISport sport;
    @Setter
    private String name;

    public Tournament(@NonNull ISport sport, @NonNull String name) {
        if (name.isBlank()) {
            throw new ParameterCantBeBlankException("name");
        }
        setSport(sport);
        setName(name);
    }

    @Override
    public void addTournamentParticipant(@NonNull ITournamentParticipant tournamentParticipant) {
        this.tournamentParticipants.add(tournamentParticipant);
        if (!tournamentParticipant.getTournament().equals(this)) {
            tournamentParticipant.setTournament(this);
        }
    }

    @Override
    public void removeTournamentParticipant(@NonNull ITournamentParticipant tournamentParticipant) {
        this.tournamentParticipants.remove(tournamentParticipant);
    }

    @Override
    public void addMatch(@NonNull IMatch<?, ?> match) {
        this.matches.add(match);
        if (!match.getTournament().equals(this)) {
            match.setTournament(this);
        }
    }

    @Override
    public void removeMatch(@NonNull IMatch<?, ?> match) {
        this.matches.remove(match);
        if (match.getTournament().equals(this)) {
            match.removeTournament();
        }
    }

    @Override
    public void setSport(@NonNull ISport sport) {
        if (this.sport != sport) {
            this.sport.removeTournament(this);
            this.sport = sport;
            this.sport.addTournament(this);
        }
    }

    @Override
    public void removeSport() {
        throw new ObjectCantBeRemovedException("Sport");
    }
}