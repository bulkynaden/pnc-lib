package es.playNcompete.backend.lib.news_article;

import es.bulkynaden.common.classes.File;
import es.bulkynaden.common.classes.IFile;
import es.playNcompete.backend.lib.factories.SportFactory;
import es.playNcompete.backend.lib.sports.ISport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class NewsArticleTest {
    INewsArticle newsArticle;
    IFile file1;
    IFile file2;
    ISport sport1;
    ISport sport2;

    @BeforeEach
    void setUp() {
        newsArticle = new NewsArticle();
        file1 = new File();
        file1.setName("file1");
        file2 = new File();
        file2.setName("file2");
        sport1 = SportFactory.createKartRacing();
        sport2 = SportFactory.createKartRacing();
    }

    @Test
    void testSetters() {
        newsArticle.setTitle("title");
        assertEquals("title", newsArticle.getTitle());

        newsArticle.setDescription("description");
        assertEquals("description", newsArticle.getDescription());

        newsArticle.setLink("link");
        assertEquals("link", newsArticle.getLink());

        newsArticle.setDate(ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZonedDateTime.now().getZone()));
        assertEquals(ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZonedDateTime.now().getZone()), newsArticle.getDate());

        newsArticle.setImages(new HashSet<>(Arrays.asList(file1, file2)));
        assertEquals(2, newsArticle.getImages().size());
        assertTrue(newsArticle.getImages().contains(file1));
        assertTrue(newsArticle.getImages().contains(file2));

        newsArticle.setSports(new HashSet<>(Arrays.asList(sport1, sport2)));
        assertEquals(2, newsArticle.getSports().size());
        assertTrue(newsArticle.getSports().contains(sport1));
        assertTrue(newsArticle.getSports().contains(sport2));
    }

    @Test
    void testAddImage() {
        newsArticle.addImage(file1);
        assertEquals(1, newsArticle.getImages().size());
        assertTrue(newsArticle.getImages().contains(file1));

        newsArticle.addImage(file2);
        assertEquals(2, newsArticle.getImages().size());
        assertTrue(newsArticle.getImages().contains(file1));
    }

    @Test
    void testRemoveImage() {
        newsArticle.addImage(file1);
        assertEquals(1, newsArticle.getImages().size());
        assertTrue(newsArticle.getImages().contains(file1));

        newsArticle.removeImage(file1);
        assertEquals(0, newsArticle.getImages().size());
        assertFalse(newsArticle.getImages().contains(file1));
    }

    @Test
    void testAddSport() {
        newsArticle.addSport(sport1);
        assertEquals(1, newsArticle.getSports().size());
        assertTrue(newsArticle.getSports().contains(sport1));

        newsArticle.addSport(sport2);
        assertEquals(2, newsArticle.getSports().size());
        assertTrue(newsArticle.getSports().contains(sport1));
    }

    @Test
    void testRemoveSport() {
        newsArticle.addSport(sport1);
        assertEquals(1, newsArticle.getSports().size());
        assertTrue(newsArticle.getSports().contains(sport1));

        newsArticle.removeSport(sport1);
        assertEquals(0, newsArticle.getSports().size());
        assertFalse(newsArticle.getSports().contains(sport1));
    }
}