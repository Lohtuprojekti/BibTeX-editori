import referenzixx.*


description "Arto voi filtteröidä viitteitä hakuehtojen mukaan"

scenario "Arto hakee viitteitä vuosiluvun perusteella", {

    given "Tiedostossa on vuonna 2004 tehtyjä julkaisuja", {
        File file = new File("src/test/bibtexfile.bib")
        DatabaseUtils dbu = new DatabaseUtils(file)
        Map<String, String> filters = new HashMap<>()
        filters.put("year", "2004")
    }
    
    when "Arto hakee viitteitä hakusanalla 2004" {
       List<BibTeXEntry> results = dbu.getReferences(filters)
    }
    
    then "Palautetaan lista viitteitä jotka on julkaistu vuonna 2004" {
        results.size().shouldBe(3)
    }


scenario "Arto hakee viitteitä nimekkeen perusteella", {
    
    given "Tiedostossa ei ole viitteitä nimekkeellä "Cats rule", {
        File file = new File("src/test/bibtexfile.bib")
        DatabaseUtils dbu = new DatabaseUtils(file)
        Map<String, String> filters = new HashMap<>()
        filters.put("title", "Cats rule")
    }

    when "Arto hakee viitteitä hakusanalla "Cats rule", {
        List<BibTeXEntry> results = dbu.getReferences(filters)
    }

    then "Palautetaan tyhjä lista viitteitä" {
        results.size().shouldBe(0)
    }
    