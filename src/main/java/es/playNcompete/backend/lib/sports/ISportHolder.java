package es.playNcompete.backend.lib.sports;

public interface ISportHolder {
    ISport getSport();

    void setSport(ISport sport);

    void removeSport();
}