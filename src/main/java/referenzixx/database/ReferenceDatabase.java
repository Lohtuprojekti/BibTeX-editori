package referenzixx.database;

import java.util.List;
import java.util.Map;
import org.jbibtex.BibTeXEntry;

public interface ReferenceDatabase {
    
    
    public List<BibTeXEntry> getReferences();
    
    
    /* 
    filters to be applied are given as a hashmap, key being the field and
    value being the value. for example: key = year, value = 2015 will filter
    everything with year 2015.
    */
    
    public List<BibTeXEntry> getReferences(Map<String, String> filters);
        
}