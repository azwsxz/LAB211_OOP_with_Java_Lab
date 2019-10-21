
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author XuanTruong
 */
public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/A.txt"));
            BufferedWriter output = new BufferedWriter(new FileWriter("src/B.txt"));
            Manager manager = new Manager();
            String line;
            int count = 0, countLine = manager.countLine();

            //loop until end line of file
            while ((line = input.readLine()) != null) {

                //check line is empty
                if (line.length() == 0) {
                    continue;
                }
                count++;
                line = manager.formatSpaceAfterSpecial(line);
                line = manager.formatSpaceBetweenWords(line);
                line = manager.formatSpaceInQuotes(line);
                line = manager.formatSpaceBeforeSpecial(line);
                line = manager.formatUpperAfterDot(line, count);
                line = manager.formatUpperFirstLine(line, count);
                line = manager.formatDotEndText(line, count);
                output.write(line);
            }
            input.close();
            output.close();
            System.out.println("Normalize successful.");
        } catch (FileNotFoundException ex) {
            System.out.println("File is not found!");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
