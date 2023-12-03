package es.playNcompete.backend.lib;

import es.bulkynaden.common.classes.IFile;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * The Venue class represents a venue with properties such as location, associated file, and name.
 * It implements the IVenue interface.
 */
@Getter
@EqualsAndHashCode(of = {"name"})
public class Venue implements IVenue {
    private final Collection<IVenue> venues = new HashSet<>();
    private IVenue parent;
    @Setter
    private Point location;
    @Setter
    private IFile file;
    @Setter
    private String name;

    @Override
    public void setParent(IVenue parent) {
        if (this.parent != parent) {
            if (this.parent != null && this.parent.getVenues().contains(this)) {
                this.parent.removeVenue(this);
            }
            this.parent = parent;
            if (this.parent != null && !this.parent.getVenues().contains(this)) {
                this.parent.addVenue(this);
            }
        }
    }

    @Override
    public void addVenue(@NonNull IVenue venue) {
        this.venues.add(venue);
        if (venue.getParent() != this) {
            venue.setParent(this);
        }
    }

    @Override
    public void removeVenue(@NonNull IVenue venue) {
        this.venues.remove(this);
        if (venue.getParent() == this) {
            venue.setParent(null);
        }
    }
}