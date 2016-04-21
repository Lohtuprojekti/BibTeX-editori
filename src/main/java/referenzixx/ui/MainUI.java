package referenzixx.ui;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.table.TableModel;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.BibTeXEntry;
import referenzixx.parser.BibtexReader;
import referenzixx.parser.BibtexWriter;
import referenzixx.refs.IReference;
import referenzixx.refs.Reference;

/**
 *
 * @author Johannes
 */
public class MainUI extends javax.swing.JFrame {

    private Map<String, IReference> references;
    private int row = 0;
    private String url = "referenzixx.bib";
    private BibtexReader bibtexReader;
    private BibtexWriter bibtexWriter;
    private Clipboard clipboard;

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        this.references = new HashMap<>();
        File file = new File(url);
        this.bibtexReader = new BibtexReader(file);
        this.bibtexWriter = new BibtexWriter(file, bibtexReader);
        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        initComponents();

//        Collection<BibTeXEntry> references = bibtexReader.listReferences();
//        if (references != null) {
//            addReferences(bibtexReader.listArticles(references));
//        }
    }

    /**
     * Lisää listan artikkeleita käyttöliittymään.
     *
     * @param references Lisättävät artikkelit
     */
//    private void addReferences(Collection<IReference> references) {
//        for (IReference reference : references) {
//            addReference(reference);
//        }
//    }

    /**
     * Lisää artikkeli käyttöliittymään.
     *
     * @param reference Lisättävä artikkeli
     */
//    public void addReference(IReference reference) {
//        references.put(reference.getRefNum(), reference);
//
//        TableModel tableModel = referenceTable.getModel();
//        tableModel.setValueAt(reference.getRefNum(), row, 0);
//        tableModel.setValueAt(reference.getAuthor(), row, 1);
//        tableModel.setValueAt(reference.getTitle(), row, 2);
//        tableModel.setValueAt(reference.getYear() + "", row, 3);
//        tableModel.setValueAt(reference.getPublisher(), row, 4);
//
//        row++;
//
//        bibtexReader.writeToFile(reference);
//    }

//    public void addReference(BibTeXEntry entry) {
//        if (entry.getType() == BibTeXEntry.TYPE_ARTICLE) {
//            Article article = new Article(entry);
//            bibtexReader.writeToFile(article);
//        } else if (entry.getType() == BibTeXEntry.TYPE_BOOK) {
//            Book book = new Book(entry);
//            bibtexReader.writeToFile(book);
//        } else if (entry.getType() == BibTeXEntry.TYPE_INPROCEEDINGS) {
//            Inproceedings inproceedings = new Inproceedings(entry);
//            bibtexReader.writeToFile(inproceedings);
//        }
//    }
    public void addBibtex(BibTeXEntry entry) {
        bibtexWriter.writeToBibtex(entry);
    }
    public BibTeXDatabase getDatabase() {
        return this.bibtexWriter.getDatabase();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addReferenceButton = new javax.swing.JButton();
        copyButton = new javax.swing.JButton();
        readButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        referenceTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        addReferenceButton.setText("Lisää");
        addReferenceButton.setToolTipText("Lisää uusi artikkeli");
        addReferenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReferenceButtonActionPerformed(evt);
            }
        });

        copyButton.setText("Kopioi leikepöydälle");
        copyButton.setToolTipText("Kopioi BibTex-tiedoston leikepöydälle");
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });

        readButton.setText("Lue");
        readButton.setEnabled(false);
        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });

        referenceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", "", null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Viite", "Kirjoittaja", "Nimi", "Vuosi", "Julkaisija"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(referenceTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addReferenceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(readButton)
                        .addGap(18, 18, 18)
                        .addComponent(copyButton))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addReferenceButton)
                    .addComponent(copyButton)
                    .addComponent(readButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
        String content = bibtexReader.getBibFileAsString();
        clipboard.setContents(new StringSelection(content), null);
    }//GEN-LAST:event_copyButtonActionPerformed

    private void addReferenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReferenceButtonActionPerformed
        new NewReferenceUI(this, true).setVisible(true);
    }//GEN-LAST:event_addReferenceButtonActionPerformed

    private void readButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readButtonActionPerformed

    }//GEN-LAST:event_readButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addReferenceButton;
    private javax.swing.JButton copyButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton readButton;
    private javax.swing.JTable referenceTable;
    // End of variables declaration//GEN-END:variables
}
