package es.playNcompete.backend.lib.match_participants;

public interface IOneVsOneMatchParticipant extends IMatchParticipant {
    Role getRole();

    enum Role {
        LOCAL, VISITOR
    }
}