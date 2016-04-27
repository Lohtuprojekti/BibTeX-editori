
package referenzixx.refs;


import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.jbibtex.Key;
import org.jbibtex.KeyValue;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import referenzixx.database.DatabaseUtils;
import referenzixx.ui.ReferencePanel;
import org.jbibtex.BibTeXEntry;

public class ReferenceEntryBuilderTest {
    
    private DatabaseUtils dbutil;
    private List<ReferencePanel> refPanelList;
    private ReferencePanel refpan2, refpan3, refpan4, refpan5;
    
    public ReferenceEntryBuilderTest() {
        
    }
    
    @Before
    public void setup(){
            //4 mock ReferencePanel objects that are listed to refPanelList
            refpan2 = mock(ReferencePanel.class);
            when(refpan2.getType()).thenReturn(new Key("author"));
            when(refpan2.getValue()).thenReturn(new KeyValue("Hassel Hoff"));
            
            refpan3 = mock(ReferencePanel.class);
            when(refpan3.getType()).thenReturn(new Key("year"));
            when(refpan3.getValue()).thenReturn(new KeyValue("1983"));

            refpan4 = mock(ReferencePanel.class);
            when(refpan4.getType()).thenReturn(new Key("title"));
            when(refpan4.getValue()).thenReturn(new KeyValue("Baby it's Baywatch and I'm coming"));

            refpan5 = mock(ReferencePanel.class);
            when(refpan5.getType()).thenReturn(new Key("publisher"));
            when(refpan5.getValue()).thenReturn(new KeyValue("Sunny Beach and Bouncy Boobies productions"));

            refPanelList = Arrays.asList(refpan2, refpan3, refpan4, refpan5);
            dbutil = new DatabaseUtils("src/test/testfile.bib");
    }
    
    @After
    public void tearDown(){
        new File("src/test/testfile.bib").delete();
    }
    
    @Test
    public void whenRefNumIsGivenNewEntryIsBuilt(){
        ReferenceEntryBuilder refebuilder = new ReferenceEntryBuilder();
        BibTeXEntry bentry = refebuilder.buildEntry(new Key("book"), "hoff1983a", dbutil.getDatabase(), refPanelList);
        assertTrue(bentry.getFields().size() == 4);
        assertTrue(bentry.getKey().toString().equals("hoff1983a"));
    }
    
    @Test
    public void whenRefNumIsNotGivenNewEntryIsBuiltWithUniqueRefNum(){
        ReferenceEntryBuilder refebuilder = new ReferenceEntryBuilder();
        BibTeXEntry bentry = refebuilder.buildEntry(new Key("book"), "", dbutil.getDatabase(), refPanelList);
        assertTrue(bentry.getFields().size() == 4);
        assertTrue(bentry.getKey().toString().equals("hoff1983a"));
    }
    

    
    
    
    


}
