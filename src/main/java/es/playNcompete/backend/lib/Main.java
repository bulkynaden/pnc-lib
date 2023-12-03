package es.playNcompete.backend.lib;

import es.playNcompete.backend.lib.match_participants.MatchParticipant;
import es.playNcompete.backend.lib.matches.KartRace;
import es.playNcompete.backend.lib.participants.IParticipant;
import es.playNcompete.backend.lib.participants.Individual;
import es.playNcompete.backend.lib.sports.KartRacing;
import es.playNcompete.backend.lib.tournaments.Tournament;

public class Main {
    public static void main(String[] args) {
        IParticipant participant = new Individual();
        KartRace kartRace = new KartRace(new Venue(), new Tournament(new KartRacing()));
        participant.addMatchParticipant(new MatchParticipant(kartRace, participant));
        System.out.println(participant.getMatchParticipants());
    }
}