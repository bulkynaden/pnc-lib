package es.playNcompete.backend.lib.sports;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.exceptions.ParameterCantBeBlankException;
import es.playNcompete.backend.lib.news_article.INewsArticle;
import es.playNcompete.backend.lib.tournaments.ITournament;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * The Sport class represents a sport with properties such as tournaments, venues, and news articles.
 * It implements the ISport interface.
 */
@Getter
public abstract class Sport implements ISport {
    private final Set<INewsArticle> newsArticles = new HashSet<>();
    private final Set<IVenue> venues = new HashSet<>();
    private final Set<ITournament> tournaments = new HashSet<>();
    @Setter
    private String name;

    /**
     * Initializes a new instance of the Sport class.
     *
     * @param name The name of the sport.
     * @throws ParameterCantBeBlankException if the name is blank.
     */
    public Sport(@NonNull String name) throws ParameterCantBeBlankException {
        if (name.isBlank()) {
            throw new ParameterCantBeBlankException("name");
        }
        setName(name);
    }

    @Override
    public void addTournament(@NonNull ITournament tournament) {
        this.tournaments.add(tournament);
        tournament.setSport(this);
    }

    @Override
    public void removeTournament(@NonNull ITournament tournament) {
        this.tournaments.remove(tournament);
    }

    @Override
    public void addVenue(IVenue venue) {
        this.venues.add(venue);
    }

    @Override
    public void removeVenue(IVenue venue) {
        this.venues.remove(venue);
    }

    @Override
    public void addNewsArticle(INewsArticle newsArticle) {
        this.newsArticles.add(newsArticle);
        if (!newsArticle.getSports().contains(this)) {
            newsArticle.addSport(this);
        }
    }

    @Override
    public void removeNewsArticle(INewsArticle newsArticle) {
        this.newsArticles.remove(newsArticle);
        if (newsArticle.getSports().contains(this)) {
            newsArticle.removeSport(this);
        }
    }
}