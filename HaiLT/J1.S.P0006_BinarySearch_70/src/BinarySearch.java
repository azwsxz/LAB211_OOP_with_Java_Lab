
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
public class BinarySearch {

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

    private int binarySearch(int[] array, int valueSearch) {
        int firt = 0, last = array.length -1;
        int mid = (firt + last) /2;
        while (firt <= last){
            if (array[mid] < valueSearch){
                firt = mid + 1;
            }else if (array[mid] == valueSearch){
                return mid;
            }else{
                last = mid -1;
            }
            mid = (firt + last) /2;
        }
        return -1;
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
        //Check length array
        System.out.print("Enter number of array: ");
        int leng = valiDate();
        
        int[] arr = new int[leng];
        for (int i = 0; i < leng - 1; i++) {
            arr[i] = new Random().nextInt(leng);
        }

        System.out.println("Enter search value");
        String va = sc.nextLine();
        
        BinarySearch sort = new BinarySearch();
        System.out.print("Sorted array:");
        sort.sortAscending(arr);
        sort.displayArray(arr);
        try {
            int v = Integer.parseInt(va);
            int index = sort.binarySearch(arr, v);
            if (index == -1) {
                System.out.println("Not found");
            } else {
                System.out.println("Found " + v + " at index: " + index);
            }
        } catch (Exception e) {
            System.out.println("Not found");
        }
    }
}
