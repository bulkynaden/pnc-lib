package es.playNcompete.backend.lib.sports;

import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.news_article.INewsArticle;
import es.playNcompete.backend.lib.tournaments.ITournament;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
public abstract class Sport implements ISport {
    @Setter
    private Set<ITournament> tournaments = new HashSet<>();
    @Setter
    private Set<IVenue> venues = new HashSet<>();
    @Setter
    private String name;
    @Setter
    private Set<INewsArticle> newsArticles = new HashSet<>();

    public void addTournament(@NonNull ITournament tournament) {
        this.tournaments.add(tournament);
        tournament.setSport(this);
    }

    public void removeTournament(@NonNull ITournament tournament) {
        this.tournaments.remove(tournament);
    }

    public void addVenue(IVenue venue) {
        this.venues.add(venue);
    }

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