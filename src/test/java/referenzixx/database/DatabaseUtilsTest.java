package referenzixx.database;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.stage.Stage;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import referenzixx.parser.BibtexReader;

public class DatabaseUtilsTest {

    private DatabaseUtils dbu;
    private File file;

    public DatabaseUtilsTest() {

    }

    @Before
    public void setUp() {
        file = new File("src/test/shortbibtexfile.bib");
        dbu = new DatabaseUtils(file.getPath());
    }

    @Test
    public void testSelectFile() {

    }

    @Test
    public void testAddEntry() {
        File testfile = new File("src/test/testfile.bib");
        dbu.selectFile(testfile.getPath());
        BibTeXEntry entry = new BibTeXEntry(new Key("article"), new Key("ABC"));
        dbu.addEntry(entry);

        BibtexReader reader = new BibtexReader();
        String filecontents = reader.getBibFileAsString(file);

        assertTrue(filecontents.contains("ABC"));
        testfile.delete();
    }
    
    @Test
    public void testDelEntry() {
     
    }

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
        dbu.selectFile(file.getPath());
        List<BibTeXEntry> entryList = dbu.getReferences();

        assertEquals(2, entryList.size());
    }

    // Filter
    @Test
    public void testGetReferences_Map() {

    }

}
