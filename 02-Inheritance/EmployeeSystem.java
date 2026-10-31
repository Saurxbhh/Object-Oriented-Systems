package Inheritance;

/**
 * Paradigm: Inheritance & Polymorphism
 * System: Enterprise Employee Compensation Tracking Architecture
 */
class Employee {
    protected String employeeId;
    protected String name;
    protected double baseSalary;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Method to be overridden polymorphically by subclasses
    public double calculateMonthlyPay() {
        return this.baseSalary;
    }

    public void displaySystemMetrics() {
        System.out.println("ID: " + employeeId + " | Name: " + name + " | Computed Base Payout: " + calculateMonthlyPay());
    }
}

// Child class inheriting attributes and behaviors from Employee
class PremiumManager extends Employee {
    private double performanceBonusPool;

    public PremiumManager(String employeeId, String name, double baseSalary, double performanceBonusPool) {
        super(employeeId, name, baseSalary); // Delegating construction path up to original parent class
        this.performanceBonusPool = performanceBonusPool;
    }

    // Overriding the base calculateMonthlyPay method polymorphically
    @Override
    public double calculateMonthlyPay() {
        return super.baseSalary + this.performanceBonusPool;
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Employee baseStaff = new Employee("EMP101", "Amit Kumar", 45000);
        Employee leadManager = new PremiumManager("MGR201", "Siddharth Gupta", 85000, 15000);

        System.out.println("--- Executing Structural Compensation Pass ---");
        baseStaff.displaySystemMetrics();
        leadManager.displaySystemMetrics(); // Dynamic Method Dispatch executes child version at runtime
    }
}
