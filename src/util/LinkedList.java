package util;

import application.Employee;

public class LinkedList {
    private LinkedNode first;
    private LinkedNode last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    // Add employee to the list 
    public void add(Employee employee) {
        if (size >= 10) {
            System.out.println("Error: Cannot add more than 10 employees.");
            return;
        }

        if (!contains(employee)) {
        	LinkedNode newNode = new LinkedNode(employee);
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.setNext(newNode);
                last = newNode;
            }
            size++;
        } else {
            System.out.println("Error: Employee already exists.");
        }
    }

    // Remove employee by number
    public Employee remove(Employee employee) {
    	LinkedNode current = first;
    	LinkedNode previous = null;

        while (current != null) {
            if (((Employee)current.getElement()).equals(employee)) {
                if (current == first) {  // Removing the first node
                    first = current.getNext();
                    if (first == null) {
                        last = null;  
                    }
                } else if (current == last) {  // Removing the last node
                    previous.setNext(null);
                    last = previous;
                } else {  
                    previous.setNext(current.getNext());
                }
                size--;
                return (Employee) current.getElement();
            }
            previous = current;
            current = current.getNext();
        }
        return null;  // If employee not there
    }

    // Remove employees by course name
    public void removeEmployeesByCourse(String courseName) {
    	LinkedNode current = first;
        while (current != null) {
            Employee employee = (Employee) current.getElement();
            if (employee.getCourseName().equals(courseName)) {
                remove(employee);
            }
            current = current.getNext();
        }
    }

    // Check if the list contains employee
    public boolean contains(Employee employee) {
    	LinkedNode current = first;
        while (current != null) {
            if (((Employee)current.getElement()).equals(employee)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Display all employee details 
    public void displayList() {
    	LinkedNode current = first;
        while (current != null) {
            ((Employee) current.getElement()).displayEmployee();
            current = current.getNext();
        }
    }

    // Get size of the list
    public int size() {
        return size;
    }
}
