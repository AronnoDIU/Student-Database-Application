import java.util.Scanner;

public class Student {
    public Scanner userInput = new Scanner(System.in);

    // Setting up the variables Defined as 'private' so that these cannot be accessed directly
    private static int noOfStudents = 0;
    private final String studentName;
    private final int enrollYear;
    private final String studentID;
    private int balance;
    private final String[] coursesList = new String[5]; // To store the courses

    // Constructor to receive the student's name and year
    public Student() {
        noOfStudents++; // Initializing and Incrementing the number of students

        System.out.print("Enter the full name of the student: ");
        this.studentName = userInput.nextLine();

        System.out.println("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior");

        System.out.print("Enter year: ");
        this.enrollYear = userInput.nextInt();

        // Setting the student's ID
        this.studentID = generateID();
    }

    // Generating the 5-digit unique ID
    private String generateID() {
        // Converting the year to string
        StringBuilder studentID = new StringBuilder(this.enrollYear + "");

        // Getting the number of digits in noOfStudents variable
        // and adding 1 to it to get the number of digits in the ID variable.
        int numberOfDigits = (int) Math.floor(Math.log10(noOfStudents) + 1);

        // Adding leading zeros to the ID variable to make it 5 digits long if necessary.
        studentID.append("0".repeat(Math.max(0, 4 - numberOfDigits)));
        studentID.append(noOfStudents); // Appending the number of students
        return studentID.toString(); // Returning the ID
    }

    // Enroll in courses
    public void coursesENROLL() {
        // To store the index of the courses in the coursesList array if it is not null.
        int flag = -1; // To count the number of courses

        System.out.println("""

                ENTER THE COURSES YOU WISH TO ENTER
                1.History
                2.Maths
                3.English
                4.Chemistry
                5.Comp Science""");

        while (true) {
            System.out.println("ENTER CODE OF COURSE TO ENROLL // ENTER 9 TO EXIT: ");
            int choice = userInput.nextInt();

            if (choice == 9) {
                break;
            } else {

                // If the choice is valid
                if (choice > 0 && choice < 6) {

                    flag++; // Incrementing the index
                    this.balance += 600; // Increasing the balance

                    switch (choice) {
                        case 1:
                            this.coursesList[flag] = "History";
                            break;
                        case 2:
                            this.coursesList[flag] = "Maths";
                            break;
                        case 3:
                            this.coursesList[flag] = "English";
                            break;
                        case 4:
                            this.coursesList[flag] = "Chemistry";
                            break;
                        case 5:
                            this.coursesList[flag] = "Computer Science";
                            break;
                    }
                } else {
                    System.out.println("INVALID CHOICE! PLEASE ENTER AGAIN!");
                }
            }
        }
    }

    // View balance
    private void viewBalance() {
        System.out.println("Your Current Balance is : $" + this.balance);
    }

    // Pay Tuition
    public void payTuition() {
        this.viewBalance();
        System.out.print("Enter the amount of money that you want to pay: $");
        int makePayment = userInput.nextInt();
        this.balance = this.balance - makePayment;
        System.out.println("Thanks for the payment of $" + makePayment + " !");
        this.viewBalance(); // Displaying the balance
    }

    // Returning the student's courses
    private String showCourses() {
        StringBuilder stringBuilder = new StringBuilder();

        // Iterating through the coursesList array and appending the courses to the StringBuilder.
        for (String course : this.coursesList) {
            if (course != null)
                stringBuilder.append(course).append(", ");
        }
        return stringBuilder.toString(); // Returning the courses
    }

    // Displaying the student's information
    public void showStudentInfo() {
        System.out.println("Name: " + this.studentName + "\nID: " + this.studentID
                + "\nEnrolled Year: " + this.enrollYear + "\nCourses Enrolled: " + this.showCourses());

        this.viewBalance(); // Displaying the balance

    }
}
