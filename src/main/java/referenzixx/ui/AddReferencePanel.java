package referenzixx.ui;

import referenzixx.parser.FileParser;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;

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

    public BibTeXEntry getEntry(String ref) {
        BibTeXEntry entry = new BibTeXEntry(type, new Key(ref));

        for (ReferencePanel reference : references) {
            entry.addField(reference.getType(), reference.getValue());
        }

        return entry;
    }
}
