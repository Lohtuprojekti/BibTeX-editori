package referenzixx.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterSequencerTest {

    @Test
    public void testNextWithInitializedCharacter() {
        CharacterSequencer characterSequencer = new CharacterSequencer("b");
        String nextCharacter = characterSequencer.next();
        assertEquals("c", nextCharacter);
    }    

    @Test
    public void testNextWithDefaultConstructor() {
        CharacterSequencer characterSequencer = new CharacterSequencer();
        String nextCharacter = characterSequencer.next();
        assertEquals("a", nextCharacter);
    }
    
    @Test
    public void testMultipleNextWithDefaultConstructor() {
        CharacterSequencer characterSequencer = new CharacterSequencer();
        String firstCharacter = characterSequencer.next();
        String secondCharacter = characterSequencer.next();
        String thirdCharacter = characterSequencer.next();
        assertEquals("a", firstCharacter);
        assertEquals("b", secondCharacter);
        assertEquals("c", thirdCharacter);
    }
    
    @Test
    public void testMultipleNextWithAAB() {
        CharacterSequencer characterSequencer = new CharacterSequencer("aab");
        String firstCharacter = characterSequencer.next();
        String secondCharacter = characterSequencer.next();
        String thirdCharacter = characterSequencer.next();
        assertEquals("aac", firstCharacter);
        assertEquals("aad", secondCharacter);
        assertEquals("aae", thirdCharacter);
    }
    
    @Test
    public void testNextWithEmptyInitialization() {
        CharacterSequencer characterSequencer = new CharacterSequencer("");
        String nextCharacter = characterSequencer.next();
        assertEquals("a", nextCharacter);
    }
        
    @Test
    public void testNextWithNullInitialization() {
        CharacterSequencer characterSequencer = new CharacterSequencer(null);
        String nextCharacter = characterSequencer.next();
        assertEquals("a", nextCharacter);
    }
    
    @Test
    public void testNextAfterZ() {
        CharacterSequencer characterSequencer = new CharacterSequencer("z");
        String nextCharacter = characterSequencer.next();
        assertEquals("aa", nextCharacter);
    }
    
    @Test
    public void testNextAfterAB() {
        CharacterSequencer characterSequencer = new CharacterSequencer("ab");
        String nextCharacter = characterSequencer.next();
        assertEquals("ac", nextCharacter);
    }
    
    @Test
    public void testNextAfterAZ() {
        CharacterSequencer characterSequencer = new CharacterSequencer("az");
        String nextCharacter = characterSequencer.next();
        assertEquals("ba", nextCharacter);
    }
        
    @Test
    public void testNextAfterZZ() {
        CharacterSequencer characterSequencer = new CharacterSequencer("zz");
        String nextCharacter = characterSequencer.next();
        assertEquals("aaa", nextCharacter);
    }
    
    @Test
    public void testNextAfterRandomWord() {
        CharacterSequencer characterSequencer = new CharacterSequencer("changeMyLastCharacter");
        String nextCharacter = characterSequencer.next();
        assertEquals("changeMyLastCharactes", nextCharacter);
    }
    
    @Test
    public void testNextAfterEmptyInitialization() {
        CharacterSequencer characterSequencer = new CharacterSequencer("");
        String nextCharacter = characterSequencer.next();
        assertEquals("a", nextCharacter);
    }
    
    @Test
    public void testWithInitializedWordOutOfScope() {
        CharacterSequencer characterSequencer = new CharacterSequencer("aböz");
        String nextCharacter = characterSequencer.next();
        assertEquals("acaa", nextCharacter);
    }
}
