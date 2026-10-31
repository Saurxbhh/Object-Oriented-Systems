package Abstraction;

/**
 * Paradigm: Abstraction via Interfaces
 * System: Decoupled Multi-Channel Payment Core
 */
interface IPaymentProcessor {
    // Abstract system contract methods that implementing entities must satisfy
    boolean authenticateChannel(String vendorToken);
    void executeLedgerTransaction(double amount);
}

class UPITransactionEngine implements IPaymentProcessor {
    private String upiId;

    public UPITransactionEngine(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean authenticateChannel(String token) {
        System.out.println("UPI Auth Core: Verification successful for identifier handle: " + upiId);
        return true;
    }

    @Override
    public void executeLedgerTransaction(double amount) {
        System.out.println("UPI Settlement Engine: Transferred " + amount + " INR immediately via NPCI Switch.");
    }
}

class CreditCardTransactionEngine implements IPaymentProcessor {
    private String cardNumber;

    public CreditCardTransactionEngine(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean authenticateChannel(String token) {
        System.out.println("Secure Credit Card Core: Handshaking with Card Network Infrastructure.");
        return true;
    }

    @Override
    public void executeLedgerTransaction(double amount) {
        double processingFee = amount * 0.02; // Adding 2% processing overhead
        System.out.println("Credit Card Merchant Core: Processed gross amount: " + (amount + processingFee) + " INR (Includes Interchange Fee).");
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        // Utilizing interface polymorphism to cycle engines seamlessly
        IPaymentProcessor paymentChannel;

        System.out.println("--- Processing Route Alpha ---");
        paymentChannel = new UPITransactionEngine("saurabh@ybl");
        if(paymentChannel.authenticateChannel("SYS_TOKEN_88")) {
            paymentChannel.executeLedgerTransaction(1250.00);
        }

        System.out.println("\n--- Processing Route Beta ---");
        paymentChannel = new CreditCardTransactionEngine("4532-XXXX-XXXX-1102");
        if(paymentChannel.authenticateChannel("SYS_TOKEN_99")) {
            paymentChannel.executeLedgerTransaction(5000.00);
        }
    }
}
