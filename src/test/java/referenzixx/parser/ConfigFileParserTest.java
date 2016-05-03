package referenzixx.parser;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigFileParserTest {
    @Test
    public void testFileParser() {
        List<String> content = ConfigFileParser.parseFile("articleConfig.cnf", "***");
        assertTrue(content.size() > 3);
    }
}
