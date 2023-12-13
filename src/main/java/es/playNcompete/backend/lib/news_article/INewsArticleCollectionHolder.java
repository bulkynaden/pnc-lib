package es.playNcompete.backend.lib.news_article;

import lombok.NonNull;

import java.util.Collection;

/**
 * The INewsArticleCollectionHolder interface represents a collection holder for news articles.
 * It provides methods to get news articles, set news articles, add a news article, and remove a news article.
 */
public interface INewsArticleCollectionHolder {
    /**
     * Retrieves the news articles associated with this collection holder.
     *
     * @return A collection of INewsArticle objects representing the news articles.
     */
    Collection<INewsArticle> getNewsArticles();

    /**
     * Sets a collection of news articles for this collection holder.
     *
     * @param newsArticles A collection of news articles to be set.
     *                     The news articles must implement the INewsArticle interface.
     * @param <T>          The type of news articles that extend INewsArticle.
     */
    default <T extends INewsArticle> void setNewsArticles(Collection<T> newsArticles) {
        newsArticles.forEach(this::addNewsArticle);
    }

    /**
     * Adds a news article to the collection holder.
     *
     * @param newsArticle The news article to be added.
     * @throws NullPointerException if the news article is null.
     */
    void addNewsArticle(@NonNull INewsArticle newsArticle);

    /**
     * Removes a news article from the collection holder.
     *
     * @param newsArticle The news article to be removed.
     * @throws NullPointerException if the news article is null.
     */
    void removeNewsArticle(@NonNull INewsArticle newsArticle);
}