import java.util.*;

class StudentGradeTracker {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Student> db = new ArrayList<Student>();

    public static void main(String[] args) {
        boolean home = true;

        do {
            System.out.println("\n****** Welcome to Student Grade Tracker ***********");
            System.out.println("Select the input:-");
            System.out.println("1. Enter Student data\n2. Get Student Grade\n3. Exit");
            System.out.print("Enter a Input: ");
            int input = scan.nextInt();

            switch (input) {
                case 1: {
                    addStudent();
                    break;
                }
                case 2: {
                    getStudentGrade();
                    break;
                }
                case 3: {
                    home = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                }
                default: {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        } while (home);
    }

    private static void addStudent() {
        System.out.println("\n******** Welcome to Student Storage ********");
        System.out.print("Enter Name of Student: ");
        String name = scan.next();

        System.out.print("\nEnter Roll No of Student: ");
        int rollNo = scan.nextInt();

        System.out.print("\nEnter date of birth: ");
        String dob = scan.next();

        System.out.println("\nNow Enter the Marks for 5 subjects:");
        int[] marks = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scan.nextInt();
        }

        Student student = new Student(name, rollNo, dob, marks);
        db.add(student);

        System.out.println("\nSuccessfully added student data!");
    }

    private static void getStudentGrade() {
        if (db.isEmpty()) {
            System.out.println("No students in the database. Please add students first.");
            return;
        }

        System.out.print("\nEnter Roll Number of Student to get Grade: ");
        int rollNo = scan.nextInt();

        boolean found = false;
        for (Student student : db) {
            if (student.getRollNo() == rollNo) {
                found = true;
                displayStudentGrade(student);
                break;
            }
        }

        if (!found) {
            System.out.println("Student with Roll Number " + rollNo + " not found.");
        }
    }

    private static void displayStudentGrade(Student student) {
        int[] marks = student.getMarks();
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        double average = total / 5.0;
        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 50) {
            grade = 'C';
        } else {
            grade = 'F';
        }

        System.out.println("\n******** Student Details ********");
        System.out.println("Name: " + student.getName());
        System.out.println("Roll Number: " + student.getRollNo());
        System.out.println("Date of Birth: " + student.getDob());
        System.out.println("Marks: " + Arrays.toString(marks));
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
    }
}
