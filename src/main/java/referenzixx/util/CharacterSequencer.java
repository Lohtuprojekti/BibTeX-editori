package referenzixx.util;

// the purpose of this class is to generate a (multi)character that is
// sequence (a-z), to be used as prefixes for reference ID's.
// ex.: kousa2015a, kousa2015b, kousa2015c ... kousa2015aa, kousa2015ab
public class CharacterSequencer {

    private String currChars;

    
    public CharacterSequencer(String initialChars) {

        this.currChars = initialChars;

    }

    // next() will return the next in sequence. 
    
    public String next() {

        if (currChars.isEmpty()) {
            currChars = "a";
        } else {
            currChars = generateNext(currChars);
        }

        return currChars;
    }

    // helper method that will generate the next in series [a-z]
    // and increase the string length when reaching the end of char sequence
    // TODO: refactor, move to a different (util?) class
    private String generateNext(String s) {

        // if nothing was given, nothing is returned
        if (s.isEmpty()) {
            return "";
        }
        
        int length = s.length();
        char c = s.charAt(length - 1);

        if (c == 'z') {
            return length > 1 ? generateNext(s.substring(0, length - 1)) + 'a' : "aa";
        }

        return s.substring(0, length - 1) + ++c;

    }

}