
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
public class LinearSearch {

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
    private void sortAscending(int[] array) {
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
    * Program linear search
     */
    private void linearSearch(int[] array, int valueSearch) {
        String s = "";
        boolean check = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueSearch) {
                s += i + " ";
                check = false;
            }
        }
        if (check == false) {
            System.out.println("Found " + valueSearch + " at index: " + s);
        }else{
            System.out.println("Not found!");
        }
    }

    /*
     * Check input number 
     */
    private static int valiDate() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int r = Integer.parseInt(sc.nextLine());
                if (r <= 0) {
                    throw new Exception();
                }
                return r;
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of array: ");
        int leng = valiDate();
        int[] arr = new int[leng];
        for (int i = 0; i < leng; i++) {
            arr[i] = new Random().nextInt(leng);
        }
        System.out.println("Enter search value");
        String value = sc.nextLine();
        LinearSearch ls = new LinearSearch();
        System.out.print("The array:");
        ls.displayArray(arr);
        try {
            int v = Integer.parseInt(value);
            ls.linearSearch(arr, v);
        } catch (Exception e) {
            System.out.println("Not found");
        }
    }
}
