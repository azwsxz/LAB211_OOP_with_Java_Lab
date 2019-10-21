
import java.util.Scanner;

/**
 *
 * @author XuanTruong
 */
public class InputData {

    Scanner sc = new Scanner(System.in);
    
    //input integer number
    public int inputIntegerNumber(int beginValue, int endValue, String message) {

        int number;
        String checkEmpty;

        //if uses input positive decimal number, exit loop else continue
        while (true) {
            try {
                System.out.print(message);
                checkEmpty = sc.nextLine();

                //check String after remove space is empty or not
                if (checkEmpty.trim().isEmpty()) {
                    System.out.println("You input nothing. Try again!");
                    continue;
                }
                number = Integer.parseInt(checkEmpty);

                //check povitive decimal number
                if (number < beginValue || number > endValue) {
                    System.out.printf("Number must be in range [%d-%d]. Try again!\n",
                            beginValue, endValue);
                    continue;
                }
                return number;
            } catch (NumberFormatException ex) {
                System.out.println("Number must not contain any character. Try again!");
            }
        }
    }

    //input data and check with regular expression
    public String inputWord(String regex, String message, String error) {

        String word;

        //if uses input positive decimal number, exit loop else continue
        while (true) {
            System.out.print(message);
            word = sc.nextLine().trim();

            //check String after remove space is empty or not
            if (word.isEmpty()) {
                System.out.println("You input nothing. Try again!");
                continue;
            }
            
            //check between any true word in have more than one space
            while (word.contains("  ")) {

                //change two spaces to one space
                word = word.replaceAll("  ", " ");
            }

            //check data with regular expression
            if (word.matches(regex)) {
                return word;
            } else {
                System.out.println(error);
            }
        }
    }
}
