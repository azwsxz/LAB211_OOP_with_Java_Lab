
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XuanTruong
 */
public class Manager {

    //normalize line have one space after comma (,), dot (.) and colon (:)
    public String formatSpaceAfterSpecial(String line) {
        line = line.replaceAll("\\.", ". ");
        line = line.replaceAll("\\,", ", ");
        line = line.replaceAll("\\:", ". ");
        return line;
    }

    //normalize line have one space between words and the quote
    public String formatSpaceBetweenWords(String line) {

        //s is regex catch the quote
        String s = '"' + "";
        line = line.replaceAll("\\" + s, " " + s + " ");
        line = line.replaceAll("\\s+", " ");
        return line.trim();
    }

    //normalize line have no spaces before and after sentence in quotes (“”).
    private static int countQuotes = 0;

    public String formatSpaceInQuotes(String line) {
        StringBuffer newLine = new StringBuffer(line);

        //loop begin first character, come to next character and stop at last character
        for (int i = 0; i < newLine.length(); i++) {

            //check character is quote
            if (newLine.charAt(i) == '"') {
                countQuotes++;

                //delete space after first quote if it has
                if (countQuotes % 2 == 1 && newLine.charAt(i + 1) == ' ') {
                    newLine = newLine.deleteCharAt(i + 1);
                    continue;
                }

                //delete space before quote if it has
                if (countQuotes % 2 == 0 && newLine.charAt(i - 1) == ' ') {
                    newLine = newLine.deleteCharAt(i - 1);
                }
            }
        }
        return newLine.toString();
    }

    //normalize line have no space between comma or dot and word in front of it.
    public String formatSpaceBeforeSpecial(String line) {
        line = line.replaceAll("\\s[\\.\\,]", ".");
        return line;
    }

    //list check line end dot
    private static List<Boolean> beforeLineEndDot = new ArrayList<>();

    //update line end with dot
    private void updateLineEndDot(String line) {

        //update list check line end dot
        if (line.endsWith(".")) {
            beforeLineEndDot.add(Boolean.TRUE);
        } else {
            beforeLineEndDot.add(Boolean.FALSE);
        }
    }

    //normalize line have first character of word after dot 
    //is in Uppercase and other words are in lower case    
    public String formatUpperAfterDot(String line, int count) {
        line = line.toLowerCase();
        updateLineEndDot(line);
        StringBuffer newLine = new StringBuffer(line);

        //loop begin first character, come to next character and stop at
        //two index before last character
        for (int i = 0; i < newLine.length() - 2; i++) {

            //check character index i is dot
            if (newLine.charAt(i) == '.') {
                newLine.setCharAt(i + 2, Character.toUpperCase(newLine.charAt(i + 2)));
            }
        }
        //check before line end with dot
        if (count > 1 && beforeLineEndDot.get(count - 2)) {
            newLine.setCharAt(0, Character.toUpperCase(newLine.charAt(0)));
        }
        return newLine.toString();
    }

    //normalize line have first character of word in first line is in Uppercase.
    public String formatUpperFirstLine(String line, int count) {

        //check count with 1, mean check first line
        if (count == 1) {
            String afterFirstChar = line.substring(1);
            line = line.charAt(0) + "";
            line = line.toUpperCase() + afterFirstChar;
        }
        return line;
    }

    //normalize line must have dot at the end of text.
    public String formatDotEndText(String line, int count) {
        int countLine = countLine();

        //check count with count line of text, mean check last line
        if (count == countLine) {

            //check last line end with dot
            if (!line.endsWith(".")) {
                line = line + ".";
            }
        } else {
            line += "\n";
        }
        return line;
    }

    public int countLine() {
        int count = 0;
        try {
            BufferedReader input = new BufferedReader(new FileReader("input.txt"));
            String line;

            //loop until end line of file
            while ((line = input.readLine()) != null) {

                //check line is empty
                if (line.length() == 0) {
                    continue;
                }
                count++;
            }
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File is not found!");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return count;
    }
}
