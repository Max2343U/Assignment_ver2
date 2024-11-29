package application;

import util.LinkedList;
import util.LinkedNode;
import java.util.Scanner;

public class Training {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList employeeList = new LinkedList();

        // user input for employees
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

            // Allow user to choose a course, case-insensitive
            System.out.print("Enter course name (Food Safety/Food Prep): ");
            String courseName = scanner.nextLine().trim().toLowerCase();

            if (courseName.equals("food safety") || courseName.equals("food prep")) {
                courseName = "FOOD " + courseName;  // Correct the case to be consistent
            } else {
                System.out.println("Invalid course choice. Defaulting to ERROR.");
                courseName = "FOOD ERROR";  // If invalid course name is entered
            }

            Employee newEmployee = new Employee(empNumber, name, years, courseName);
            employeeList.add(newEmployee);
        }

        // Display all employee details
        System.out.println("\nDisplaying all employee details:");
        employeeList.displayList();

        // Search for employee by ID, name, or course name
        System.out.println("\nEnter search query (Employee ID, Name, or Course Name): ");
        String searchQuery = scanner.nextLine();
        searchEmployee(employeeList, searchQuery);

        // Remove employee by number
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

        // Display remaining employees
        System.out.println("\nRemaining employees:");
        employeeList.displayList();

        // Delete employees by course name
        System.out.print("\nEnter course name to delete all employees from: ");
        String courseToDelete = scanner.nextLine();
        employeeList.removeEmployeesByCourse(courseToDelete);

        // Display remaining employees 
        System.out.println("\nRemaining employees after course removal:");
        employeeList.displayList();
    }

    // Search for an employee by id, name, or course name -- custom
    public static void searchEmployee(LinkedList employeeList, String query) {
        LinkedNode current = employeeList.getFirst(); // Access the 'first' node using the getter
        boolean found = false;

        while (current != null) {
            Employee employee = (Employee) current.getElement();

            // Check if the "code/input?" matches the employee number, name, or course name
            if (String.valueOf(employee.getEmployeeNumber()).contains(query) ||
                employee.getName().toLowerCase().contains(query.toLowerCase()) ||
                employee.getCourseName().toLowerCase().contains(query.toLowerCase())) {
                employee.displayEmployee(); // Display employee details
                found = true;
            }
            current = current.getNext(); // Move to the next node
        }

        if (!found) {
            System.out.println("No employee found with the search term: " + query);
        }
    }
}
