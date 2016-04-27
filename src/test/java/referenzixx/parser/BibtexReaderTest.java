package referenzixx.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BibtexReaderTest {

    private BibtexReader reader;

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
        reader = new BibtexReader();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void openNewFileReturnsADatabaseOfBibTexEntriesFromTheFile() {
        File file = new File("src/test/shortbibtexfile.bib");

        BibTeXDatabase db = reader.openNewFile(file);
        assertEquals(2, db.getEntries().size());
    }

    @Test
    public void getBibFileAsStringReturnsTheContentsOfTheFile() {
        File file = new File("src/test/veryshort.bib");
        String contents = reader.getBibFileAsString(file);
       
        String expected = "@article{65VF,\n"
                + "author = {Joku},\n"
                + "title = {Huono},\n"
                + "journal = {journal},\n"
                + "year = {1628},\n"
                + "volume = {13},\n"
                + "}";

        assertTrue(contents.contains(expected));
    }
}
