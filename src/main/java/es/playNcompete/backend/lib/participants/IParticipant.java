package es.playNcompete.backend.lib.participants;

import es.bulkynaden.common.helpers.name.IName;
import es.playNcompete.backend.lib.match_participants.IMatchParticipant;
import es.playNcompete.backend.lib.match_participants.IMatchParticipantCollectionHolder;
import es.playNcompete.backend.lib.matches.IMatch;
import es.playNcompete.backend.lib.team.ITeam;
import es.playNcompete.backend.lib.team_participants.ITeamParticipant;
import es.playNcompete.backend.lib.team_participants.ITeamParticipantCollectionHolder;
import es.playNcompete.backend.lib.tournament_participants.ITournamentParticipant;
import es.playNcompete.backend.lib.tournament_participants.ITournamentParticipantCollectionHolder;
import es.playNcompete.backend.lib.tournaments.ITournament;

import java.util.Collection;
import java.util.stream.Collectors;

public interface IParticipant extends IName, ITournamentParticipantCollectionHolder, IMatchParticipantCollectionHolder, ITeamParticipantCollectionHolder {
    default Collection<ITournament> getTournaments() {
        return getTournamentParticipants()
                .stream()
                .map(ITournamentParticipant::getTournament)
                .collect(Collectors.toSet());
    }

    default Collection<ITeam> getTeams() {
        return getTeamParticipants()
                .stream()
                .map(ITeamParticipant::getTeam)
                .collect(Collectors.toSet());
    }

    default Collection<IMatch<?, ?>> getMatches() {
        return getMatchParticipants()
                .stream()
                .map(IMatchParticipant::getMatch)
                .collect(Collectors.toSet());
    }
}