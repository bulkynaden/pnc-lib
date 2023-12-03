package es.playNcompete.backend.lib.tournament_participants;

import es.playNcompete.backend.lib.exceptions.ObjectCantBeRemovedException;
import es.playNcompete.backend.lib.participants.IParticipant;
import es.playNcompete.backend.lib.tournaments.ITournament;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class TournamentParticipant implements ITournamentParticipant {
    @EqualsAndHashCode.Exclude
    private ITournament tournament;

    @EqualsAndHashCode.Exclude
    private IParticipant participant;

    public TournamentParticipant(@NonNull ITournament tournament, @NonNull IParticipant participant) {
        setTournament(tournament);
        setParticipant(participant);
    }

    @Override
    public void setTournament(@NonNull ITournament tournament) {
        if (this.tournament != tournament) {
            if (this.tournament != null) {
                this.tournament.removeTournamentParticipant(this);
            }
            this.tournament = tournament;
            this.tournament.addTournamentParticipant(this);
        }
    }

    @Override
    public void removeTournament() {
        throw new ObjectCantBeRemovedException("Tournament");
    }

    @Override
    public void setParticipant(@NonNull IParticipant participant) {
        if (this.participant != participant) {
            if (this.participant != null) {
                this.participant.removeTournamentParticipant(this);
            }
            this.participant = participant;
            this.participant.addTournamentParticipant(this);
        }
    }

    @Override
    public void removeParticipant() {
        throw new ObjectCantBeRemovedException("Participant");
    }
}