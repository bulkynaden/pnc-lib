package es.playNcompete.backend.lib.news_article;

import es.bulkynaden.common.classes.IFile;
import es.playNcompete.backend.lib.sports.ISport;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
public class NewsArticle implements INewsArticle {
    @Setter
    private String title;
    @Setter
    private String description;
    @Setter
    private String link;
    @Setter
    private ZonedDateTime date;
    @Setter
    private Set<IFile> images = new HashSet<>();
    @Setter
    private Set<ISport> sports = new HashSet<>();

    @Override
    public void addImage(@NonNull IFile image) {
        images.add(image);
    }

    @Override
    public void removeImage(@NonNull IFile image) {
        images.remove(image);
    }

    @Override
    public void addSport(@NonNull ISport sport) {
        sports.add(sport);
        if (!sport.getNewsArticles().contains(this)) {
            sport.addNewsArticle(this);
        }
    }

    @Override
    public void removeSport(@NonNull ISport sport) {
        sports.remove(sport);
        if (sport.getNewsArticles().contains(this)) {
            sport.removeNewsArticle(this);
        }
    }
}