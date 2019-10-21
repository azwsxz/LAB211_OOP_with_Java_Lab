
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author datdqse05327
 */
public class ListAndSeachFile {

    public int checkIntChoice(int min, int max, String message) {
        Scanner sc = new Scanner(System.in);
        int number;
        String check;
        while (true) {
            try {
                System.out.print(message);
                check = sc.nextLine().trim();
                if (check.isEmpty()) {
                    System.out.println("You input nothing!");
                    continue;
                }
                number = Integer.parseInt(check);
                if (number < min || number > max) {
                    System.out.printf("Number must be in range [%d-%d]!\n", min, max);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Number not contain charater!");
            }
        }
    }

    public void checkPath() {
        Scanner sc = new Scanner(System.in);
        String path = "";
        System.out.println("----- Check Path -----");
        System.out.print("Enter path: ");
        path = sc.nextLine();
        File fp = new File(path);
        if (fp.exists() && fp.isFile()) {
            System.out.println("Path to file");
        } else if (fp.exists() && fp.isDirectory()) {
            System.out.println("Path to Directory");
        } else {
            System.out.println("Path doesn't exist");
        }
    }

    public int countWordInFile(String fileSource, String word) throws FileNotFoundException, IOException {
        int count = 0;
        File fp = new File(fileSource);
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            if (line.length() == 0) {
                line = br.readLine();
                continue;
            }
            String[] wordsLine = line.split("\\s+");
            for (int i = 0; i < wordsLine.length; i++) {
                if (wordsLine[i].equalsIgnoreCase(word)) {
                    count++;
                }
            }
            line = br.readLine();
        }
        return count;
    }

    public void getFileNameContainsWordInDirectory() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Find File By Word -----");
        System.out.print("Enter path: ");
        String path = sc.nextLine().trim();
        File fp = new File(path);
        File[] files = fp.listFiles();
        if (fp.exists()) {
            System.out.print("Enter Word: ");
            String word = sc.next().trim();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    if (countWordInFile(files[i].getAbsolutePath(), word) != 0) {
                        System.out.println("file name " + files[i].getName());
                    }
                }
            }
        } else {
            System.out.println("File doesn't exist!");
        }
    }
}
