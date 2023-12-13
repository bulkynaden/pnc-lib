package es.playNcompete.backend.lib.sports;

import lombok.NonNull;

public class KartRacing extends Sport implements IKartRacing {
    public KartRacing(@NonNull String name) {
        super(name);
    }
}