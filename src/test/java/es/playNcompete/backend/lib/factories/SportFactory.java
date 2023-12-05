package es.playNcompete.backend.lib.factories;

import es.playNcompete.backend.lib.sports.KartRacing;
import es.playNcompete.backend.lib.sports.Sport;

public class SportFactory {
    public static Sport createKartRacing() {
        return new KartRacing("Kart Racing");
    }
}