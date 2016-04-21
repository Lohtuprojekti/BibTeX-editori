package referenzixx.refs;

import java.util.List;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import referenzixx.ui.ReferencePanel;

public class ReferenceEntryBuilder {
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
}
