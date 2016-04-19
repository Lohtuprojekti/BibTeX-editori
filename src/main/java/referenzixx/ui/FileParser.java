/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package referenzixx.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author johkauha
 */
public class FileParser {
    
    public static List<String> parseFile(String url) {
        List<String> lines = new ArrayList<>();
        
        try {
            Scanner scanner = new Scanner(new File(url));
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException ex) {
        }
        
        return lines;
    }
}
