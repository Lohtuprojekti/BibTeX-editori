package referenzixx.ui;

// The purpose of this class is to automatically generate the needed BibTex reference ID
// for a new entry (article, book, inproceedings)
public class ReferenceGenerator {

    // todo:
    // - toinen sana authorista (sukunimi)
    // - vuosiluku
    // - julkaisun alkukirjaimet
    // - juokseva kirjain (a, b, c, d...)
    // yksikkötestit:
    // - duplicaten tarkistus
    /*
     String reference = referenceTextField.getText();
     String author = referenceTextField.getText();
     String title = titleTextField.getText();
     String journal = journalTextField.getText();
     String yearText = yearTextField.getText();
     String volumeText = volumeTextField.getText();
     */
    
    private String author;
    private String yearText;
    private String journal;
    
    
    public ReferenceGenerator(String author, String yearText, String journal) {
        this.author = author;
        this.yearText = yearText;
        this.journal = journal;
    }

    public String generateReference() {

        String authorRef = generateAuthorText(this.author);
        String journalRef = generateJournalText(this.journal);
        
        
        // and we combine everything
        return authorRef + journalRef + this.yearText;
    }

    
    // first letters of every word of the journal/publication
    
    private String generateJournalText(String journal) {
        
        String journalRef = "";
        for (String s : journal.split(" ")) {
            journalRef += s.charAt(0);
        }
        
        return journalRef;
    }

    
    // we pick the second word, and assume that it's the last name of an author
    // if the author text is just one word, we'll return it back.
    
    private String generateAuthorText(String author) {
        
        return (author.split(" ").length > 0 ? author.split(" ")[1] : author);
         
    }
    
    private boolean checkDuplicate() {

         
        
        
        return false;
    }

}
