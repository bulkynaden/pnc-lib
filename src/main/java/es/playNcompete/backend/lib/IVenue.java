package es.playNcompete.backend.lib;

import es.bulkynaden.common.classes.IFile;

import java.awt.*;

/**
 * The IVenue interface represents a venue with properties such as location and associated file.
 */
public interface IVenue extends IVenueCollectionHolder {
    /**
     * Returns the parent venue.
     *
     * @return An IVenue object representing the parent venue.
     */
    IVenue getParent();

    /**
     * Assigns a parent venue to the venue.
     *
     * @param parent An IVenue object representing the parent venue.
     */
    void setParent(IVenue parent);

    /**
     * Returns the location of the venue.
     *
     * @return A Point object representing the location of the venue.
     */
    Point getLocation();

    /**
     * Assigns the location to the venue.
     *
     * @param location A Point object representing the location to be assigned to the venue.
     */
    void setLocation(Point location);

    /**
     * Returns the file associated with the venue.
     *
     * @return An IFile object representing the associated file.
     */
    IFile getFile();

    /**
     * Assigns a file to the venue.
     *
     * @param file An IFile object representing the file to be assigned to the venue.
     */
    void setFile(IFile file);

    /**
     * Returns the name of the venue.
     *
     * @return A String representing the name of the venue.
     */
    String getName();

    /**
     * Sets the name of the venue.
     *
     * @param name A String representing the name of the venue.
     */
    void setName(String name);
}