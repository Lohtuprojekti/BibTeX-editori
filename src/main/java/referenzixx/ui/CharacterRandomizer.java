/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenzixx.ui;

/**
 *
 * @author kkirjala
 */
public class CharacterRandomizer {

    private String currChars;

    public CharacterRandomizer() {

        this.currChars = "";

    }

    public String generateChars() {

        currChars = pickNext(currChars);

        return currChars;

    }

    // helper method that will generate the next in series [a-z]
    // and increase the string length when reaching the end of char sequence
    
    // TODO: refactor to a different (util?) class
    private String pickNext(String s) {

        // initial value
        if (s.length() == 0) {
            return "a";
        }
        
        
        int length = s.length();
        char c = s.charAt(length - 1);

        if (c == 'z') {
            return length > 1 ? pickNext(s.substring(0, length - 1)) + 'a' : "aa";
        }

        return s.substring(0, length - 1) + ++c;

    }

}