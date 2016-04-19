package referenzixx.refs;

import org.jbibtex.BibTeXEntry;


public class Inproceedings extends Reference implements IReference {
    //An article in a conference proceedings.
    //Required fields: author, title, booktitle, year
    //Optional fields: editor, volume/number, series, pages, address, month, organization, publisher, note, key
    
    private String booktitle;
    //private String editor, address, organization, note;
    //private int volume, pageStart, pageEnd, month;
    
    public Inproceedings(String refNum, String author, String title, String booktitle,
                        int year){
        this.refNum=refNum;
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
    }
    
    public Inproceedings(BibTeXEntry e) {
        this.refNum = e.getKey().toString();
        this.author = e.getField(BibTeXEntry.KEY_AUTHOR).toUserString();
        this.title = e.getField(BibTeXEntry.KEY_TITLE).toUserString();
        this.booktitle = e.getField(BibTeXEntry.KEY_BOOKTITLE).toUserString();
        this.year = Integer.parseInt(e.getField(BibTeXEntry.KEY_YEAR).toUserString());
    }
    
    @Override
    public String toString() {
        return "\n@inproceedings{" + this.getRefNum() + ",\n"
                + "author = {" + this.getAuthor() + "},\n"
                + "title = {" + this.getTitle() + "},\n"
                + "booktitle = {" + this.getBooktitle() + "},\n"
                + "year = {" + this.getYear() + "},\n}";
    }
    

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }
    
}
