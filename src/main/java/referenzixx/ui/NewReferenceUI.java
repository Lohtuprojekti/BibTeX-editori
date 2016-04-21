package referenzixx.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import org.jbibtex.BibTeXEntry;
import referenzixx.parser.BibtexWriter;
import referenzixx.refs.ReferenceIDGenerator;

/**
 *
 * @author Johannes
 */
public class NewReferenceUI extends javax.swing.JDialog {

    private MainUI mainUI;
    private AddReferencePanel fieldsPanel;

    /**
     * Creates new form NewReference
     *
     * @param mainUI
     * @param modal
     */
    public NewReferenceUI(MainUI mainUI, boolean modal) {
        super(mainUI, modal);
        this.mainUI = mainUI;
        initComponents();
        
        initFields();
    }

    private void initFields() {
        switch (typeChooser.getSelectedItem().toString()) {
            case "Article":
                fieldsPanel = new AddReferencePanel(BibTeXEntry.TYPE_ARTICLE, "uiConfig/articleConfig.cnf");
                break;
            case "Book":
                fieldsPanel = new AddReferencePanel(BibTeXEntry.TYPE_BOOK, "uiConfig/bookConfig.cnf");
                break;
            case "Inproceedings":
                fieldsPanel = new AddReferencePanel(BibTeXEntry.TYPE_INPROCEEDINGS, "uiConfig/inproceedingsConfig.cnf");
                break;
            default:
                fieldsPanel = new AddReferencePanel(BibTeXEntry.TYPE_INPROCEEDINGS, "uiConfig/inproceedingsConfig.cnf");
        }
        
        contentPanel.setSize(fieldsPanel.getWidth(), fieldsPanel.getHeight());
        contentPanel.setLayout(new GridLayout());
        contentPanel.add(fieldsPanel);

        Dimension size = new Dimension(contentPanel.getWidth() + 60, contentPanel.getHeight() + 150);
        this.setSize(size);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        typeChooser = new javax.swing.JComboBox();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lisää uusi viite");

        addButton.setText("Lisää");
        addButton.setToolTipText("Lisää artikkeli");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Peruuta");
        cancelButton.setToolTipText("Peruuta tallentamatta artikkelia");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        typeChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Article", "Book", "Inproceedings" }));
        typeChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(errorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(typeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 417, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton)
                    .addComponent(errorLabel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typeChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeChooserActionPerformed
        contentPanel.remove(fieldsPanel);
        initFields();

        revalidate();
        repaint();
    }//GEN-LAST:event_typeChooserActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        if (!fieldsPanel.valuesOk()) {
            errorLabel.setText("Syötä vaadittuihin kenttiin jokin arvo");
            return;
        }
        if (!fieldsPanel.valuesConvertOk()) {
            errorLabel.setText("Syötä numeeriset arvot oikeassa muodossa");
            return;
        }

        // we'll use empty reference here in order to facilitate
        // auto-generation in fieldsPanel.getEntry() 
        BibTeXEntry entry = fieldsPanel.getEntry("", mainUI.getDatabase());
        mainUI.addBibtex(entry);
        //mainUI.addReference(entry);
                
        this.setVisible(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JComboBox typeChooser;
    // End of variables declaration//GEN-END:variables
}
