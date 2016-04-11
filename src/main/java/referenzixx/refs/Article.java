/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public Article(String authors, String title, String journal, int volume,
                   int number, int year, int startpage, int endpage, String publisher,
                   String address){
        this.author=authors;
        this.title = title;
        this.journal=journal;
        this.volume=volume;
        this.number = number;
        this.year = year;
        this.pageStart = startpage;
        this.pageEnd = endpage;
        this.publisher = publisher;
        this.address = address;
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
