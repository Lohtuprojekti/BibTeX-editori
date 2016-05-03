package referenzixx.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jbibtex.Key;
import referenzixx.parser.ConfigFileParser;

public class ReferencePanelList extends JPanel {

    private Key type;
    private String configUrl;
    private List<ReferencePanel> references;

    public ReferencePanelList(Key type, String configUrl) {
        this.type = type;
        this.configUrl = configUrl;
        this.references = new ArrayList<>();
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

    /**
     * Checks if every required field is filled.
     * 
     * @return True if required fields are filled, false otherwise.
     */
    public boolean valuesOk() {
        for (ReferencePanel reference : references) {
            if (!reference.valueOk()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if fields marked as integer can be converted.
     * 
     * @return True if converts were succesful, false otherwise.
     */
    public boolean valuesConvertOk() {
        for (ReferencePanel reference : references) {
            if (!reference.valueConvertOk()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the type of the reference.
     * 
     * @return Type of the reference
     */
    public Key getType() {
        return type;
    }

    /**
     * Returns a list of the filled fields.
     * 
     * @return List of the filled fields.
     */
    public List<ReferencePanel> getFields() {
        return references;
    }

    
}
