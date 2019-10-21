/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author datdqse05327
 */
public class Fibo {
    
    /*
    * Method to find 45 sequence Fibonacci
    */
    private int fibo(int n){
        if (n==0 || n == 1){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
    
    /*
    * Fibonacci
    */
    public static void main(String[] args) {
        Fibo m = new Fibo();
        System.out.println("The 45 sequense fibonacci");
        for (int i = 0; i < 45; i++){
            System.out.print(m.fibo(i));
            if (i < 44 ){
                System.out.print(", ");
            }
        }
    }
}
