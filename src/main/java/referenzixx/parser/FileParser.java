/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package referenzixx.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author johkauha
 */
public class FileParser {
    
    public static List<String> parseFile(String url, String ignore) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(url);
            //Tämä paskoi lisäyksen, ilmeisesti joku bugi javassa. 
            //Ei voi käyttää vain scanner(file)
            Scanner scanner = new Scanner(
                                new BufferedReader(
                                    new FileReader(file)));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (!line.startsWith(ignore) && !line.isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (FileNotFoundException ex) {
        }
        
        return lines;
    }
}
