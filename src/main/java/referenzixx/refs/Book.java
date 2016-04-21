//
//package referenzixx.refs;
//
//import org.jbibtex.BibTeXEntry;
//
//public class Book extends Reference implements IReference {
//    
//    //Required fields: author/editor, title, publisher, year
//    //Optional fields: volume/number, series, address, edition, month, note, key
//    private int volume = Integer.MIN_VALUE, edition = Integer.MIN_VALUE, month = Integer.MIN_VALUE; //Month number ie. 1 = January
//    private String series, address, note;
//    
//    //Pakolliset kentät samat kuin Reference oliolla
//    public Book(String refNum, String authors, String title, String publisher, int year){
//
//        this.refNum = refNum;
//        this.author=authors;
//        this.title = title;
//        this.publisher=publisher;
//        this.year = year;
//    }
//    
//    public Book(int volume, int edition, int month, String series, String address, String note) {
//        this.volume = volume;
//        this.edition = edition;
//        this.month = month;
//        this.series = series;
//        this.address = address;
//        this.note = note;
//    }
//    
//    public Book(BibTeXEntry e) {
//        this.refNum = e.getKey().toString();
//        this.author = e.getField(BibTeXEntry.KEY_AUTHOR).toUserString();
//        this.title = e.getField(BibTeXEntry.KEY_TITLE).toUserString();
//        this.publisher = e.getField(BibTeXEntry.KEY_PUBLISHER).toUserString();
//        this.year = Integer.parseInt(e.getField(BibTeXEntry.KEY_YEAR).toUserString());
//    }
//    
//    // Muuttaa referenssi-olion bibtex-muotoon
//    @Override
//    public String toString() {
//        return "\n@book{" + this.getRefNum() + ",\n"
//                + "author = {" + this.getAuthor() + "},\n"
//                + "title = {" + this.getTitle() + "},\n"
//                + "publisher = {" + this.getPublisher() + "},\n"
//                + checkOptionalNum("volume", this.volume)
//                + checkOptionalNum("edition", this.edition)
//                + checkOptionalNum("month", this.month)
//                + checkOptional("series", this.series)
//                + checkOptional("address", this.address)
//                + "year = {" + this.getYear() + "}\n"
//                + "}";
//    }
//   
//    
//    //Setters
//    public void setNote(String note) {
//        this.note = note;
//    }
//    
//    public void setVolume(int volume) {
//        this.volume = volume;
//    }
//    
//    public void setEdition(int edition) {
//        this.edition = edition;
//    }
//    
//    public void setMonth(int month) {
//        this.month = month;
//    }
//    
//    public void setSeries(String series) {
//        this.series = series;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//    
//    //Getters
//    public int getVolume() {
//        return volume;
//    }
//
//    public int getEdition() {
//        return edition;
//    }
//
//    public int getMonth() {
//        return month;
//    }
//
//    public String getSeries() {
//        return series;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public String getNote() {
//        return note;
//    }
//    
//}
