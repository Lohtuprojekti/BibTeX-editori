import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.database.*
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;


description 'Arto voi lisätä viitteen, jolla on viitteelle tyypilliset kentät.'

scenario "Lisääminen onnistuu kun kaikki pakolliset on annettu", {
 
        File file = new File("src/test/emptybibtexfile.bib")
        DatabaseUtils dbu = new DatabaseUtils(file)
       
    when 'Valitaan lisäys', {
        BibTeXEntry e = new BibTeXEntry(new Key("book"), new Key("A1B2"))
                
    }

    then 'Lisäys onnistuu', {
        
    }
}

scenario "Lisääminen epäonnistuu jos kaikki pakolliset ovat tyhjänä", {
    
        File file = new File("src/test/veryshort.bib")
        DatabaseUtils dbu = new DatabaseUtils(file)
        
    when 'Valitaan lisäys', {
        
    }
    
    then 'Lisäys epäonnistuu', {
      
    }
}

scenario "Lisääminen epäonnistuu kun jotakin pakollista ei ole annettu", {
        File file = new File("src/test/veryshort.bib")
        DatabaseUtils dbu = new DatabaseUtils(file)

    when 'Valitaan lisäys', {
        
    }

    then 'Lisäys epäonnistuu', {
       
    }
}

