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


}
