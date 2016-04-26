package referenzixx;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import referenzixx.ui.MainUI;
import javax.swing.UIManager;
import org.fest.swing.fixture.FrameFixture;

public class Main {

    public static void main(String[] args) {

        /* Set the default look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code ">
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        MainUI mainUI = new MainUI();
        mainUI.setVisible(true);
        
        FrameFixture window = new FrameFixture(mainUI);
        window.button("copyButton").click();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String cb = (String) clipboard.getData(DataFlavor.stringFlavor);

        new BibtexReader().getBibFileAsString(new File("referenzixx.bib")).requireText cb
    }
}
