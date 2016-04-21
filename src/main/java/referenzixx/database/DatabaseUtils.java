package referenzixx.database;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.jbibtex.BibTeXEntry;
import referenzixx.parser.BibtexReader;

public class DatabaseUtils implements ReferenceDatabase {

    // TODO: 
    // read bibtex file to an internal hashmap, within constructor
    // file location can be specified in a constructor parameter
    // implement interface methods for filtering out unwanted articles.
    
    private BibtexReader bibtexEntries;

    public DatabaseUtils(BibtexReader bibtexEntries) {
        this.bibtexEntries = bibtexEntries;    
    }
        
    
    
    @Override
    public List<BibTeXEntry> getReferences() {
        return null;
    }

    @Override
    public List<BibTeXEntry> getReferences(Map<String, String> filters) {
        return null;
    }
    
    private void readBibtexFile() {
        
        // bibtexEntries.listReferences().stream().
        
    }

    
}
