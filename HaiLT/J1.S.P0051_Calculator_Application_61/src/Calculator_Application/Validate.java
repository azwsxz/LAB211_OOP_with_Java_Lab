
package Calculator_Application;

import java.util.Scanner;


public class Validate {

    Scanner sc = new Scanner(System.in);

    public int getUserChoice(String mess) {

        int c = 0;
        while (true) {
            try {
                System.out.println(mess);
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2 || c == 3) {
                    break;
                } else {
                    System.out.println("Please just enter 1 or 2 or 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Plesea input number");
            } catch (NullPointerException ex) {
                System.out.println("Please dont input space!");
            }
        }
        return c;
    }

    public double getNormalNumber(String mess) {

        double a = 0;
        while (true) {
            try {
                System.out.println(mess);
                a = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Plesea input number");
            } catch (NullPointerException ex) {
                System.out.println("Please dont input space!");
            }
        }
        return a;
    }

    public String getOperator(String mess) {
        String c = "";
        while (true) {
            System.out.println(mess);
            c = sc.nextLine();
            if(c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/")||c.equals("^")||c.equals("=")){
                break;
            }else{
                System.out.println("Please input (+, -, *, /)");
            }
            
        }
        return c;
    }
    
    public Double getIBM(String mess){
        double a = 0;
        while(true){
            try {
                System.out.println(mess);
                a = Double.parseDouble(sc.nextLine());
                if(a <=0){
                    System.out.println("Please enter positive integer number");
                }else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("IBM is digit");
            }
        }
        return a;
    }
}
