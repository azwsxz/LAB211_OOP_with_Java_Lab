
import java.io.IOException;

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

    private void display() {
        System.out.println("======== File Processing ========");
        System.out.println("1. Check Path");
        System.out.println("2. Get file name with type java");
        System.out.println("3. Get file with size greater than input");
        System.out.println("4. Write more content to file");
        System.out.println("5. Read file and count characters");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        HandleFile h = new HandleFile();
        while (true) {
            m.display();
            int choice = h.checkIntChoice(1, 6, "Please choice one option: ");
            switch (choice) {
                case 1:
                    h.checkPath();
                    break;
                case 2:
                    h.listFileJava();
                    break;
                case 3:
                    h.fileSizeLargerInputSize();
                    break;
                case 4:
                    h.addContentFile();
                    break;
                case 5:
                    h.countWords();
                    break;
                case 6:
                    return;
            }
        }
    }
}
