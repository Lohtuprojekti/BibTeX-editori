import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.database.*
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import org.fest.swing.fixture.*


description 'Arto voi lisätä viitteen, jolla on viitteelle tyypilliset kentät.'

scenario "Lisääminen onnistuu kun kaikki pakolliset on annettu", {

    given 'Kaikki tiedot on annettu', {
        ui = new MainUI()
        ui.setVisible(true)
        window = new FrameFixture(ui)

        window.button("addButton").click()
        dialog = window.dialog()
        dialog.textBox("authorField").enterText("test");
        dialog.textBox("titleField").enterText("asdf");
        dialog.textBox("journalField").enterText("jeeejee");
        dialog.textBox("yearField").enterText("1234");
    }
    when 'Valitaan lisäys', {
        dialog.button("addRefButton").click()
    }
    then 'Lisäys onnistuu', {
        dialog.requireNotVisible()
        dialog.cleanUp()
        window.cleanUp()

    }
}

scenario "Lisääminen epäonnistuu jos kaikki pakolliset ovat tyhjänä", {

    given 'Kaikki tiedot puuttuvat', {
        ui = new MainUI()
        ui.setVisible(true)
        window = new FrameFixture(ui)
        window.button("addButton").click()
        dialog = window.dialog()
    }
    when 'Valitaan lisäys', {
        dialog.button("addRefButton").click()
    }
    then 'Lisäys epäonnistuu', {
        dialog.requireVisible()
        dialog.cleanUp()
        window.cleanUp()

    }
}

scenario "Lisääminen epäonnistuu kun jotakin pakollista ei ole annettu", {

    given 'Kaikki paitsi yksi tieto on annettu', {
        ui = new MainUI()
        ui.setVisible(true)
        window = new FrameFixture(ui)

        window.button("addButton").click()
        dialog = window.dialog()
        dialog.textBox("authorField").enterText("test");
        dialog.textBox("titleField").enterText("asdf");
        dialog.textBox("journalField").enterText("jeeejee");
    }
    when 'Valitaan lisäys', {
        dialog.button("addRefButton").click()
    }
    then 'Lisäys epäonnistuu', {
        dialog.requireVisible()
        dialog.cleanUp()
        window.cleanUp()

    }
}

