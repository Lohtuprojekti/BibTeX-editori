//package referenzixx.refs;
//
//import org.jbibtex.BibTeXEntry;
//
///**
// *
// * Article reference. Extends Reference class and inherits its public methods
// */
//public class Article extends Reference implements IReference {
//
//    private String journal, address, month;
//    private int volume = Integer.MIN_VALUE, number = Integer.MIN_VALUE;
//    //Article starting and ending pages
//    private int pageStart = Integer.MIN_VALUE, pageEnd = Integer.MIN_VALUE;
//
//    //Constructor for article. Very ugly with 10 parameters.
//    public Article(String refNum, String authors, String title, String journal, int volume,
//            int year/*, int number, int startpage, int endpage, String publisher,
//     String address*/) {
//        this.refNum = refNum;
//        this.author = authors;
//        this.title = title;
//        this.journal = journal;
//        this.volume = volume;
//        this.year = year;
//        //this.number = number;
//        //this.pageStart = startpage;
//        //this.pageEnd = endpage;
//        //this.publisher = publisher;
//        //this.address = address;
//    }
//
//    public Article(BibTeXEntry e) {
//        this.refNum = e.getKey().toString();
//        this.author = e.getField(BibTeXEntry.KEY_AUTHOR).toUserString();
//        this.title = e.getField(BibTeXEntry.KEY_TITLE).toUserString();
//        this.journal = e.getField(BibTeXEntry.KEY_JOURNAL).toUserString();
//        this.volume = Integer.parseInt(e.getField(BibTeXEntry.KEY_VOLUME).toUserString());
//        this.year = Integer.parseInt(e.getField(BibTeXEntry.KEY_YEAR).toUserString());
//    }
//
//    // Muuttaa artikkeli-olion bibtex-muotoon
//    
//        //this.number = number;
//        //this.pageStart = startpage;
//        //this.pageEnd = endpage;
//        //this.publisher = publisher;
//        //this.address = address;
//    @Override
//    public String toString() {
//        return "\n@article{" + this.getRefNum() + ",\n"
//                + "author = {" + this.getAuthor() + "},\n"
//                + "title = {" + this.getTitle() + "},\n"
//                + "journal = {" + this.getJournal() + "},\n"
//                + "volume = {" + this.getVolume() + "},\n"
//                +checkOptionalNum("number", this.number)
//                +checkOptional("month", this.month)
//                +checkOptionalPages("pages", this.pageStart, this.pageEnd)
//                +checkOptional("publisher", this.publisher)
//                +checkOptional("address", this.address)
//                + "year = {" + this.getYear() + "}\n"
//                +"}";
//    }
//
//    //Setters.
//    public void setJournal(String jour) {
//        this.journal = jour;
//    }
//
//    public void setAddress(String addrs) {
//        this.address = addrs;
//    }
//
//    public void setVolume(int vol) {
//        this.volume = vol;
//    }
//
//    public void setNumber(int num) {
//        this.number = num;
//    }
//
//    public void setPages(int startpg, int endpg) {
//        this.pageStart = startpg;
//        this.pageEnd = endpg;
//    }
//    
//    public void setMonth(String month) {
//        this.month = month;
//    }
//
//    //Getters
//    public String getJournal() {
//        return this.journal;
//    }
//
//    public String getAddress() {
//        return this.address;
//    }
//
//    public int getVolume() {
//        return this.volume;
//    }
//
//    public int getNumber() {
//        return this.number;
//    }
//
//    public int getStartPage() {
//        return this.pageStart;
//    }
//
//    public int getEndPage() {
//        return this.pageEnd;
//    }
//    
//    public String getMonth() {
//        return month;
//    }
//
//}
