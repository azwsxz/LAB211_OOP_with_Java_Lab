/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator_Application;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author datdqse05327
 */
public class Main {

    Validate v = new Validate();

    public static void main(String[] args) {
        Main r = new Main();
        r.run();
    }

    public void run() {
        while (true) {
            int choice = displayMenu();
            switch (choice) {
                case 1:
                    normalCaculator();
                    break;
                case 2:
                    BMI();
                    break;
                case 3:
                    return;
            }
        }
    }

    public int displayMenu() {
        int a = 0;
        System.out.println("======== Calculator Program ========");
        System.out.println("1. Normal Caculator");
        System.out.println("2. BMI Caculator");
        System.out.println("3. Exit");
        a = v.getUserChoice("Please choice one option:");
        return a;
    }

    public void normalCaculator() {
        double a = 0;
        double b = 0;
        System.out.println("----- Normal Calculator -----");
        a = v.getNormalNumber("Enter number: ");

        while (true) {
            String o = v.getOperator("Enter Operator: ");
            if (o.equals("=")) {
                break;
            }
            b = v.getNormalNumber("Enter number");
            
            if (o.equals("+")) {
                a += b;
            } else if (o.equals("-")) {
                a -= b;

            } else if (o.equals("*")) {
                a *= b;

            } else if (o.equals("/")) {
                if (b == 0) {
                    System.out.println("Please don't division for 0!");
                } else {
                    a /= b;
                }
            } else if (o.equals("^")) {
                a = (int) Math.pow(a, b);
            }
            System.out.println("Memory: " + a);
        }
        System.out.println("Result: " + a);
    }

    public String statusBMI(double n) {
        if (n < 19) {
            return "UNDER-STANDARD";
        } else if (n >= 19 && n < 25) {
            return "STANDARD";
        } else if (n >= 25 && n < 30) {
            return "OVERWEIGHT";
        } else if (n >= 30 && n < 40) {
            return "FAT - should lose weight";
        } else {
            return "VERY FAT - should lose weight immediately";
        }
    }

    public void BMI() {
        NumberFormat nf = new DecimalFormat("#0.00");
        double weight = 0, height = 0, bmi = 0;
        System.out.println("------------ BMI Calculator -----------");
        weight = v.getIBM("Enter Weight (kg): ");
//        System.out.println(weight);
        height = v.getIBM("Enter Height (cm): ");
        height = height / 100;
//        System.out.println(height);
        bmi = weight / (height * height);
        System.out.println("BMI number: " + nf.format(bmi));
        System.out.println("BMI status: " + statusBMI(bmi));
    }
}
