package mobi.reid.AoC2018.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

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

    public static HashMap<Character, Integer> generateLetterCounts(String token){
        HashMap<Character, Integer> result = new HashMap<>();
        int count = 0;
        for (int i = 0; i < token.length(); i++) {
            char currentLetter = token.charAt(i);
            if (result.containsKey(currentLetter)) {
                count = result.get(currentLetter) + 1;
                result.put(currentLetter, count);

            } else {
                result.put(currentLetter, 1);
            }
        }
        return result;
    }
}
