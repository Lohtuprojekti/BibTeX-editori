package referenzixx.ui;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddReferencePanel extends JPanel {
    private String configUrl;
    
    public AddReferencePanel(String configUrl) {
        this.configUrl = configUrl;
        initComponents();
    }
    
    private void initComponents() {
        this.setLayout(new GridLayout(0, 2));
        
        for (String line : FileParser.parseFile(configUrl)) {
            this.add(new ReferencePanel(line));
        }
    }
}
