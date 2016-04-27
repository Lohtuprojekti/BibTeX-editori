import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.database.*
import org.fest.swing.fixture.*
import org.fest.swing.data.*;

description 'Arto voi poistaa viitteen.'

scenario "Arto voi poistaa valitun viitteen", {
    given 'Arto on valinnut viimeisen viitteen', {
        ui = new MainUI()
        ui.setVisible(true)
        window = new FrameFixture(ui)

        rows = new DatabaseUtils().getReferences().size()
        window.table().selectRows(rows-1)
    }
    when 'Valitaan poista', {
        window.button("delButton").click()
    }
    then 'Ensimmäinen viite poistetaan', {
        window.table().requireRowCount(rows-1)
        window.cleanUp()
    }
}