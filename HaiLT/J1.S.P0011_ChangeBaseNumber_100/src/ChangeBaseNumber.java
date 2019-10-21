
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
public class ChangeBaseNumber {

    private static String HEX = "0123456789ABCDEF";

    private static String decToOther(int dec, int base) {
        String result = "";
        while (dec > 0) {
            int temp = dec % base;
            result = HEX.charAt(temp) + result;
            dec /= base;
        }
        return result;
    }

    private static int otherToDec(String other, int base) {
        int result = 0;
        for (int i = other.length() - 1; i >= 0; i--) {
            result += HEX.indexOf(other.charAt(i)) * Math.pow(base, other.length() - 1 - i);
        }
        return result;
    }

    private static int valiDate(Scanner sc, int min, int max) {
        while (true) {
            try {
                int r = Integer.parseInt(sc.nextLine());
                if (r < min || r > max) {
                    throw new Exception();
                }
                return r;
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
    }

    private static String checkInputBase(Scanner sc, int base) {
        String s = HEX.substring(0, base);
        while (true) {
            String r = sc.nextLine();
            r = r.toUpperCase();
            try {
                for (int i = 0; i < r.length(); i++) {
                    if (s.indexOf(r.charAt(i)) == -1) {
                        throw new Exception();
                    }
                }
                return r;
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the base number input:");
        System.out.println("1-Binary");
        System.out.println("2-Decimal");
        System.out.println("3-Hexadecimal");
        int baseInput = valiDate(sc, 1, 3);

        System.out.println("Choose the base number output:");
        System.out.println("1-Binary");
        System.out.println("2-Decimal");
        System.out.println("3-Hexadecimal");
        int baseOutput = valiDate(sc, 1, 3);

        if (baseInput == 1) {
            baseInput = 2;
        } else if (baseInput == 2) {
            baseInput = 10;
        } else {
            baseInput = 16;
        }
        
        System.out.println("Enter the input value");
        String input = checkInputBase(sc, baseInput);
        
        if (baseOutput == 1) {
            baseOutput = 2;
        } else if (baseOutput == 2) {
            baseOutput = 10;
        } else {
            baseOutput = 16;
        }

        if ((baseInput == 2 && baseOutput == 16) || (baseInput == 16 && baseOutput == 2)) {
            int dec = otherToDec(input, baseInput);
            System.out.println("Output value: " + decToOther(dec, baseOutput));
        } else if (baseInput == 10) {
            System.out.println("Output value: " + decToOther(Integer.parseInt(input), baseOutput));
        } else if (baseOutput == 10) {
            System.out.println("Output value: " + otherToDec(input, baseInput));
        }
    }
}
