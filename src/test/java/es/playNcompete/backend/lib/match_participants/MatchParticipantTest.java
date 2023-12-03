package es.playNcompete.backend.lib.match_participants;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.exceptions.ParticipantNotInTournamentException;
import es.playNcompete.backend.lib.factories.*;
import es.playNcompete.backend.lib.matches.KartRace;
import es.playNcompete.backend.lib.participants.IParticipant;
import es.playNcompete.backend.lib.tournament_participants.ITournamentParticipant;
import es.playNcompete.backend.lib.tournaments.ITournament;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchParticipantTest {
    private KartRace kartRace1;
    private KartRace kartRace2;
    private IParticipant participant1;
    private IParticipant participant2;
    private IMatchParticipant matchParticipant;
    private IVenue venue;
    private ITournament tournament;
    private ITournamentParticipant tournamentParticipant;

    @BeforeEach
    public void setUp() {
        tournament = TournamentFactory.createKartTournament();
        participant1 = ParticipantFactory.createIndividual();
        participant2 = ParticipantFactory.createIndividual();
        tournamentParticipant = TournamentParticipantFactory.createTournamentParticipant(tournament, participant1);
        venue = VenueFactory.createVenue();
        kartRace1 = KartRaceFactory.create(venue, tournament);
        kartRace2 = KartRaceFactory.create(venue, tournament);
        matchParticipant = MatchParticipantFactory.createMatchParticipant(kartRace1, participant1);
    }

    @Test
    public void testAddMatchParticipant() {
        tournament.addTournamentParticipant(tournamentParticipant);
        kartRace1.addMatchParticipant(matchParticipant);
        assertTrue(kartRace1.getMatchParticipants().contains(matchParticipant));
    }

    @Test
    public void testRemoveMatchParticipant() {
        tournament.addTournamentParticipant(tournamentParticipant);
        kartRace1.addMatchParticipant(matchParticipant);
        assertTrue(kartRace1.getMatchParticipants().contains(matchParticipant));
        kartRace1.removeMatchParticipant(matchParticipant);
        assertFalse(kartRace1.getMatchParticipants().contains(matchParticipant));
    }

    @Test
    public void testAddRemoveInvalidMatchParticipant() {
        assertThrows(ParticipantNotInTournamentException.class, () -> kartRace1.addMatchParticipant(MatchParticipantFactory.createMatchParticipant(kartRace1, ParticipantFactory.createIndividual())));
        assertThrows(ParticipantNotInTournamentException.class, () -> kartRace1.removeMatchParticipant(MatchParticipantFactory.createMatchParticipant(kartRace1, ParticipantFactory.createIndividual())));
    }

    @Test
    public void testSetMatch() {
        tournament.addTournamentParticipant(tournamentParticipant);
        matchParticipant.setMatch(kartRace1);
        assertEquals(kartRace1, matchParticipant.getMatch());
        assertTrue(kartRace1.getMatchParticipants().contains(matchParticipant));

        matchParticipant.setMatch(kartRace2);
        assertNotEquals(kartRace1, matchParticipant.getMatch());
        assertFalse(kartRace1.getMatchParticipants().contains(matchParticipant));
        assertEquals(kartRace2, matchParticipant.getMatch());
        assertTrue(kartRace2.getMatchParticipants().contains(matchParticipant));
    }

    @Test
    public void testSetInvalidMatch() {
        assertThrows(ParticipantNotInTournamentException.class, () -> matchParticipant.setMatch(KartRaceFactory.create(venue, TournamentFactory.createKartTournament())));
    }

    @Test
    public void testSetParticipant() {
        tournament.addTournamentParticipant(tournamentParticipant);
        assertEquals(participant1, matchParticipant.getParticipant());
        assertTrue(participant1.getMatchParticipants().contains(matchParticipant));

        matchParticipant.setParticipant(participant2);
        assertNotEquals(participant1, matchParticipant.getParticipant());
        assertFalse(participant1.getMatchParticipants().contains(matchParticipant));
        assertEquals(participant2, matchParticipant.getParticipant());
        assertTrue(participant2.getMatchParticipants().contains(matchParticipant));
    }

    @Test
    public void testSetInvalidParticipant() {
        assertThrows(ParticipantNotInTournamentException.class, () -> matchParticipant.setMatch(KartRaceFactory.create(venue, TournamentFactory.createKartTournament())));
    }
}