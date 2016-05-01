package referenzixx.refs;
// BibTex reference ID for a new entry (article, book, inproceedings)

import java.util.List;
import org.jbibtex.BibTeXDatabase;
import org.jbibtex.Key;
import referenzixx.util.CharacterSequencer;

/**
 * Generates unique reference IDs.
 *
 */
public class ReferenceIDGenerator {

    // TODO:
    // yksikkötestit: duplicaten tarkistus
    private String author;
    private String yearText;

    public ReferenceIDGenerator(String author, String yearText) {
        this.author = author;
        this.yearText = yearText;
    }

    // this is the method that will be used for obtaining a valid
    // reference ID
    public String generateReferenceID(BibTeXDatabase database) {

        String referenceIDText = "";
        String authorRef = generateAuthorText(this.author);

        CharacterSequencer cs = new CharacterSequencer("");

        // to prevent a duplicate id from being generated
        referenceIDText = authorRef + this.yearText + cs.next();
        while (checkDuplicate(referenceIDText, database)) {
            referenceIDText = authorRef + this.yearText + cs.next();
        }

        return referenceIDText;
    }

    // we pick the second word, and assume that it's the last name of an author
    // if the author text is just one word, we'll return it back.
    // Hajosi jos on vain yksi sana.
    private String generateAuthorText(String author) {
        String text = "";
        if (author.contains(",")) {
            text = generateAuthorTextFromMultipleAuthors(author);
        } else if (author.contains(" ")) {
            text = (author.split(" ").length > 0 ? author.split(" ")[1].toLowerCase() : author.toLowerCase());
        } else {
            text = author.toLowerCase();
        }
        return text.length() > 7 ? text.substring(0, 7) : text;
    }

    /**
     * Picks the first two letters of each author's lastname (assuming it's the
     * second word from the beginning of the string or after comma) and returns
     * it.
     *
     * @param author
     * @return
     */
    private String generateAuthorTextFromMultipleAuthors(String author) {
        String text = "";
        String authors[] = author.split(", ");
        for (String a : authors) {
            String[] name = a.split(" ");
            text += name[1].substring(0, 2);
        }
        return text.toLowerCase();
    }

    // returns false if there is a duplicate
    // TODO: database search, now we return true by default
    // pending database functionality
    private boolean checkDuplicate(String referenceID, BibTeXDatabase database) {
        if (database.getEntries().containsKey(new Key(referenceID))) {
            return true;
        }
        return false;
    }

    // future expansion, not used now.
    // first letters of every word of the journal/publication
    /*
     private String generateJournalText(String journal) {

     String journalRef = "";
     for (String s : journal.split(" ")) {
     journalRef += s.charAt(0);
     }

     return journalRef.toLowerCase();
     }
     */
}
