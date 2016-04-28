package referenzixx.database;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import referenzixx.parser.BibtexReader;
import referenzixx.refs.ReferenceEntryBuilder;
import referenzixx.ui.ReferencePanel;

public class DatabaseUtilsTest {

    private DatabaseUtils dbu;
    private File file;
    private BibTeXEntry entry;
    private int original;

    public DatabaseUtilsTest() {

    }

    @Before
    public void setUp() {
        file = new File("src/test/testfile.bib");
        dbu = new DatabaseUtils(file);
        entry = new BibTeXEntry(new Key("article"), new Key("ABC"));
        original = dbu.getDatabase().getEntries().size();
        dbu.addEntry(entry);
    }

    @After
    public void tearDown() {
        file.delete();
    }
    
    @Test
    public void defaultIsCorrect() {
        DatabaseUtils dbutils = new DatabaseUtils();
        assertTrue(dbutils.getFile().getPath().contains("referenzixx.bib"));
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
        BibtexReader reader = new BibtexReader();
        String filecontents = reader.getBibFileAsString(file);

        assertTrue(filecontents.contains("ABC"));
        file.delete();
    }

    @Test
    public void addEntryAddsToDatabase() {
        int added = dbu.getDatabase().getEntries().size();
        assertTrue(added == (original + 1));
        file.delete();
    }

    @Test
    public void entryNotAddedifNull() {
        BibTeXEntry entry2 = null;
        dbu.addEntry(entry2);
        int added = dbu.getDatabase().getEntries().size();
        //NOTE: SetUP() already adds 1 to database, thus original+1
        assertTrue(added == original + 1);
        file.delete();
    }

    @Test
    public void entryNotAddedifNotUniqueKey() {
        original = dbu.getDatabase().getEntries().size();
        //add file with same key
        BibTeXEntry entry2 = new BibTeXEntry(new Key("article"), new Key("ABC"));
        dbu.addEntry(entry2);
        int added = dbu.getDatabase().getEntries().size();

        assertTrue(added == original);
        file.delete();
    }

    @Test
    public void delEntryRemovesFromDatabase() {
        BibTeXEntry entry2 = new BibTeXEntry(new Key("book"), new Key("123"));
        dbu.addEntry(entry2);
        BibTeXEntry entry3 = new BibTeXEntry(new Key("article"), new Key("ABC"));
        dbu.delEntry(entry3);

        assertTrue(!dbu.getReferences().contains(entry));
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
    public void testFilters1() {
        BibTeXEntry entry2 = new BibTeXEntry(new Key("book"), new Key("123"));
        dbu.addEntry(entry2);
        BibTeXEntry entry3 = new BibTeXEntry(new Key("book"), new Key("FOO"));
        entry3.addField(new Key("author"), new KeyValue("BAR"));
        dbu.addEntry(entry3);

        Map<String, String> filters = new HashMap<>();
        filters.put("key", "123");
        filters.put("author", "BAR");
        List<BibTeXEntry> list = dbu.getReferences(filters);
        assertTrue(list.isEmpty());
        file.delete();
    }

    @Test
    public void testFilters2() {
        BibTeXEntry entry2 = new BibTeXEntry(new Key("book"), new Key("123"));
        dbu.addEntry(entry2);
        BibTeXEntry entry3 = new BibTeXEntry(new Key("book"), new Key("FOO"));
        entry3.addField(new Key("author"), new KeyValue("BAR"));
        dbu.addEntry(entry3);

        Map<String, String> filters = new HashMap<>();
        filters.put("author", "B");
        List<BibTeXEntry> list = dbu.getReferences(filters);
        assertTrue(list.size() == 1);
        file.delete();
    }

    @Test
    public void whenCreatingEntryFromPartsCallsAddEntry() {
        original = dbu.getDatabase().getEntries().size();
        List<ReferencePanel> references = new ArrayList<>();
        dbu.addEntry(new Key("book"), "", references);

        int added = dbu.getDatabase().getEntries().size();
        assertTrue(added == (original + 1));

        BibtexReader reader = new BibtexReader();
        String filecontents = reader.getBibFileAsString(file);

        assertTrue(filecontents.contains("book"));
        file.delete();

    }

    @Test
    public void getFileTest() {
        assertTrue(dbu.getFile() == file);
    }
}
