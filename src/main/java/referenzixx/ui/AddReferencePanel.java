package referenzixx.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import referenzixx.parser.FileParser;
import referenzixx.refs.ReferenceIDGenerator;

public class AddReferencePanel extends JPanel {

    private Key type;
    private String configUrl;
    private List<ReferencePanel> references;

    public AddReferencePanel(Key type, String configUrl) {
        this.type = type;
        this.configUrl = configUrl;
        this.references = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        List<String> lines = FileParser.parseFile(configUrl, "***");

        Dimension size = new Dimension(550, (lines.size() + 1) / 2 * 42);
        JPanel panel = new JPanel();
        panel.setSize(size);
        this.setSize(size);
        this.add(panel);

        panel.setLayout(new GridLayout(0, 2, 50, 0));
        for (String line : lines) {
            ReferencePanel referencePanel = new ReferencePanel(line);
            panel.add(referencePanel);
            references.add(referencePanel);
        }
    }

    public boolean valuesOk() {
        for (ReferencePanel reference : references) {
            if (!reference.valueOk()) {
                return false;
            }
        }

        return true;
    }

    public boolean valuesConvertOk() {
        for (ReferencePanel reference : references) {
            if (!reference.valueConvertOk()) {
                return false;
            }
        }

        return true;
    }

    public BibTeXEntry getEntry(String ref, BibTeXDatabase database) {
        
        
        // if no referenceID was specified, we'll generate a
        // unique one on the fly, based on author names and publication year
        if (ref.isEmpty()) {

            ReferenceIDGenerator refID = new ReferenceIDGenerator(getValueByFieldName("author"), getValueByFieldName("year"));
            ref = refID.generateReferenceID(database);

        }
        BibTeXEntry entry = new BibTeXEntry(type, new Key(ref));

        for (ReferencePanel reference : references) {
            entry.addField(reference.getType(), reference.getValue());
        }
        return entry;
    }

    // A helper method for finding value of input field based on the BibTex
    // type (name) of the field
    //
    // TODO: refactor by moving to some more suitable (util?) class
    private String getValueByFieldName(String field) {

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
