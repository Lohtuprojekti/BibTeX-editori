package referenzixx.refs;

import java.util.List;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;
import org.jbibtex.Value;
import referenzixx.ui.ReferencePanel;

/**
 * Class ReferenceEntryBuilder helps generate BibTeXEntries from data given by user.
 * 
 */
public class ReferenceEntryBuilder {
    
    /**
     * buildEntry creates a BibTeXEntry from given parameters
     * 
     * @param type Type of the entry
     * @param ref The reference ID of the entry
     * @param database Database into which the entry would be inserted
     * @param references The key-value pairs that BibTeXEntry holds
     * @return BibTeXEntry with given values
     */
    public BibTeXEntry buildEntry(Key type, String ref, BibTeXDatabase database,
                                    List<ReferencePanel> references) {
        if (ref.isEmpty()) {
            ReferenceIDGenerator refID = new ReferenceIDGenerator(
                    getValueByFieldName("author", references), getValueByFieldName("year", references));
            ref = refID.generateReferenceID(database);
        }
        BibTeXEntry entry = new BibTeXEntry(type, new Key(ref));
        
        for (ReferencePanel reference : references) {
            entry.addField(reference.getType(), reference.getValue());
        }
        return entry;
    }
        
    /**
     * getValueByFieldName is used by buildEntry to find the values in a field.
     * 
     * @param field Field of which value is wanted.
     * @param references List of key-value pairs
     * @return Value of the field that is searched.
     */
    private String getValueByFieldName(String field, List<ReferencePanel> references) {

        String foundValue = "";

        for (ReferencePanel reference : references) {
            //Stringejä ei kannata vertailla "==" oli bugi tässä pitkän aikaa
            if (reference.getType().toString().equals(field)) {
                foundValue = reference.getValue().toUserString();
            }
        }
        return foundValue;

    }
    
    /**
     * Converts bibtex scandics to more clear ones, i.e. \"{o} to ö.
     * 
     * @param entry Entry to be converted
     * @return Converted entry
     */
    public static BibTeXEntry convertScandic(BibTeXEntry entry) {
        BibTeXEntry convertedEntry = new BibTeXEntry(entry.getType(), entry.getKey());
        
        for (Key key : entry.getFields().keySet()) {
            convertedEntry.addField(key, new KeyValue(convertScandic(entry.getField(key).toUserString())));
        }
        
        return convertedEntry;
    }
    
    private static String convertScandic(String line) {
        String convertedLine = line;
        
        convertedLine = convertedLine.replace("\\\"{o}", "ö");
        convertedLine = convertedLine.replace("\\aa", "å");
        convertedLine = convertedLine.replace("\\\"{a}", "ä");
        
        for (char c = 'A'; c <= 'Z'; c++) {
            convertedLine = convertedLine.replace("{" + c + "}", c+"");
        }
        
        return convertedLine;
    }
}
