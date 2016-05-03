/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenzixx.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johkauha
 */
public class ConfigFileParser {

    public static List<String> parseFile(String url, String ignore) {
        List<String> lines = new ArrayList<>();

        try{
	    InputStream is = ConfigFileParser.class.getClassLoader().getResourceAsStream(url);
	    InputStreamReader isr = new InputStreamReader(is);
	    BufferedReader br = new BufferedReader(isr); 
            
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(ignore) && !line.isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException ex) {
        }

        return lines;
    }
}
