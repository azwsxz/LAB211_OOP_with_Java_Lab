
import java.util.Scanner;
import javax.sound.midi.SysexMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author datdqse05327
 */
public class Main {

    Scanner sc = new Scanner(System.in);

    /*
     Display a menu and ask a user to select an option.
     */

    private void displayMenu() {
        System.out.println("========== Bubble Sort program ==========");
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Descending");
        System.out.println("4. Exit");
        System.out.print("Please choice the option: ");
    }

    /*
    Check inputNumber
     */
    private boolean checkNumber(String value, boolean check) {
        try {
            int va = Integer.parseInt(value);
            if (check) {
                if (va <= 0) {
                    System.out.println("Please input number and number is greater then zero");
                    System.out.print("Enter Number: ");
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Please input number and number is greater then zero");
            System.out.print("Enter Number: ");
            return false;

        }
    }

    /*
     Input array and element(s)
     */
    private void inputArray(BubbleSort bs) {

        System.out.println("Input Length Of Array");
        System.out.print("Enter Number: ");
        String leng = sc.nextLine();
        while (!checkNumber(leng, true)) {
            leng = sc.nextLine();
        }
        int l = Integer.parseInt(leng);
        bs.arrayLength(l);
        for (int i = 0; i < l; i++) {
            System.out.printf("Enter %d: ", i + 1);
            String num = sc.nextLine();
            while (!checkNumber(num, false)) {
                num = sc.nextLine();
            }
            int n = Integer.parseInt(num);
            bs.addValue(n, i);
        }
    }

    /*
    Check input user choice option program
     */
    private String UserChoice() {
        String uc = sc.nextLine();
        while (!uc.matches("1|2|3|4")) {
            System.out.println("Wrong select! Please choice 1, 2, 3, or 4");
            uc = sc.nextLine();
        }
        return uc;
    }

    /*
    Sort one-dimensional array with bubble sort algorithm
     */
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        while (true) {
            m.displayMenu();
            String choice = m.UserChoice();
            switch (choice) {
                case "1":
                    m.inputArray(bs);
                    break;
                case "2":
                    bs.sortAscending();
                    break;
                case "3":
                    bs.sortDescending();
                    break;
                case "4":
                    System.exit(0);
            }
        }
    }
}
