package es.playNcompete.backend.lib.sports;

import es.bulkynaden.common.helpers.name.IName;
import es.playNcompete.backend.lib.IVenueCollectionHolder;
import es.playNcompete.backend.lib.news_article.INewsArticleCollectionHolder;
import es.playNcompete.backend.lib.tournaments.ITournamentCollectionHolder;

/**
 * The ISport interface represents a sport with properties such as tournaments, venues, and news articles.
 * It extends the IName, ITournamentCollectionHolder,
 * INewsArticleCollectionHolder, and IVenueCollectionHolder interfaces.
 */
public interface ISport extends IName, ITournamentCollectionHolder, INewsArticleCollectionHolder, IVenueCollectionHolder {
}