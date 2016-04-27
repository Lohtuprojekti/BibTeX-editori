package referenzixx;

import javax.swing.JTable;
import referenzixx.ui.MainUI;
import javax.swing.UIManager;
import org.fest.swing.data.TableCell;
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
        window.button("addButton").click();
        window.textBox("authorField").select("testiä");
        window.table().cell(TableCell.row(0).column(0)).requireValue("");
    }
}
