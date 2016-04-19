/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenzixx.refs;

import org.jbibtex.BibTeXEntry;

/**
 *
 * Contains methods for variables that all reference objects inherit: Reference
 * number, author, publisher, title and year.
 */
public class Reference {

    //refNum is the 3+ character reference number/identifier.
    public String refNum, title, author, publisher;
    public Integer year;

    public Reference() {

    }

    public Reference(String refNum, String title, String author, String publisher, Integer year) {
        this.refNum = refNum;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    
    // Muuttaa referenssi-olion bibtex-muotoon
    @Override
    public String toString() {
        return "\n@reference{" + this.getRefNum() + ",\n"
                + "author = {" + this.getAuthor() + "},\n"
                + "title = {" + this.getTitle() + "},\n"
                + "year = {" + this.getYear() + "},\n}";
    }


    public Reference(BibTeXEntry e) {
        this.refNum = e.getKey().toString();
        this.title = e.getField(BibTeXEntry.KEY_TITLE).toUserString();
        this.author = e.getField(BibTeXEntry.KEY_AUTHOR).toUserString();
        this.publisher = e.getField(BibTeXEntry.KEY_PUBLISHER).toUserString();
        this.year = Integer.parseInt(e.getField(BibTeXEntry.KEY_YEAR).toUserString());
    }

    //Setters

    public void setRefNum(String ref) {
        this.refNum = ref;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publ) {
        this.publisher = publ;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //Getters
    public String getRefNum() {
        return this.refNum;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

}
