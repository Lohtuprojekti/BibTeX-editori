package referenzixx.database;


import java.io.File;
import java.util.List;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import referenzixx.parser.BibtexReader;

public class DatabaseUtilsTest {

    private DatabaseUtils dbu;
    private File file;
    private BibTeXEntry entry;

    public DatabaseUtilsTest() {

    }

    @Before
    public void setUp() {
        file = new File("src/test/testfile.bib");
        dbu = new DatabaseUtils(file);
        entry = new BibTeXEntry(new Key("article"), new Key("ABC"));
    }

    @After
    public void tearDown() {
        file.delete();
    }

    @Test
    public void testSelectFile() {
        dbu.addEntry(entry);
        
        File emptyfile = new File("src/test/emptybibtexfile.bib");
        dbu.selectFile(emptyfile);
        assertTrue(dbu.getReferences().isEmpty());
        assertTrue(dbu.getFile().length() == 0);
        assertTrue(file.length() != 0);
        emptyfile.delete();
    }

    @Test
    public void addEntryAddsToFile() {
        dbu.addEntry(entry);

        BibtexReader reader = new BibtexReader();
        String filecontents = reader.getBibFileAsString(file);

        assertTrue(filecontents.contains("ABC"));
        file.delete();
    }
    
    @Test
    public void addEntryAddsToDatabase() {
        int original = dbu.getDatabase().getEntries().size();
        dbu.addEntry(entry);
        int added = dbu.getDatabase().getEntries().size();

        assertTrue(added == (original + 1));
        file.delete();
    }
    
    @Test
    public void entryNotAddedifNull(){
        int original = dbu.getDatabase().getEntries().size();
        entry = null;
        dbu.addEntry(entry);
        int added = dbu.getDatabase().getEntries().size();

        assertTrue(added == original);
        file.delete();
    }
    
    @Test
    public void entryNotAddedifNotUniqueKey(){
        dbu.addEntry(entry);
        int original = dbu.getDatabase().getEntries().size();
        //add file with same key
        BibTeXEntry entry2 = new BibTeXEntry(new Key("article"), new Key("ABC"));     
        dbu.addEntry(entry2);
        int added = dbu.getDatabase().getEntries().size();
        
        assertTrue(added == original);
        file.delete();
    }

    @Test
    public void delEntryRemovesFromDatabase() {
        BibTeXEntry entry1 = new BibTeXEntry(new Key("article"), new Key("ABC"));
        BibTeXEntry entry2 = new BibTeXEntry(new Key("book"), new Key("123"));
        dbu.addEntry(entry1);
        dbu.addEntry(entry2);
        
        BibTeXEntry entry3 = new BibTeXEntry(new Key("article"), new Key("ABC"));
        dbu.delEntry(entry3);      
        
        assertTrue(!dbu.getReferences().contains(entry1));
        assertTrue(dbu.getReferences().contains(entry2));
        
        file.delete();
    }
    
    @Test
    public void delEntryRemovesFromFile() {
        BibTeXEntry entry2 = new BibTeXEntry(new Key("book"), new Key("123"));
        dbu.addEntry(entry);
        dbu.addEntry(entry2);
        
        BibTeXEntry entry3 = new BibTeXEntry(new Key("article"), new Key("ABC"));
        dbu.delEntry(entry3);
        
        String filecontents = new BibtexReader().getBibFileAsString(file);
        assertTrue(!filecontents.contains("article"));
        file.delete();
    }
    //Tämä testi ei mene läpi traviksesta mutta on hyvä ja toimiva.
//    @Test
//    public void testCopyToClipboard() throws Exception {
//        dbu.copyToClipboard();
//
//        String bibentry = "@article{65VF";
//
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        String cb = (String) clipboard.getData(DataFlavor.stringFlavor);
//
//        assertTrue(cb.contains(bibentry));
//    }

    @Test
    public void testGetReferences() {
        BibTeXEntry entry2 = new BibTeXEntry(new Key("book"), new Key("123"));
        dbu.addEntry(entry);
        dbu.addEntry(entry2);

        List<BibTeXEntry> entryList = dbu.getReferences();
        for (BibTeXEntry bibTeXEntry : entryList) {
            assertTrue(dbu.getDatabase().getEntries().containsValue(bibTeXEntry));
        }

        assertEquals(dbu.getDatabase().getEntries().size(), entryList.size());
        file.delete();
    }

    // Filter
    @Test
    public void testGetReferences_Map() {

    }

    @Test
    public void getFileTest() {
        assertTrue(dbu.getFile() == file);
    }
}
