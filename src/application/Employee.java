package application;

public class Employee {
    private int employeeNumber;
    private String name;
    private int yearsWorking;
    private String courseName;

    // Constructor 
    public Employee(int employeeNumber, String name, int yearsWorking, String courseName) {
        if (yearsWorking < 5) {
            System.out.println("Employee must have more than 5 years of experience.");
            return;
        }

        if (!courseName.startsWith("FOOD")) {
            this.courseName = "ERROR";
            System.out.println(" Invalid course name. It should start with 'FOOD'. Course name updated to ERROR."); // cant thnk of what to call
        } else {
            this.courseName = courseName;
        }

        this.employeeNumber = employeeNumber;
        this.name = name;
        this.yearsWorking = yearsWorking;
    }

    // Constructor again so it doesnt run all methods/parameters as one above
    public Employee() {}

    // Getters and setters
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsWorking() {
        return yearsWorking;
    }

    public void setYearsWorking(int yearsWorking) {
        this.yearsWorking = yearsWorking;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (!courseName.startsWith("FOOD")) {
            this.courseName = "ERROR";
            System.out.println("Invalid course name. It should start with 'FOOD'. Course name updated to ERROR.");
        } else {
            this.courseName = courseName;
        }
    }

    //  display employee details
    public void displayEmployee() {
        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Name: " + name);
        System.out.println("Years Working: " + yearsWorking);
        System.out.println("Course Name: " + courseName);
    }

    // compare employees by employee number
    public boolean equals(Employee other) {
        return this.employeeNumber == other.getEmployeeNumber();
    }
}
