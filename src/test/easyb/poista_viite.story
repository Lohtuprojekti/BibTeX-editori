import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.database.*
import org.fest.swing.fixture.*
import org.fest.swing.data.*;
import java.io.File;


description 'Arto voi poistaa viitteen.'

scenario "Arto voi poistaa valitun viitteen", {
    given 'Arto on valinnut viimeisen viitteen', {
        ui = new MainUI(new DatabaseUtils("src/test/testfile.bib"))
        ui.setVisible(true)
        window = new FrameFixture(ui)

        window.button("addButton").click()
        dialog = window.dialog()
        dialog.textBox("authorField").enterText("test");
        dialog.textBox("titleField").enterText("asdf");
        dialog.textBox("journalField").enterText("jeeejee");
        dialog.textBox("yearField").enterText("1234");
        dialog.button("addRefButton").click()

        rows = ui.getDBUtils().getReferences().size()
        System.out.println(rows)
        window.table().selectRows(rows - 1)
    }
    when 'Valitaan poista', {
        window.button("delButton").click()
    }
    then 'Ensimmäinen viite poistetaan', {
        window.table().requireRowCount(rows-1)
        window.cleanUp()
    }
}

scenario "Arto ei voi painaa poista nappia jos viitettä ei ole valittu", {
    given 'UI on käynnistetty', {
        ui = new MainUI(new DatabaseUtils("src/test/testfile.bib"))
        ui.setVisible(true)
        window = new FrameFixture(ui)
    }
    when 'Viitettä ei ole valittu', {
        
    }
    then 'Poista nappia ei voi painaa', {
        window.button("delButton").requireDisabled()
        window.cleanUp()
    }
}