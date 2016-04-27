import referenzixx.*
import referenzixx.refs.*
import referenzixx.ui.*
import referenzixx.parser.*
import referenzixx.database.*
import org.jbibtex.BibTeXEntry
import org.jbibtex.Key


description "Arto ei voi vahingossa luoda toista viitettä, jolla on sama viitenumero"

scenario "Arto yrittää lisätä samalla viitenumerolla", {
	
            File file = new File("src/test/shortbibtexfile.bib")
            DatabaseUtils dbu = new DatabaseUtils(file)
            BibTeXEntry entry = new BibTeXEntry(new Key("article"), new Key("ABC54"))
        
	when "Tiedostoon lisataan viite jolla on viitenumero ABC54", {
            dbu.addEntry(entry)
        }
	then "Tiedostoon ei kirjoiteta lisää", {
            dbu.getReferences().size().shouldBe(2)
        }
}
