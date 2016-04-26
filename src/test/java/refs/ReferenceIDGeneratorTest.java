package refs;

import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;
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
        entry = new BibTeXEntry(new Key("Article"), new Key("Testi"));
        entry.addField(new Key("author"), new KeyValue("Taika Mafia"));
        entry.addField(new Key("year"), new KeyValue("1990"));
        entry.addField(new Key("refnum"), new KeyValue("mafia1990a"));
        dutil.addEntry(entry);
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
    
   /* @Test
    public void idCreationCreatesUniqueIdForSameNamedAuthor(){
        iGene = new ReferenceIDGenerator("Taika Mafia", "1990");
        String ret = iGene.generateReferenceID(dutil.getDatabase());
        assertTrue(ret.equals("mafia1990b"));

    }*/
    
}
