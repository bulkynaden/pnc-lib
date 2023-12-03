package es.playNcompete.backend.lib.sports;

import es.bulkynaden.common.helpers.name.IName;
import es.playNcompete.backend.lib.IVenue;
import es.playNcompete.backend.lib.news_article.INewsArticle;
import es.playNcompete.backend.lib.tournaments.ITournamentCollectionHolder;

import java.util.Set;

public interface ISport extends IName, ITournamentCollectionHolder {
    Set<IVenue> getVenues();

    void setVenues(Set<IVenue> venues);

    void addVenue(IVenue venue);

    void removeVenue(IVenue venue);

    Set<INewsArticle> getNewsArticles();

    void setNewsArticles(Set<INewsArticle> newsArticles);

    void addNewsArticle(INewsArticle newsArticle);

    void removeNewsArticle(INewsArticle newsArticle);
}