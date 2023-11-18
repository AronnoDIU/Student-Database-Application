import java.util.Scanner;

public class StudentDatabase {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // Ask how many new students we want to add to the database
        System.out.print(" HOW MANY NEW STUDENTS YOU WANT TO ADD? ");
        int NumberS = userInput.nextInt(); // Get the total Number of students

        // Create an array of Student objects of size 'NumberS'
        Student[] students = new Student[NumberS];

        for (int i = 0; i < NumberS; i++) {

            // Create a new Student object
            students[i] = new Student();
            int choice; // To store the user's choice

            do {
                System.out.println("""

                        **************************
                        ENTER YOUR CHOICE FROM BELOW
                        1. Show Student Info
                        2. Enrollment of Courses
                        3. Pay Tuition fee for Courses
                        4.Exit""");

                choice = userInput.nextInt(); // Get the user's choice

                switch (choice) {
                    case 1: // Show Student Info
                        students[i].showStudentInfo(); // Display the student's information
                        break;
                    case 2: // Enrollment of Courses
                        students[i].coursesENROLL(); // Enroll in courses
                        break;
                    case 3: // Pay Tuition fee for Courses
                        students[i].payTuition(); // Pay tuition
                        break;
                    case 4: // Exit
                        System.out.println("\nTHANKS FOR USING THE APPLICATION!");
                        break;
                    default: // Invalid Choice
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