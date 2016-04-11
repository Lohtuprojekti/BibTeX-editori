/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenzixx.refs;

/**
 *
 * Contains methods for variables that all reference objects inherit:
 * Reference number, author, title and year.
 */
public class Reference {
   
    //refNum is the 3+ character reference number/identifier.
    public String  refNum, title, author, publisher;
    public Integer year;
   
    //Setters
    public void setRefNum(String ref){
        this.refNum = ref;
    }
   
    public void setAuthor(String author){
        this.author = author;
    }
   
    public void setTitle(String title){
        this.title = title;
    }
   
    public void setPublisher(String publ){
        this.publisher = publ;
    }
    
    public void setYear(int year){
        this.year = year;
    }
   
    //Getters
    public String getRefNum(){
        return this.refNum;
    }
   
    public String getAuthor(){
        return author;
    }
    
    public String getPublisher(){
        return this.publisher;
    }
   
    public String getTitle(){
        return this.title;
    }
   
    public int getYear(){
        return this.year;
    }
   
}