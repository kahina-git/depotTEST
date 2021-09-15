package pratique1.a18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;


public class FileReader {
    public static String loadFileIntoString(String filePath)
    {
         FileInputStream fileInputStream = null;
         String mainJson = null;
        try {
             fileInputStream=new FileInputStream(filePath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            mainJson=IOUtils.toString(fileInputStream,"UTF-8");
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    return mainJson;
    }
    
}
