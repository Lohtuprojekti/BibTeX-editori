package referenzixx.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jbibtex.Key;
import referenzixx.parser.ConfigFileParser;
import referenzixx.refs.ReferenceEntryBuilder;

public class ReferencePanelList extends JPanel {

    private Key type;
    private String configUrl;
    private List<ReferencePanel> references;

    public ReferencePanelList(Key type, String configUrl) {
        this.type = type;
        this.configUrl = configUrl;
        this.references = new ArrayList<ReferencePanel>();
        initComponents();
    }

    private void initComponents() {
        List<String> lines = ConfigFileParser.parseFile(configUrl, "***");

        Dimension size = new Dimension(630, (lines.size() + 1) / 2 * 42);
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

    public Key getType() {
        return type;
    }

    public List<ReferencePanel> getReferences() {
        return references;
    }

    
}
