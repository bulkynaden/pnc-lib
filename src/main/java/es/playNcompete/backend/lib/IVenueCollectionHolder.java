package es.playNcompete.backend.lib;

import lombok.NonNull;

import java.util.Collection;

public interface IVenueCollectionHolder {

    /**
     * Returns the child venues.
     *
     * @return A Collection of IVenue objects representing the child venues.
     */
    Collection<IVenue> getVenues();

    /**
     * Assigns a collection of child venues to the venue.
     *
     * @param venues A Collection of IVenue objects representing the child venues.
     */
    default <T extends IVenue> void setVenues(Collection<T> venues) {
        venues.forEach(this::addVenue);
    }

    /**
     * Assigns a child venue to the venue.
     *
     * @param venue An IVenue object representing the child venue.
     */
    void addVenue(@NonNull IVenue venue);

    /**
     * Removes a child venue from the venue.
     *
     * @param venue An IVenue object representing the child venue.
     */
    void removeVenue(@NonNull IVenue venue);
}