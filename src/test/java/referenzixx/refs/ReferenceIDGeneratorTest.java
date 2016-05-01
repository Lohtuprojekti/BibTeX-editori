package referenzixx.refs;

import java.io.File;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;
import org.junit.After;
import referenzixx.database.DatabaseUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class ReferenceIDGeneratorTest {
    
    private ReferenceIDGenerator iGene;
    private DatabaseUtils dutil;

    public ReferenceIDGeneratorTest() {
    }
    
    @Before
    public void setUp(){
        dutil = new DatabaseUtils("src/test/testfile.bib");
    }
    
    @After
    public void tearDown(){
        new File("src/test/testfile.bib").delete();
    }
    
    @Test
    public void idCreationWorksWithUniqueKey(){
        iGene = new ReferenceIDGenerator("Milla Pekka", "1987");
        String ret = iGene.generateReferenceID(dutil.getDatabase());
        assertTrue(ret.equals("pekka1987a"));

    }
    
    @Test
    public void idCreationWorksWithOneWordAuthor(){
        iGene = new ReferenceIDGenerator("milla", "1987");
        String ret = iGene.generateReferenceID(dutil.getDatabase());
        assertTrue(ret.equals("milla1987a"));

    }
    
    @Test
    public void idCreationWorksWithMultipleAuthors() {
        iGene = new ReferenceIDGenerator("Joku Nimi, Toinen Tyyppi", "2014");
        String ret = iGene.generateReferenceID(dutil.getDatabase());
        assertTrue(ret.equals("nity2014a"));
    }
    
    @Test
    public void idCreationKeepsLengthOfIDUnder12CharactersWithOneAuthor() {
        iGene = new ReferenceIDGenerator("Schwarzenegger", "1980");
        String ret = iGene.generateReferenceID(dutil.getDatabase());
        assertTrue(ret.equals("schwarz1980a"));
    }
    
    @Test
    public void idCreationKeepsLengthOfIDUnder12CharactersWithMultipleAuthors() {
        iGene = new ReferenceIDGenerator("Eka Tyyppi, Joku Muu, Some Body, Hemmo Heebo", "1980");
        String ret = iGene.generateReferenceID(dutil.getDatabase());
        assertTrue(ret.equals("tymuboh1980a"));
    }

    @Test
    public void idCreationCreatesUniqueIdForSameNamedAuthor(){
        BibTeXEntry entry = new BibTeXEntry(new Key("Article"), new Key("mafia1990a"));
        entry.addField(new Key("author"), new KeyValue("Taika Mafia"));
        entry.addField(new Key("year"), new KeyValue("1990"));
        dutil.addEntry(entry);
        
        iGene = new ReferenceIDGenerator("Taika Mafia", "1990");
        String ret = iGene.generateReferenceID(dutil.getDatabase());
        assertTrue(ret.equals("mafia1990b"));

    }
    
}
