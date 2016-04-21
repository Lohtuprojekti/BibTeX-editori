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

public class DatabaseUtils implements ReferenceDatabase {

    // TODO: 
    // read bibtex file to an internal hashmap, within constructor
    // file location can be specified in a constructor parameter
    // implement interface methods for filtering out unwanted articles.
    File file;
    BibTeXDatabase database;

    public DatabaseUtils(String url) {
        this.file = new File(url);
        this.database = new BibTeXDatabase();
    }

    public void selectFile(String url) {
        new BibtexReader().openNewFile(file, database);
    }

    public void addEntry(BibTeXEntry entry) {
        new BibtexWriter().writeToBibtex(entry, file, database);
    }

    private void delEntry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

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

    @Override
    public List<BibTeXEntry> getReferences() {
        List<BibTeXEntry> entryList = new ArrayList<>();
        for (BibTeXEntry entry : database.getEntries().values()) {
            entryList.add(entry);
        }
        return entryList;
    }

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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public BibTeXDatabase getDatabase() {
        return database;
    }

    public void setDatabase(BibTeXDatabase database) {
        this.database = database;
    }

}
