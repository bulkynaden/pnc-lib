package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.exceptions.LocalParticipantAlreadySetException;
import es.playNcompete.backend.lib.exceptions.MatchParticipantMustBeOneVsOneMatchParticipantException;
import es.playNcompete.backend.lib.exceptions.ObjectCantBeRemovedException;
import es.playNcompete.backend.lib.exceptions.VisitorParticipantAlreadySetException;
import es.playNcompete.backend.lib.match_participants.IMatchParticipant;
import es.playNcompete.backend.lib.match_participants.IOneVsOneMatchParticipant;
import es.playNcompete.backend.lib.participants.IParticipant;
import es.playNcompete.backend.lib.participants.IParticipantHolder;
import es.playNcompete.backend.lib.participants.NullParticipant;
import es.playNcompete.backend.lib.results.IResult;
import es.playNcompete.backend.lib.scores.IOneVsOneScore;
import es.playNcompete.backend.lib.tournaments.ITournament;
import lombok.Getter;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Getter
public abstract class OneVsOneMatch<T extends IOneVsOneScore, R extends IResult> extends Match<T, R> implements IOneVsOneMatch<T, R> {
    public OneVsOneMatch(@NonNull IVenue venue, @NonNull ITournament tournament) {
        this(venue, null, tournament, null);
    }

    public OneVsOneMatch(IVenue venue, ZonedDateTime date, @NonNull ITournament tournament, R result) {
        super(venue, date, tournament, result);
    }

    @Override
    public IParticipant getLocal() {
        return getMatchParticipants()
                .stream()
                .filter(matchParticipant -> matchParticipant instanceof IOneVsOneMatchParticipant)
                .map(matchParticipant -> (IOneVsOneMatchParticipant) matchParticipant)
                .filter(iOneVsOneMatchParticipant -> iOneVsOneMatchParticipant.getRole() == IOneVsOneMatchParticipant.Role.LOCAL)
                .findFirst()
                .map(IParticipantHolder::getParticipant)
                .orElseGet(NullParticipant::new);
    }

    @Override
    public IParticipant getVisitor() {
        return getMatchParticipants()
                .stream()
                .filter(matchParticipant -> matchParticipant instanceof IOneVsOneMatchParticipant)
                .map(matchParticipant -> (IOneVsOneMatchParticipant) matchParticipant)
                .filter(iOneVsOneMatchParticipant -> iOneVsOneMatchParticipant.getRole() == IOneVsOneMatchParticipant.Role.VISITOR)
                .findFirst()
                .map(IParticipantHolder::getParticipant)
                .orElseGet(NullParticipant::new);
    }

    @Override
    public void addMatchParticipant(@NonNull IMatchParticipant matchParticipant)
            throws MatchParticipantMustBeOneVsOneMatchParticipantException,
            LocalParticipantAlreadySetException,
            VisitorParticipantAlreadySetException {
        if (!(matchParticipant instanceof IOneVsOneMatchParticipant oneVsOneParticipant)) {
            throw new MatchParticipantMustBeOneVsOneMatchParticipantException();
        }

        if (oneVsOneParticipant.getRole() == IOneVsOneMatchParticipant.Role.LOCAL) {
            if (!(getLocal() instanceof NullParticipant)) {
                throw new LocalParticipantAlreadySetException();
            }
        } else if (oneVsOneParticipant.getRole() == IOneVsOneMatchParticipant.Role.VISITOR) {
            if (!(getVisitor() instanceof NullParticipant)) {
                throw new VisitorParticipantAlreadySetException();
            }
        }
        super.addMatchParticipant(matchParticipant);
    }

    @Override
    public void removeMatchParticipant(@NonNull IMatchParticipant matchParticipant)
            throws MatchParticipantMustBeOneVsOneMatchParticipantException {
        if (!(matchParticipant instanceof IOneVsOneMatchParticipant)) {
            throw new MatchParticipantMustBeOneVsOneMatchParticipantException();
        }
        super.removeMatchParticipant(matchParticipant);
    }

    @Override
    public void removeTournament() {
        throw new ObjectCantBeRemovedException("Tournament");
    }
}