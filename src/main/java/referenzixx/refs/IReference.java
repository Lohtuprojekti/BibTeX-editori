package referenzixx.refs;

/**
 *
 * @author lilkettu
 */
public interface IReference {

    String getAuthor();

    String getPublisher();

    //Getters
    String getRefNum();

    String getTitle();

    int getYear();

    void setAuthor(String author);

    void setPublisher(String publ);

    //Setters
    void setRefNum(String ref);

    void setTitle(String title);

    void setYear(int year);

    // Muuttaa referenssi-olion bibtex-muotoon
    String toString();

}
