
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tad
 */
public class Main {

    public void display() {
        System.out.println("======== Word Program ========");
        System.out.println("1. Count Word In File");
        System.out.println("2. Find File By Word");
        System.out.println("3. Exit");
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        ListAndSeachFile l = new ListAndSeachFile();
        while (true) {
            m.display();
            int choice = l.checkIntChoice(1, 3, "Please choice one option: ");
            switch (choice) {
                case 1:
                    System.out.println("----- Find File By Word -----");
                    System.out.print("Enter path: ");
                    String path = sc.nextLine().trim();
                    File fp = new File(path);
                    if (fp.exists() && fp.isFile()) {
                        System.out.print("Enter Word: ");
                        String word = sc.next().trim();
                        int count = l.countWordInFile(path, word);
                        System.out.println("Count: " + count);
                    } else {
                        System.out.println("File doesn't exist!");
                    }
                    break;
                case 2:
                    l.getFileNameContainsWordInDirectory();
                    break;
                case 3:
                    return;
            }
        }
    }
}
