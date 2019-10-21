package P0025;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author datdqse05327
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Normalized_File nf = new Normalized_File();
        String path = nf.checkPath("Enter file path: ");
        System.out.println("src/A.txt");
        m.normalizeFile("src/A.txt");

    }

    private void normalizeFile(String path) {
        Normalized_File nf = new Normalized_File();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("src/B.txt", false);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() == 0) {
                    continue;
                }
                line = nf.formatSpaceBetweenWords(line);
                line = nf.afterDotUppercase(line);
                line = nf.formatSpaceInQuotes(line);
                line = nf.firstUpercase(line);
                line = nf.dotEndText(line);
                //System.out.println(line);
                fw.write(line + "\r\n");
            }
            br.close();
            fw.close();
            System.out.println("Successful.");
        } catch (FileNotFoundException ex) {
            System.out.println("File is not found!");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
