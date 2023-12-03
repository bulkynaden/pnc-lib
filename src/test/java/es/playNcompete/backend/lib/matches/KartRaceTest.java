package es.playNcompete.backend.lib.matches;

import es.playNcompete.backend.lib.Venue;
import es.playNcompete.backend.lib.exceptions.ParticipantNotInMatchException;
import es.playNcompete.backend.lib.exceptions.ParticipantNotInTournamentException;
import es.playNcompete.backend.lib.factories.*;
import es.playNcompete.backend.lib.match_participants.MatchParticipant;
import es.playNcompete.backend.lib.participants.Participant;
import es.playNcompete.backend.lib.scores.KartRaceScore;
import es.playNcompete.backend.lib.tournament_participants.TournamentParticipant;
import es.playNcompete.backend.lib.tournaments.Tournament;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class KartRaceTest {
    private Tournament tournament;
    private Participant participant;
    private Participant participant2;
    private Participant participant3;
    private Participant participant4;
    private TournamentParticipant tournamentParticipant;
    private TournamentParticipant tournamentParticipant2;
    private TournamentParticipant tournamentParticipant3;
    private TournamentParticipant tournamentParticipant4;
    private Venue venue;
    private KartRace kartRace;
    private MatchParticipant matchParticipant;
    private MatchParticipant matchParticipant2;
    private MatchParticipant matchParticipant3;
    private MatchParticipant matchParticipant4;
    private KartRaceScore score;
    private KartRaceScore score1;
    private KartRaceScore score2;
    private KartRaceScore score3;
    private KartRaceScore score4;

    @BeforeEach
    public void setUp() {
        tournament = TournamentFactory.createKartTournament();
        participant = ParticipantFactory.createIndividual();
        participant2 = ParticipantFactory.createIndividual();
        participant3 = ParticipantFactory.createIndividual();
        participant4 = ParticipantFactory.createIndividual();
        tournamentParticipant = TournamentParticipantFactory.createTournamentParticipant(tournament, participant);
        tournamentParticipant2 = TournamentParticipantFactory.createTournamentParticipant(tournament, participant2);
        tournamentParticipant3 = TournamentParticipantFactory.createTournamentParticipant(tournament, participant3);
        tournamentParticipant4 = TournamentParticipantFactory.createTournamentParticipant(tournament, participant4);
        venue = VenueFactory.createVenue();
        kartRace = KartRaceFactory.create(venue, tournament);
        matchParticipant = MatchParticipantFactory.createMatchParticipant(kartRace, participant);
        matchParticipant2 = MatchParticipantFactory.createMatchParticipant(kartRace, participant2);
        matchParticipant3 = MatchParticipantFactory.createMatchParticipant(kartRace, participant3);
        matchParticipant4 = MatchParticipantFactory.createMatchParticipant(kartRace, participant4);
        score = KartRaceScoreFactory.create();
    }

    @Test
    public void testAddMatchParticipant() {
        tournament.addTournamentParticipant(tournamentParticipant);
        kartRace.addMatchParticipant(matchParticipant);
        assertTrue(kartRace.getMatchParticipants().contains(matchParticipant));
    }

    @Test
    public void testRemoveMatchParticipant() {
        tournament.addTournamentParticipant(tournamentParticipant);
        kartRace.addMatchParticipant(matchParticipant);
        assertTrue(kartRace.getMatchParticipants().contains(matchParticipant));
        kartRace.removeMatchParticipant(matchParticipant);
        assertFalse(kartRace.getMatchParticipants().contains(matchParticipant));
    }

    @Test
    public void testAddRemoveInvalidMatchParticipant() {
        assertThrows(ParticipantNotInTournamentException.class, () -> kartRace.addMatchParticipant(MatchParticipantFactory.createMatchParticipant(kartRace, ParticipantFactory.createIndividual())));
        assertThrows(ParticipantNotInTournamentException.class, () -> kartRace.removeMatchParticipant(MatchParticipantFactory.createMatchParticipant(kartRace, ParticipantFactory.createIndividual())));
    }

    @Test
    public void testSetAndGetVenue() {
        kartRace.setVenue(venue);
        assertEquals(venue, kartRace.getVenue());
    }

    @Test
    public void testSetAndGetDate() {
        ZonedDateTime now = ZonedDateTime.now();
        kartRace.setDate(now);
        assertEquals(now, kartRace.getDate());
    }

    @Test
    public void testAddAndRemoveScore() {
        tournament.addTournamentParticipant(tournamentParticipant);
        kartRace.addMatchParticipant(matchParticipant);
        score = KartRaceScoreFactory.create(participant);
        kartRace.addScore(score);
        assertTrue(kartRace.getScores().contains(score));

        kartRace.removeScore(score);
        assertFalse(kartRace.getScores().contains(score));
    }

    @Test
    public void testAddAndRemoveScoreWithInvalidParticipant() {
        assertThrows(ParticipantNotInMatchException.class, () -> kartRace.addScore(score));
        assertThrows(ParticipantNotInMatchException.class, () -> kartRace.removeScore(score));
    }

    @Test
    void testDefaultState() {
        assertEquals(MatchState.SCHEDULED, kartRace.getState());
    }

    @Test
    void testResult() {
        addMatchParticipants();
        createScores();
        addScores();
        assertEquals(45, kartRace.getResult().getPointsPerParticipant().get(participant));
        assertEquals(41, kartRace.getResult().getPointsPerParticipant().get(participant2));
        assertEquals(36, kartRace.getResult().getPointsPerParticipant().get(participant3));
        assertEquals(0, kartRace.getResult().getPointsPerParticipant().get(participant4));
    }

    @Test
    void testResultWithoutPositions() {
        addMatchParticipants();
        createScoresWithoutPosition();
        addScores();
        assertEquals(45, kartRace.getResult().getPointsPerParticipant().get(participant));
        assertEquals(41, kartRace.getResult().getPointsPerParticipant().get(participant2));
        assertEquals(36, kartRace.getResult().getPointsPerParticipant().get(participant3));
        assertEquals(0, kartRace.getResult().getPointsPerParticipant().get(participant4));
    }

    @Test
    void testResultAddingIntermediateScores() {
        addMatchParticipants();
        createScoresWithPosition();

        kartRace.addScore(score1);
        assertEquals(46, kartRace.getResult().getPointsPerParticipant().get(participant));

        kartRace.addScore(score2);
        assertEquals(45, kartRace.getResult().getPointsPerParticipant().get(participant));
        assertEquals(41, kartRace.getResult().getPointsPerParticipant().get(participant2));

        kartRace.addScore(score3);
        assertEquals(45, kartRace.getResult().getPointsPerParticipant().get(participant));
        assertEquals(37, kartRace.getResult().getPointsPerParticipant().get(participant2));
        assertEquals(40, kartRace.getResult().getPointsPerParticipant().get(participant3));

        kartRace.addScore(score4);
        assertEquals(40, kartRace.getResult().getPointsPerParticipant().get(participant));
        assertEquals(33, kartRace.getResult().getPointsPerParticipant().get(participant2));
        assertEquals(36, kartRace.getResult().getPointsPerParticipant().get(participant3));
        assertEquals(46, kartRace.getResult().getPointsPerParticipant().get(participant4));
    }

    @Test
    void testResultAddingIntermediateScoresWithoutPosition() {
        addMatchParticipants();
        createScoresWithoutPosition();

        kartRace.addScore(score1);
        assertEquals(46, kartRace.getResult().getPointsPerParticipant().get(participant));

        kartRace.addScore(score3);
        assertEquals(45, kartRace.getResult().getPointsPerParticipant().get(participant));
        assertEquals(41, kartRace.getResult().getPointsPerParticipant().get(participant3));

        kartRace.addScore(score2);
        assertEquals(45, kartRace.getResult().getPointsPerParticipant().get(participant));
        assertEquals(37, kartRace.getResult().getPointsPerParticipant().get(participant2));
        assertEquals(40, kartRace.getResult().getPointsPerParticipant().get(participant3));

        kartRace.addScore(score4);
        assertEquals(45, kartRace.getResult().getPointsPerParticipant().get(participant));
        assertEquals(37, kartRace.getResult().getPointsPerParticipant().get(participant2));
        assertEquals(40, kartRace.getResult().getPointsPerParticipant().get(participant3));
        assertEquals(0, kartRace.getResult().getPointsPerParticipant().get(participant4));
    }

    private void addMatchParticipants() {
        kartRace.addMatchParticipant(matchParticipant);
        kartRace.addMatchParticipant(matchParticipant2);
        kartRace.addMatchParticipant(matchParticipant3);
        kartRace.addMatchParticipant(matchParticipant4);
    }

    private void createScores() {
        score1 = KartRaceScoreFactory
                .create(participant,
                        1,
                        Duration.of(1, ChronoUnit.MINUTES).plus(46, ChronoUnit.SECONDS),
                        false);

        score2 = KartRaceScoreFactory
                .create(participant2,
                        2,
                        Duration.of(1, ChronoUnit.MINUTES).plus(44, ChronoUnit.SECONDS),
                        false);

        score3 = KartRaceScoreFactory
                .create(participant3,
                        3,
                        Duration.of(1, ChronoUnit.MINUTES).plus(45, ChronoUnit.SECONDS),
                        false);

        score4 = KartRaceScoreFactory
                .create(participant4,
                        4,
                        Duration.of(1, ChronoUnit.MINUTES).plus(43, ChronoUnit.SECONDS),
                        true);
    }

    private void createScoresWithPosition() {
        score1 = KartRaceScoreFactory
                .create(participant,
                        1,
                        Duration.of(1, ChronoUnit.MINUTES).plus(46, ChronoUnit.SECONDS),
                        false);

        score2 = KartRaceScoreFactory
                .create(participant2,
                        2,
                        Duration.of(1, ChronoUnit.MINUTES).plus(44, ChronoUnit.SECONDS),
                        false);

        score3 = KartRaceScoreFactory
                .create(participant3,
                        2,
                        Duration.of(1, ChronoUnit.MINUTES).plus(45, ChronoUnit.SECONDS),
                        false);

        score4 = KartRaceScoreFactory
                .create(participant4,
                        1,
                        Duration.of(1, ChronoUnit.MINUTES).plus(43, ChronoUnit.SECONDS),
                        false);
    }

    private void createScoresWithoutPosition() {
        score1 = KartRaceScoreFactory
                .create(participant,
                        Duration.of(1, ChronoUnit.MINUTES).plus(46, ChronoUnit.SECONDS),
                        false);

        score2 = KartRaceScoreFactory
                .create(participant2,
                        Duration.of(1, ChronoUnit.MINUTES).plus(44, ChronoUnit.SECONDS),
                        false);

        score3 = KartRaceScoreFactory
                .create(participant3,
                        Duration.of(1, ChronoUnit.MINUTES).plus(45, ChronoUnit.SECONDS),
                        false);

        score4 = KartRaceScoreFactory
                .create(participant4,
                        Duration.of(1, ChronoUnit.MINUTES).plus(43, ChronoUnit.SECONDS),
                        true);
    }

    private void addScores() {
        kartRace.addScore(score1);
        kartRace.addScore(score2);
        kartRace.addScore(score3);
        kartRace.addScore(score4);
    }
}