import referenzixx.*
import referenzixx.database.*
import java.util.Map
import java.util.List
import java.util.ArrayList;
import java.io.File
import org.jbibtex.BibTeXEntry
import java.util.HashMap


description "Viitteitä voi filtteröidä yhden hakuehdon perusteella"

scenario "Arto hakee viitteitä vuosiluvun perusteella", {

        File file = new File("src/test/bibtexfile.bib")
        DatabaseUtils dbu = new DatabaseUtils(file)
        Map<String, String> filters = new HashMap<String, String>()
        filters.put("year", "2004")
        List<BibTeXEntry> results = new ArrayList<BibTeXEntry>();
    
    when "Arto hakee viitteitä hakusanalla 2004", {
        results = dbu.getReferences(filters)
    }
    
    then "Palautetaan lista viitteitä jotka on julkaistu vuonna 2004", {
        results.size().shouldBe(3)
    }
}

scenario "Yhtään viitettä ei palauteta jos hakuehdot eivät täyty", {
    
        File file = new File("src/test/bibtexfile.bib")
        DatabaseUtils dbu = new DatabaseUtils(file)
        Map<String, String> filters = new HashMap<String, String>()
        filters.put("title", "Cats rule")
        List<BibTeXEntry> results = new ArrayList<BibTeXEntry>();
    
    when "Arto hakee viitteitä hakusanalla Cats rule", {
        results = dbu.getReferences(filters)
    }

    then "Palautetaan tyhjä lista viitteitä", {
        results.size().shouldBe(0)
    }
}

scenario "Viitteitä voi filtteröidä useiden hakuehtojen perusteella", {
    
        File file = new File("src/test/bibtexfile.bib")
        DatabaseUtils dbu = new DatabaseUtils(file)
        Map<String, String> filters = new HashMap<String, String>()
        filters.put("year", "2004")
        filters.put("publisher", "ACM")
        List<BibTeXEntry> results = new ArrayList<BibTeXEntry>();
   
    when "Arto hakee viitteitä hakusanoilla 2004 ja ACM", {
        results = dbu.getReferences(filters)
    }

    then "Palautetaan lista viitteitä jotka on julkaistu vuonna 2004 ja julkaisija on ACM", {
        
    }
}
    