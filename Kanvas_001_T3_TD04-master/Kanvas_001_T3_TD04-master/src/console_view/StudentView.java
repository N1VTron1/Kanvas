package console_view;

import model.Student;

import java.util.Scanner;

public class StudentView {
    public static void display(Student student) {
        System.out.printf("%s %s (%s)%n", student.getFirstName(), student.getLastName(), student.getEmailAddress());
    }

    /**
     * This method creates a student
     * <p>
     *     Also, prompt for student information like last name,
     *     first name, middle name and their PSU Login.
     *     With this info, it creates and return a student.
     * </p>
     *
     * @return the created student
     * @author Kajal Patel (krp5404@psu.edu)
     */
    public static Student createStudent() {
        // TODO 06 - [console_view.StudentView.createStudent] Prompt for student info, create and return the student

        Scanner keyboard = new Scanner(System.in);
        String lastName, firstName, middleName, login;

        boolean valid = false;
        System.out.println("Enter your last Name: ");
        do{
            lastName = keyboard.nextLine() ;
            if (lastName.length() == 0) {
                System.out.println("Cannot be blank");
            }
            else{
                valid = true;
            }
        }while(!valid);

        valid = false;
        System.out.println("Enter your first Name: ");
        do{
            firstName = keyboard.nextLine() ;
            if (firstName.length() == 0) {
                System.out.println("Cannot be blank");
            }
            else{
                valid = true;
            }
        }while(!valid);

        System.out.println("Enter your middle Name: ");
        middleName = keyboard.nextLine() ;

        valid = false;
        System.out.println("Enter your PSU Login: ");
        do{
            login = keyboard.nextLine() ;
            if (login.length() == 0) {
                System.out.println("Cannot be blank");
            }
            else{
                valid = true;
            }
        }while(!valid);


        Student student = new Student(lastName, firstName, middleName, login);
        return student;
    }

    /**
     * This method takes the instance of Student class
     * <p>
     *     Also, display the student details like last name,
     *     first name, middle name, PSU Login and Email.
     * </p>
     *
     * @param student instances of class Student
     * @author Kajal Patel (krp5404@psu.edu)
     */
    public static void displayDetail(Student student) {
        // TODO 07 - [console_view.StudentView.displayDetail] Display student detail
        System.out.println("  Last Name : " + student.getLastName());
        System.out.println(" First Name : " + student.getFirstName());
        System.out.println("Middle Name : " + student.getMiddleName());
        System.out.println("  PSU Login : " + student.getLogin());
        System.out.println("  PSU Email : " + student.getEmailAddress());
    }
}
