
import java.util.Random;
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
public class BubbleSort {

    /*
    * Display a screen to prompt users to input a positive decimal number.
     */
    public void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /*
     * Sort array
     */
    public void sortAscending(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /*
    * Check input number 
     */
    private static boolean checkNumber(String value, boolean check) {
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
     * Bubble sort algorithm.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of array: ");
        String length = sc.nextLine();
        while (!checkNumber(length, true)) {
            length = sc.nextLine();
        }
        int leng = Integer.parseInt(length);
        int[] arr = new int[leng];
        for (int i = 0; i < leng; i++) {
            arr[i] = new Random().nextInt(leng);
        }
        BubbleSort sort = new BubbleSort();
        System.out.print("Unsorted array: ");
        sort.displayArray(arr);
        System.out.print("Sorted array: ");
        sort.sortAscending(arr);
        sort.displayArray(arr);
    }
}
