package es.playNcompete.backend.lib.factories;

import es.playNcompete.backend.lib.Venue;

public class VenueFactory {
    private static int counter = 0;

    public static Venue createParentVenue() {
        Venue venue = new Venue();
        venue.addVenue(createVenue());
        return venue;
    }

    public static Venue createChildVenue() {
        Venue venue = new Venue();
        venue.setParent(createVenue());
        return venue;
    }

    public static Venue createVenue() {
        Venue venue = new Venue();
        venue.setName("Test Venue " + counter);
        counter++;
        return venue;
    }
}