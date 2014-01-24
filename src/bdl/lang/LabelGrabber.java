package bdl.lang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author Ben Goodwin
 */
public class LabelGrabber {
    
    private static Properties lang;
    private File languageFile;
    
    public LabelGrabber() {
        lang = new Properties();
        languageFile = new File("lang/gb.lang"); //TODO update later with more languages
        if(languageFile == null) {
            System.err.println("Missing language file at: lang/gb.lang");
            return;
        }
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(languageFile), "UTF-8"))) {
            lang.load(reader);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    public static String getLabel(String key) {
        String string = lang.getProperty(key);
        if(string == null) {
            System.err.println("Missing value for key: " + key);
            return "";
        }
        return string;
    }
}