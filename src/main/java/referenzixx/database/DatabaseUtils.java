package referenzixx.database;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.Value;
import referenzixx.parser.BibtexReader;
import referenzixx.parser.BibtexWriter;

/**
 *
 */
public class DatabaseUtils implements ReferenceDatabase {

    // TODO: 
    // read bibtex file to an internal hashmap, within constructor
    // file location can be specified in a constructor parameter
    // implement interface methods for filtering out unwanted articles.
    private File file;
    private BibTeXDatabase database;

    /**
     * Constructor of class DatabaseUtils
     *
     * @param url
     */
    public DatabaseUtils(String url) {
        this.file = new File(url);
        this.database = new BibTeXDatabase();
    }

    /**
     *
     * @param url
     */
    public void selectFile(String url) {
        database = new BibtexReader().openNewFile(file, database);
    }

    /**
     * Adds an entry to BibTexDatabase
     *
     * @param entry
     */
    public void addEntry(BibTeXEntry entry) {
        new BibtexWriter().writeToBibtex(entry, file, database);
    }

    /**
     * Deletes an entry from BibTexDatabase
     *
     * @param entry
     */
    private void delEntry(BibTeXEntry entry) {
        database.removeObject(entry);
    }

    /**
     *
     */
    public void copyToClipboard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String content = new BibtexReader().getBibFileAsString(file);
        clipboard.setContents(new StringSelection(content), null);
    }

    /*
     private void readBibtexFile() {

     bibtexEntries.listReferences().stream().
     }
     */
    /**
     *
     * @return
     */
    @Override
    public List<BibTeXEntry> getReferences() {
        List<BibTeXEntry> entryList = new ArrayList<>();
        
        for (BibTeXEntry entry : database.getEntries().values()) {
            entryList.add(entry);
        }
        return entryList;
    }

    /**
     *
     * @param filters
     * @return
     */
    @Override
    public List<BibTeXEntry> getReferences(Map<String, String> filters) {
        List<BibTeXEntry> entryList = new ArrayList<>();
        //Aivan sysipaska mutta pitäisi antaa oikeita tuloksia
        for (Map.Entry<String, String> filter : filters.entrySet()) {
            for (BibTeXEntry entry : database.getEntries().values()) {
                if (entry.getFields().containsKey(new Key(filter.getKey()))) {
                    if (entry.getField(new Key(filter.getKey())).toUserString()
                            .equals(filter.getValue())) {
                        entryList.add(entry);
                    }
                }
            }
        }
        return entryList;
    }

    /**
     *
     * @return
     */
    public File getFile() {
        return file;
    }

    /**
     *
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     *
     * @return
     */
    public BibTeXDatabase getDatabase() {
        return database;
    }

    /**
     *
     * @param database
     */
    public void setDatabase(BibTeXDatabase database) {
        this.database = database;
    }

}
