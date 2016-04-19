
package referenzixx.refs;

/**
 *
 * Article reference. Extends Reference class and inherits its public methods
 */
public class Article extends Reference{
   
    private String journal, address;
    private int volume, number;
    //Article starting and ending pages
    private int pageStart, pageEnd;
   
    //Constructor for article. Very ugly with 10 parameters.
    public Article(String refNum, String authors, String title, String journal, int volume,
                   int year/*, int number, int startpage, int endpage, String publisher,
                   String address*/) {
        this.refNum = refNum;
        this.author=authors;
        this.title = title;
        this.journal=journal;
        this.volume=volume;
        this.year = year;
        //this.number = number;
        //this.pageStart = startpage;
        //this.pageEnd = endpage;
        //this.publisher = publisher;
        //this.address = address;
    }
    
    // Muuttaa artikkeli-olion bibtex-muotoon
    @Override
    public String toString() {
        return "\n@article{" + this.getRefNum() + ",\n"
                + "author = {" + this.getAuthor() + "},\n"
                + "title = {" + this.getTitle() + "},\n"
                + "journal = {" + this.getJournal() + "},\n"
                + "year = {" + this.getYear() + "},\n"
                + "volume = {" + this.getVolume() + "},\n}";      
    }
    
   
    //Setters.
    public void setJournal(String jour){
        this.journal = jour;
    }
   
    public void setAddress(String addrs){
        this.address = addrs;
    }
   
    public void setVolume(int vol){
        this.volume = vol;
    }
   
    public void setNumber(int num){
        this.number = num;
    }
    
    public void setPages(int startpg, int endpg){
        this.pageStart = startpg;
        this.pageEnd = endpg;
    }
   
    //Getters
    public String getJournal(){
        return this.journal;
    }
   
    public String getAddress(){
        return this.address;
    }
   
    public int getVolume(){
        return this.volume;
    }
   
    public int getNumber(){
        return this.number;
    }
   
    public int getStartPage(){
        return this.pageStart;
    }
   
    public int getEndPage(){
        return this.pageEnd;
    }
 
}
