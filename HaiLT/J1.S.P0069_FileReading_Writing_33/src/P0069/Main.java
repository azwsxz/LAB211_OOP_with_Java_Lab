package P0069;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    Scanner sc = new Scanner(System.in);
    File fp;

    private void displayGUI() {

        System.out.println("========== Write Program ==========");
        System.out.println("Do you want to write file? (Y/N or y/n)");
        while (true) {
            String choice = sc.nextLine();
            if (choice.matches("Y|y")) {
                String path = checkFilePath("Please enter file path: ");
                writeFile(fp);
                return;
            } else if (choice.matches("N|n")) {
                break;
            } else {
                System.out.println("Please enter Y/N or y/n");
            }
        }
    }

    private void readFile(File path) throws FileNotFoundException, IOException {

        FileReader fr = new FileReader(path);
        LineNumberReader lnr = new LineNumberReader(fr);
        String line;
        while ((line = lnr.readLine()) != null) {
            System.out.println(line);
        }
        lnr.close();
        fr.close();
    }

    private void writeFile(File path) {

        System.out.println("Please enter file content: ");
        System.out.println("Contentfile");
        System.out.println("Save file with content <save> or <SAVE>");
        String content = "";
        String input = "";
        while (true) {
            input = sc.next();
            if (input.equals("save") || input.equals("SAVE")) {
                break;
            } else {
                content += input;
            }
        }
        try {
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter buffer = new BufferedWriter(fw);
            buffer.write(content);
            buffer.close();
            System.out.println("Do you want to read file (Y/N) or (y/n)");
            while (true) {
                String ans = sc.nextLine();
                if (ans.matches("Y|y")) {
                    checkFilePath("Please enter file path: ");
                    readFile(path);
                    break;
                } else if (ans.matches("N|n")) {
                    break;
                } else {
                    System.out.println("Please enter Y/N or y/n");
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String checkFilePath(String mess) {
        System.out.println(mess);
        while (true) {
            String path = sc.nextLine();
            fp = new File(path);
            if (fp.exists()) {
                return path;
            } else {
                System.out.println("Please enter path file exist!");
                System.out.println("File path: ");
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.displayGUI();
    }
}
