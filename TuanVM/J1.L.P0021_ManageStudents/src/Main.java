
/**
 *
 * @author XuanTruong
 */
public class Main {

    public static void main(String[] args) {
        MyStudent st = new MyStudent();
        InputData in = new InputData();
        int optionNumber;

        //loop until have error or command "break"
        while (true) {
            st.DisplayOption();
            optionNumber = in.inputIntegerNumber(1, 5, "Enter option number: ");
            System.out.println("");

            //check option number and go to case of it
            switch (optionNumber) {
                case 1:
                    System.out.println("-------- Create Student --------");
                    st.createLeast10Student();
                    System.out.println("");
                    continue;
                case 2:
                    st.FindSort();
                    System.out.println("");
                    continue;
                case 3:
                    st.updateDeleteStudent();
                    System.out.println("");
                    continue;
                case 4:
                    st.report();
                    System.out.println("");
                    continue;
                default:
                    break;
            }
            break;
        }
    }
}
