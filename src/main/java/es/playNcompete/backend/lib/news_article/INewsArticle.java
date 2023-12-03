package es.playNcompete.backend.lib.news_article;

import es.bulkynaden.common.classes.IFile;
import es.playNcompete.backend.lib.sports.ISport;

import java.time.ZonedDateTime;
import java.util.Set;

public interface INewsArticle {
    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    String getLink();

    void setLink(String link);

    ZonedDateTime getDate();

    void setDate(ZonedDateTime date);

    Set<IFile> getImages();

    void setImages(Set<IFile> images);

    void addImage(IFile image);

    void removeImage(IFile image);

    Set<ISport> getSports();

    void setSports(Set<ISport> sports);

    void addSport(ISport sport);

    void removeSport(ISport sport);
}