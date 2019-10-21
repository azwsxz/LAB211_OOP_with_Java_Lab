package P0025;

import java.io.File;
import java.util.Scanner;

public class Normalized_File {

    Scanner sc = new Scanner(System.in);

    //check path file
    public String checkPath(String mess) {
        String path = "";
        while (true) {
            System.out.print(mess);
            path = sc.nextLine();
            File fp = new File(path);
            if (fp.exists()) {
                return path;
            } else {
                System.out.println("Please enter file path exist!\nTry again!");
            }
        }
    }
    
    //check only one space between words
    public String formatSpaceBetweenWords(String line) {
        line = line.replaceAll("\\s+", " "); 
        line = line.toLowerCase();
        line = oneSpaceSpecial(line, ".");
        line = oneSpaceSpecial(line, ",");
        line = oneSpaceSpecial(line, ":");
        line = oneSpaceSpecial(line, "\"");
        return line.trim();
    }
    
    public String oneSpaceSpecial(String line, String character) {
        StringBuffer stringBuffer = new StringBuffer();
        //System.out.println(line);
        String[] stringLine = line.split("\\s*\\" + character + "\\s*");
        for (int i = 0; i < stringLine.length; i++) {
            stringBuffer.append(stringLine[i] + character + " ");
            //System.out.println(stringBuffer.append(stringLine[i] + character + " "));
        }
        return stringBuffer.toString().trim().substring(0, stringBuffer.length() - 2);
    }

    public String afterDotUppercase(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length() - 2; i++) {
            if (stringBuffer.charAt(i) == '.') {
                stringBuffer.setCharAt(i + 2, Character.toUpperCase(stringBuffer.charAt(i + 2)));
            }
        }
        return stringBuffer.toString().trim();
    }
    
    //normalize line no spaces before and after sentence or word phrases in quotes ("")
    int c = 0;

    public String formatSpaceInQuotes(String line) {

        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '"' && c % 2 == 0) {
                if (stringBuffer.charAt(i + 1) == ' ') {
                    stringBuffer.deleteCharAt(i + 1);
                }
                stringBuffer.insert(i, " ");
                c++;
                i++;
            } else if (stringBuffer.charAt(i) == '"' && c % 2 == 1 && i != 0) {
                if (stringBuffer.charAt(i - 1) == ' ') {
                    stringBuffer.deleteCharAt(i - 1);
                }
                c++;
                //i += 2;
            }
        }
        return stringBuffer.toString().trim();
    }

    public String firstUpercase(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                stringBuffer.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                break;
            }
        }
        return stringBuffer.toString().trim();
    }
    
    public String dotEndText(String line) {
        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
        }
    }
}
