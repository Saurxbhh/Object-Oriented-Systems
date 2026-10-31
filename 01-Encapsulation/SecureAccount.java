package Encapsulation;

/**
 * Paradigm: Encapsulation
 * System: Secured Enterprise Bank Account Tracker
 * Key Features: Data Hiding, Mutator Validation Rules, Internal Audit Logging
 */
public class SecureAccount {
    // Private state variables hidden from external direct modification
    private final String accountId;
    private String accountHolderName;
    private double currentBalance;

    public SecureAccount(String accountId, String holderName, double initialDeposit) {
        this.accountId = accountId;
        this.accountHolderName = holderName;
        if (initialDeposit >= 500.0) { // Enforcing minimum account baseline rules
            this.currentBalance = initialDeposit;
        } else {
            throw new IllegalArgumentException("Failure: Initial deposit must meet the 500.0 INR baseline configuration.");
        }
    }

    // Read-Only Accessor (No Setter provided for safety)
    public String getAccountId() {
        return this.accountId;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    // Controlled Mutator with validation logic
    public void setAccountHolderName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            this.accountHolderName = newName;
        }
    }

    public double getCurrentBalance() {
        return this.currentBalance;
    }

    // Secure transactional mutation gateway method
    public void processDeposit(double amount) {
        if (amount > 0) {
            this.currentBalance += amount;
            System.out.println("Audit Log [Deposit Successful]: Added " + amount + " INR. Bal: " + this.currentBalance);
        } else {
            System.out.println("Audit Log [Transaction Blocked]: Invalid deposit ledger volume.");
        }
    }

    public void processWithdrawal(double amount) {
        if (amount > 0 && (this.currentBalance - amount) >= 500.0) { // Protecting minimum account rules
            this.currentBalance -= amount;
            System.out.println("Audit Log [Withdrawal Successful]: Deducted " + amount + " INR. Bal: " + this.currentBalance);
        } else {
            System.out.println("Audit Log [Transaction Blocked]: Insufficient reserves or minimum violation.");
        }
    }
}
