package mobi.reid.AoC2018.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by gavinreid on 28/11/18.
 */
public class Helper {



    public static String getStringfromFile(String filename){

        File file = new File(filename);
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            return new String(bytes, "UTF-8");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }
}
