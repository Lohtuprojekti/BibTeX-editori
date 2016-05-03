import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.database.*
import org.fest.swing.fixture.*
import org.fest.swing.data.*;

description 'Arto näkee listauksen tiedostossa olevista viitteistä.'

scenario "Listassa on yhtä monta viitettä kuin tiedostossa", {
    given 'Käyttöliittymä on auki', {
        ui = new MainUI()
        ui.setVisible(true)
        window = new FrameFixture(ui)
    }
    when 'Ei tehdä muutoksia', {
        rows = ui.getDBUtils().getReferences().size()
    }
    then 'Listassa on yhtä monta viitettä kuin tiedostossa', {
        window.table().requireRowCount(rows)
        window.cleanUp()
    }
}

scenario "Arto näkee juuri lisätyn viitteen", {
    given 'Arto syöttää kaikki vaadittavat tiedot', {
        ui = new MainUI(new DatabaseUtils("src/test/testfile.bib"))
        ui.setVisible(true)
        window = new FrameFixture(ui)

        window.button("addButton").click()
        dialog = window.dialog()
        dialog.textBox("authorField").enterText("test");
        dialog.textBox("titleField").enterText("asdf");
        dialog.textBox("journalField").enterText("jeeejee");
        dialog.textBox("yearField").enterText("1234");
    }
    when 'Viite lisätään', {
        dialog.button("addRefButton").click()
        row = ui.getDBUtils().getReferences().size()-1
    }
    then 'Juuri lisätty viite ilmestyy listan loppuun', {
        window.table().cell(TableCell.row(row).column(1)).requireValue "test"
        window.table().cell(TableCell.row(row).column(2)).requireValue "asdf"
        window.table().cell(TableCell.row(row).column(3)).requireValue "1234"

        dialog.cleanUp()
        window.cleanUp()
    }
}