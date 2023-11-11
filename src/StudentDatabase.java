import java.util.Scanner;

public class StudentDatabase {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // Ask how many new students we want to add to the database
        System.out.print("NO OF STUDENTS? ");
        int NumberS = userInput.nextInt(); // Get the total Number of students

        // Create an array of Student objects of size 'NumberS'
        Student[] students = new Student[NumberS];
        for (int i = 0; i < NumberS; i++) {
            students[i] = new Student();
            int choice; // To store the user's choice

            do {
                System.out.println("""

                        **************************
                        ENTER YOUR CHOICE
                        1.Show Info
                        2.Enrollment
                        3.Pay Tuition
                        4.Exit""");

                choice = userInput.nextInt(); // Get the user's choice

                switch (choice) {
                    case 1:
                        students[i].showStudentInfo(); // Display the student's information
                        break;
                    case 2:
                        students[i].coursesENROLL(); // Enroll in courses
                        break;
                    case 3:
                        students[i].payTuition(); // Pay tuition
                        break;
                    case 4:
                        System.out.println("\nTHANKS FOR USING THE APPLICATION!");
                        break;
                    default:
                        System.out.println("INVALID CHOICE! PLEASE ENTER AGAIN!");
                }
            } while (choice != 4);
        }
    }
}

/* Expected Output:

Application should do the following:

    Ask the user how many new students will be added to the database
    The user should be prompted to enter the name and year for each student
    The student should have a 5-digit unique ID, with the first number being their grade level
    A student can enroll in the following courses:
        History
         Mathematics,
        English
        Chemistry
        Computer Science
    Each course costs $600 to enroll
    The students should be able to view their balance and pay the tuition
    To see the status of the student, we should see their name, ID, courses enrolled, and balance

*/