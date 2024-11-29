package application;

import util.LinkedList;
import util.LinkedNode;
import java.util.Scanner;

public class Training {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList employeeList = new LinkedList();

        // user input em[ploee
        System.out.print("Enter the number of employees (up to 10): ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (numEmployees > 10) {
            System.out.println("Cannot add more than 10 employees.");
            return;
        }

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");
            System.out.print("Employee Number: ");
            int empNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Years Working: ");
            int years = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Course Name: ");
            String courseName = scanner.nextLine();

            Employee newEmployee = new Employee(empNumber, name, years, courseName);
            employeeList.add(newEmployee);
        }

        //display destails
        System.out.println("\nDisplaying all employee details:");
        employeeList.displayList();

        // remove bia number
        System.out.print("\nEnter employee number to remove: ");
        int removeEmpNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Employee removeEmp = new Employee(removeEmpNumber, "", 0, "");
        Employee removedEmp = employeeList.remove(removeEmp);

        if (removedEmp == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("Employee with ID " + removeEmpNumber + " was deleted.");
        }

        // display remainder
        System.out.println("\nRemaining employees:");
        employeeList.displayList();

        // delete employee in course
        System.out.print("\nEnter course name to delete all employees from: ");
        String courseToDelete = scanner.nextLine();
        employeeList.removeEmployeesByCourse(courseToDelete);

        // display remainder
        System.out.println("\nRemaining employees after course removal:");
        employeeList.displayList();

        // personal function tbd
    }
}
