package es.playNcompete.backend.lib.tournaments;

import es.bulkynaden.common.helpers.name.IName;
import es.playNcompete.backend.lib.matches.IMatchCollectionHolder;
import es.playNcompete.backend.lib.participants.IParticipant;
import es.playNcompete.backend.lib.sports.ISportHolder;
import es.playNcompete.backend.lib.tournament_participants.ITournamentParticipant;
import es.playNcompete.backend.lib.tournament_participants.ITournamentParticipantCollectionHolder;

import java.util.Collection;
import java.util.stream.Collectors;

public interface ITournament extends IName, ISportHolder, IMatchCollectionHolder, ITournamentParticipantCollectionHolder {
    default Collection<IParticipant> getParticipants() {
        return getTournamentParticipants()
                .stream()
                .map(ITournamentParticipant::getParticipant)
                .collect(Collectors.toSet());
    }
}