package referenzixx.database;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;
import org.jbibtex.LiteralValue;
import org.jbibtex.Value;
import referenzixx.parser.BibtexReader;
import referenzixx.parser.BibtexWriter;
import referenzixx.refs.ReferenceEntryBuilder;
import referenzixx.ui.ReferencePanel;

/**
 *
 */
public class DatabaseUtils implements ReferenceDatabase {

    // TODO: 
    // implement interface methods for filtering out unwanted articles.
    private File file;
    private BibTeXDatabase database;

    /**
     * Default constructor called by MainUI.
     */
    public DatabaseUtils() {
        this("referenzixx.bib");
    }

    /**
     * Constructor of class DatabaseUtils
     *
     * @param url
     */
    public DatabaseUtils(String url) { //Käli haluaa url version
        this(new File(url));
    }

    public DatabaseUtils(File file) {
        this.selectFile(file);
    }

    /**
     * Changes the currently accessed file and database to given file.
     *
     * @param file
     */
    public void selectFile(File file) {
        this.file = file;
        this.database = new BibtexReader().openNewFile(this.file);
    }

    /**
     * Adds an entry to the file and BibTeXDatabase
     *
     * @param entry
     */
    public void addEntry(BibTeXEntry entry) {
        if (entry == null || !isRefnumUnique(entry.getKey(), database)) {
            return;
        }        
        
        // Reformatting author visual presentation (if key found)
        if (entry.getField(new Key("author")) != null) {
            String authorsFormatted = separateAuthorsWithAnd(entry.getField(new Key("author")).toUserString());
            
            entry.removeField(new Key("author"));
            entry.addField(new Key("author"), new KeyValue(authorsFormatted));
        }
                
        database.addObject(entry);
        new BibtexWriter().writeToBibtex(entry, file);
    }

    /**
     * Replaces commas with 'and' to separate multiple authors.
     * @param String
     * @return 
     */
    private String separateAuthorsWithAnd(String authorText) {
        return authorText.replace(",", " and");
    }
    
    /**
     * UI uses this method to add entry to database using information it has
     * collected from the user.
     *
     * @param type
     * @param ref
     * @param references
     */
    public void addEntry(Key type, String ref, List<ReferencePanel> references) {
        BibTeXEntry entry = new ReferenceEntryBuilder().buildEntry(type, ref, database, references);
        this.addEntry(entry);
    }

    /**
     * Deletes an entry from BibTexDatabase and updates the file to reflect that
     *
     * @param entry
     */
    public void delEntry(BibTeXEntry entry) {
        database.removeObject(entry);
        new BibtexWriter().rewriteDatabaseToBibtex(database, file);
    }

    /**
     * Copies the currently chosen bibtex file to clipboard.
     */
    public void copyToClipboard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String content = new BibtexReader().getBibFileAsString(file);
        clipboard.setContents(new StringSelection(content), null);
    }

    /**
     * Returns the database as a list of BibTeXEntry
     *
     * @return
     */
    @Override
    public List<BibTeXEntry> getReferences() {
        return database.getEntries().values().stream().collect(Collectors.toList());
    }

    /**
     * Searches the database for entries 
     * @param searchTerm  Single word or several ones separated by "and" keywords.
     * @return 
     */
    public List<BibTeXEntry> getReferences(String searchTerm) {
        
        
        if (searchTerm.isEmpty()) {
            return this.getReferences();
        } else {
            // we'll check if there are multiple search terms included in
            // one string (separated by " and " keyword) and splice 
            // into arraylist accordingly.
            String[] multipleSearchTerms = searchTerm.split(" (and) | (AND) ");            
            
            return this.getReferences(new ArrayList<String>(Arrays.asList(multipleSearchTerms)));
        }
        
    }

    /**
     * Searches the database for entries 
     * @param searchTerms
     * @return
     */
    @Override
    public List<BibTeXEntry> getReferences(List<String> searchTerms) {
	/*
         If there's need to remove any special chars from the search term
         it shall be done here.
         See if any of the Values in in a BibTeXEntry contains the wanted
         search term.

        for (int j = 0; j < searchTerms.size(); j++) {
        final int k = j;
        list.addAll(database.getEntries()
                .values().stream()
                .filter(e -> e.getFields().values().stream()
                        .anyMatch(i -> searchTerms.get(k).contains(i.toUserString())))
                .collect(Collectors.toList()));
        }
	*/
//Toimii paremmin
        List<BibTeXEntry> list = new ArrayList<>();
        for (BibTeXEntry value : database.getEntries().values()) {
            loop:
            for (String searchTerm : searchTerms) {
                for (Value value1 : value.getFields().values()) {
                    if (value1.toUserString().toLowerCase().contains(searchTerm.toLowerCase())) {
                        list.add(value);
                        break loop;
                    }
                }
                if (value.getKey().toString().toLowerCase().contains(searchTerm.toLowerCase())) {
                    list.add(value);
                    break;
                }
            }
        }
        
        
        return list;
    }

    /**
     * Checks if the reference ID of the BibTexEntry is unique
     *
     * @param refnum
     * @param database
     * @return
     */
    private boolean isRefnumUnique(Key refnum, BibTeXDatabase database) {
        return !database.getEntries().containsKey(refnum);
    }

    /**
     * Used to get the currently chosen file.
     *
     * @return File that is edited
     */
    public File getFile() {
        return file;
    }

    /**
     * Used to get the currently chosen database.
     *
     * @return
     */
    public BibTeXDatabase getDatabase() {
        return database;
    }
}
