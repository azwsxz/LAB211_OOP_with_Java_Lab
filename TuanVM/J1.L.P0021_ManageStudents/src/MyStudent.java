
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author XuanTruong
 */
public class MyStudent {

    public List<Student> st = new ArrayList<>();
    private List<Student> stFind = new ArrayList<>();
    private InputData in = new InputData();

    //check one ID have oneName
    private String nameSameID(String ID) {

        //loop begin at first student element, come to next student element 
        //and stop at last student element
        for (int i = 0; i < st.size(); i++) {

            //compare ID be put into method with student ID of list
            if (ID.equals(st.get(i).getID())) {
                return st.get(i).getStudentName();
            }
        }
        return null;
    }

    //check one student can not have 2 courses are alike in 1 semester
    private boolean checkDuplicate(String ID, String semester, String course) {

        //loop begin at first student element, come to next student element 
        //and stop at last student element
        for (int i = 0; i < st.size(); i++) {

            //compare ID, semester, course be put into method with ID, semester
            //course of student list
            if (ID.equals(st.get(i).getID())
                    && semester.equals(st.get(i).getSemester())
                    && course.equals(st.get(i).getCourseName())) {
                return false;
            }
        }
        return true;
    }

    //display option
    public void DisplayOption() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                + "1. Create\n"
                + "2. Find and Sort\n"
                + "3. Update/Delete\n"
                + "4. Report\n"
                + "5. Exit\n"
                + "(Please choose 1 to Create, 2 to Find and Sort, "
                + "3 to Update/Delete, 4 to Report and 5 to Exit program).");
    }

    //create new object students
    public Student create(boolean controlInputName) {
        Student stCreat = new Student();
        String ID, name, course, semester;

        ID = in.inputWord("[a-zA-Z0-9\\s]+", "Enter student ID: ",
                "ID must not contain special character. Try again!");

        //need to input new name student or check
        //check variable is true
        if (controlInputName) {
            name = nameSameID(ID);
        } else {
            name = null;
        }

        //check name is null
        if (name == null) {
            name = in.inputWord("[a-zA-Z\\s]+", "Enter student name: ",
                    "Name contain only alphabet. Try again!");
        } else {
            System.out.println("Enter student name: " + name);
        }

        semester = in.inputWord("[a-zA-Z0-9\\s]+", "Enter student semester: ",
                "Semester must not contain special character. Try again!");
        
        System.out.println("There are 3 courses you can choose: 'Java', '.Net' and 'C/C++'");
        course = in.inputWord("^(Java|\\.Net|C\\/C\\+\\+)$", "Enter Student course: ",
                "Course does not exit. Only 3 courses you can choose: 'Java', '.Net' and 'C/C++'");

        //check method return true or false
        if (!checkDuplicate(ID, semester, course)) {
            System.out.println("Fail. One student can not have 2 courses"
                    + " are alike in 1 semester!");
            return null;
        }

        stCreat.setID(ID);
        stCreat.setStudentName(name);
        stCreat.setSemester(semester);
        stCreat.setCourseName(course);
        return stCreat;
    }

    //Create at least 10 student
    public void createLeast10Student() {

        //loop until student list have ten student
        while (st.size() < 2) {
            Student stAdd = create(true);

            //check method return null
            if (stAdd != null) {
                st.add(stAdd);
                System.out.println("Create Successful!");
            }
            System.out.println();
        }
        continueCreate();
    }

    //Continue create student or not
    private void continueCreate() {

        //loop until have error or command "break"
        while (true) {
            String choose = in.inputWord("^[YyNn]$", "Do you want to continue (Y/N)? ",
                    "You must input letter Y or N. Try again!");

            //check result of compare choose option with letter Y
            if (choose.equalsIgnoreCase("Y")) {
                Student stAdd = create(true);

                //check method return null
                if (stAdd != null) {
                    st.add(stAdd);
                    System.out.println("Create Successful!");
                    System.out.println("");
                }
            } else {
                break;
            }
        }
    }

    //Find and sort student
    public void FindSort() {
        String nameFind;

        System.out.println("-------- Find and Sort Student --------");
        nameFind = in.inputWord("[a-zA-Z\\s]+", "Enter student find name: ",
                "Name contain only alphabet. Try again");

        //loop begin at first student element, come to next student element 
        //and stop at last student element
        for (int i = 0; i < st.size(); i++) {

            //check student name is contain find name
            if (st.get(i).getStudentName().contains(nameFind)) {
                stFind.add(st.get(i));
            }
        }

        //check find/sort student list is empty or not
        if (stFind.isEmpty()) {
            System.out.println("No result!");
            return;
        }

        Collections.sort(stFind);
        System.out.println("All student is found: ");

        //loop for each element of find/sort student list
        for (Student stDisplay : stFind) {
            System.out.println(stDisplay);
        }
        stFind.clear();
    }

    //update/delete student
    public void updateDeleteStudent() {

        //check find student list is empty or not
        if (st.isEmpty()) {
            System.out.println("You need to creat new student first!");
            return;
        }

        System.out.println("-------- Update/Delete Student --------");
        String ID = in.inputWord("[a-zA-Z0-9\\s]+", "Enter student ID to update/delete: ",
                "ID must not contain special character. Try again!");

        //loop begin at first student element, come to next student element 
        //and stop at last student element
        for (int i = 0; i < st.size(); i++) {

            //check student ID is contain find ID
            if (st.get(i).getID().equals(ID)) {
                stFind.add(st.get(i));
            }
        }

        //check find student list is empty or not
        if (stFind.isEmpty()) {
            System.out.println("No result!");
            return;
        }

        Collections.sort(stFind);
        System.out.println("All student is found: ");

        //loop begin at first student element, come to next student element 
        //and stop at last student element
        for (int i = 0; i < stFind.size(); i++) {
            Student temp = stFind.get(i);
            System.out.printf("Index %d | %s | %s | %s | %s\n", i, ID,
                    temp.getStudentName(), temp.getSemester(), temp.getCourseName());
        }

        int indexChoose = in.inputIntegerNumber(0, stFind.size() - 1, "Enter index: ");

        String choose = in.inputWord("^[UuDd]$", "Do you want to update (U) or "
                + "delete (D) student? ", "You must input letter U or D. Try again!");

        //check result of compare choose option with letter Y
        if (choose.equalsIgnoreCase("U")) {
            update(st.indexOf(stFind.get(indexChoose)));
        } else {
            st.remove(stFind.get(indexChoose));
            System.out.println("Delete Successful!");
        }
        stFind.clear();
    }

    //update student
    private void update(int indexUpdate) {

        Student oldStudent = st.get(indexUpdate);
        st.remove(indexUpdate);
        Student stUpdate = create(false);

        //check student update is null
        if (stUpdate == null) {
            System.out.println("Your change will not be saved!");
            st.add(oldStudent);
            return;
        }

        //check student update is not diffirent old student
        if (stUpdate.getID().equals(oldStudent.getID())
                && stUpdate.getStudentName().equals(oldStudent.getStudentName())
                && stUpdate.getCourseName().equals(oldStudent.getCourseName())
                && stUpdate.getSemester() == oldStudent.getSemester()) {
            System.out.println("Nothing change!");
            st.add(oldStudent);
            return;
        }

        String IDUpdate = stUpdate.getID();

        //loop begin at first student element, come to next student element 
        //and stop at last student element
        for (int i = 0; i < st.size(); i++) {
            //compare id update with list of student id
            if (IDUpdate.equals(st.get(i).getID())) {
                st.get(i).setStudentName(stUpdate.getStudentName());
            }
        }
        st.add(stUpdate);
        System.out.println("Update Successful!");
    }

    //report student
    public void report() {

        //check list student is empty
        if (st.isEmpty()) {
            System.out.println("You need to creat new student first!");
            return;
        }

        System.out.println("-------- Report --------");
        Collections.sort(st);
        Student studentIsCounted = st.get(0);
        int size = st.size();
        int index = 0;

        //loop until index of student is langer than size of list
        while (index < size) {
            int javaCount = 0;
            int dotNetCount = 0;
            int ccplusCount = 0;

            // loop until student is counted diffirent student of list
            while (st.get(index).getID().equals(studentIsCounted.getID())) {

                // check course and move case of it 
                switch (st.get(index).getCourseName()) {
                    case "Java":
                        javaCount++;
                        break;
                    case ".Net":
                        dotNetCount++;
                        break;
                    default:
                        ccplusCount++;
                        break;
                }
                index++;

                //index of student is langer than size of list
                if (index >= size) {
                    break;
                }
            }

            // check course java of student
            if (javaCount != 0) {
                System.out.println(studentIsCounted.getStudentName() + "| Java | " + javaCount);
            }

            //check course java of student
            if (dotNetCount != 0) {
                System.out.println(studentIsCounted.getStudentName() + "| .Net | " + dotNetCount);

            }

            //check course java of student
            if (ccplusCount != 0) {
                System.out.println(studentIsCounted.getStudentName() + "| C/C++ | " + ccplusCount);
            }

            //check index of student is small than size of list
            if (index < size) {
                studentIsCounted = st.get(index);
            }
        }
    }
}
