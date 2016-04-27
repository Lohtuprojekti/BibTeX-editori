    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenzixx.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.util.StringTokenizer;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;
import org.jbibtex.Value;

/**
 *
 * @author johkauha
 */
public class ReferencePanel extends javax.swing.JPanel {

    private boolean isInteger;
    private boolean isRequired;
    private Key type;

    /**
     * Creates new form ReferencePanel
     *
     * @param config
     */
    public ReferencePanel(String config) {
        super();
        initComponents();
        readConfig(config);
        this.setSize(270, 42);
    }

    // NAME|TOOLTIP|TYPE|INTEGER|REQUIRED
    private void readConfig(String config) {
        StringTokenizer tokenizer = new StringTokenizer(config, "|");
        nameLabel.setText(tokenizer.nextToken());
        valueField.setToolTipText(tokenizer.nextToken());
        type = new Key(tokenizer.nextToken());
        isInteger = tokenizer.nextToken().equalsIgnoreCase("integer");
        isRequired = tokenizer.nextToken().equalsIgnoreCase("required");

        if (isRequired) {
            nameLabel.setText(nameLabel.getText() + "*");
        }
    }

    public Key getType() {
        return type;
    }

    public Value getValue() {
        return new KeyValue(valueField.getText());
    }

    public boolean valueOk() {
        return isRequired ? !valueField.getText().isEmpty() : true;
    }

    public boolean valueConvertOk() {
        if (isInteger) {
            if (!isRequired && valueField.getText().isEmpty())
                return true;
            
            try {
                Integer.parseInt(valueField.getText());
            } catch (NumberFormatException ex) {
                return false;
            }
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        valueField = new javax.swing.JTextField();

        nameLabel.setText("jLabel1");

        valueField.setToolTipText("");
        valueField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valueField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void valueFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valueFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField valueField;
    // End of variables declaration//GEN-END:variables
}
