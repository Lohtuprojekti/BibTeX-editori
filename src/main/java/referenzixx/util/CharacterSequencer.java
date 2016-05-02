package referenzixx.util;

// the purpose of this class is to generate a (multi)character that is
// sequence (a-z), to be used as prefixes for reference ID's.
// ex.: kousa2015a, kousa2015b, kousa2015c ... kousa2015aa, kousa2015ab
public class CharacterSequencer {

    private final char FIRST_ALLOWED_CHARACTER = 'a';
    
    private final char LAST_ALLOWED_CHARACTER = 'z';
    
    private String currChars;

    public CharacterSequencer() {
        resetSequencer();
    }
    
    private void resetSequencer() {
        this.currChars = "" + (char)(FIRST_ALLOWED_CHARACTER-1);
    }

    public CharacterSequencer(String initialChars) {
        if(initialChars == null || initialChars.isEmpty())
            resetSequencer();
        else
            this.currChars = initialChars;
    }

    public String next() {
        this.currChars = generateNext(currChars);
        return currChars;
    }

    // helper method that will generate the next in series [a-z]
    // and increase the string length when reaching the end of char sequence
    // TODO: refactor, move to a different (util?) class
    private String generateNext(String s) {        
        if (lastCharacterIsNotAllowedCharacter(s))
            return replaceLastAllowedCharacter(s);
        else
            return increaseLastCharacter(s);
    }

    private boolean lastCharacterIsNotAllowedCharacter(String s) {
        return getLastCharacter(s) >= LAST_ALLOWED_CHARACTER;
    }

    private char getLastCharacter(String s) {
        int length = s.length();
        char c = s.charAt(length - 1);
        return c;
    }
    
    private String replaceLastAllowedCharacter(String s) {
        int length = s.length();
        return length > 1 ? generateNext(s.substring(0, length - 1)) + 
                FIRST_ALLOWED_CHARACTER : 
                FIRST_ALLOWED_CHARACTER + "" + FIRST_ALLOWED_CHARACTER;
    }

    private String increaseLastCharacter(String s) {
        int length = s.length();
        char c = getLastCharacter(s);
        return s.substring(0, length - 1) + ++c;
    }

}