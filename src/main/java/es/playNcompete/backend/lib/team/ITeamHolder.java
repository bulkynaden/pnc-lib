package es.playNcompete.backend.lib.team;

import lombok.NonNull;

public interface ITeamHolder {
    ITeam getTeam();

    void setTeam(@NonNull ITeam team);

    void removeTeam();
}