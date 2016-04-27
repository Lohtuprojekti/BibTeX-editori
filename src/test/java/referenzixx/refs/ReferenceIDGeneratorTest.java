package refs;

import java.io.File;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;
import org.junit.After;
import referenzixx.refs.ReferenceIDGenerator;
import referenzixx.database.DatabaseUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class ReferenceIDGeneratorTest {
    
    private ReferenceIDGenerator iGene;
    BibTeXEntry entry;
    private DatabaseUtils dutil;

    public ReferenceIDGeneratorTest() {
    }
    
    @Before
    public void setUp(){
        dutil = new DatabaseUtils("src/test/testfile.bib");
        entry = new BibTeXEntry(new Key("Article"), new Key("mafia1990a"));
        entry.addField(new Key("author"), new KeyValue("Taika Mafia"));
        entry.addField(new Key("year"), new KeyValue("1990"));
        dutil.addEntry(entry);
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
    public void idCreationCreatesUniqueIdForSameNamedAuthor(){
        iGene = new ReferenceIDGenerator("Taika Mafia", "1990");
        String ret = iGene.generateReferenceID(dutil.getDatabase());
        assertTrue(ret.equals("mafia1990b"));

    }
    
}
