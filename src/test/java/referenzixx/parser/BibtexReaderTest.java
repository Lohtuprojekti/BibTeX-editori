/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenzixx.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import org.jbibtex.BibTeXEntry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import referenzixx.refs.Article;
import referenzixx.refs.IReference;

/**
 *
 * @author lilkettu
 */
public class BibtexReaderTest {

    public BibtexReaderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Tests of listReferences method, of class BibtexReader.
     */
    @Test
    public void metodiPalauttaaSamanMaaranOlioitaKunBibTiedostossaOnViitteita() {
        BibtexReader reader = new BibtexReader(new File("src/test/shortbibtexfile.bib"));
        Collection<BibTeXEntry> entries = reader.listReferences();

        assertEquals(2, entries.size());

    }

    /**
     * Tests of listArticles method, of class BibtexReader.
     */
    @Test
    public void muuttaessaBibtexEntrytArticleOlioiksiPalautetaanSamaMaaraOlioita() {
        BibtexReader reader = new BibtexReader(new File("src/test/shortbibtexfile.bib"));
        Collection<BibTeXEntry> entries = reader.listReferences();
        Collection<IReference> articles = reader.listArticles(entries);
        assertEquals(entries.size(), articles.size());
    }

    @Test
    public void metodiMuuttaaBibtexEntryOliotArticleOlioiksi() {
        BibtexReader reader = new BibtexReader(new File("src/test/shortbibtexfile.bib"));
        Collection<BibTeXEntry> entries = reader.listReferences();
        Collection<IReference> articles = reader.listArticles(entries);

        assertEquals(Article.class, articles.iterator().next().getClass());        
    }

    /**
     * Tests of writeToFile method, of class BibtexReader.
     */
    @Test
    public void metodiLisaaArtikkelinTiedostoon() throws FileNotFoundException {
        File file = new File("src/emptybibtexfile.bib");
        new PrintWriter(file).close();
        BibtexReader reader = new BibtexReader(file);

        assertEquals(0, file.length());

        Article artic = new Article("ABC54", "Kirjoittaja", "Artikkeli", "journal", 1, 2016);
        reader.writeToFile(artic);

        assertNotEquals(0, file.length());

        file.delete();
    }

    @Test
    public void tyhjanArtikkelinLisaaminenEiOnnistu() throws FileNotFoundException {
        File file = new File("src/emptybibtexfile.bib");
        new PrintWriter(file).close();
        BibtexReader reader = new BibtexReader(file);

        Article artic = null;
        reader.writeToFile(artic);

        assertEquals(0, file.length());

        file.delete();
    }

}
