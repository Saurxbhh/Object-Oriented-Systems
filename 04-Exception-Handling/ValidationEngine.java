package ExceptionHandling;

// Custom Checked Exception checking domain-specific boundary constraints
class InsufficientPrivilegeException extends Exception {
    public InsufficientPrivilegeException(String errorLog) {
        super(errorLog);
    }
}

public class ValidationEngine {
    public static void verifySystemAccess(int candidateAge, String clearanceToken) throws InsufficientPrivilegeException {
        if (candidateAge < 18) {
            throw new IllegalArgumentException("System Guard Error: Core biometric registration age cannot sit below 18.");
        }
        if (!"UU-MCA-2026".equals(clearanceToken)) {
            throw new InsufficientPrivilegeException("Security Access Denied: Provided token does not match active system keys.");
        }
        System.out.println("System Access Granted. Core data modules initialized.");
    }

    public static void main(String[] args) {
        try {
            // Executing validations through safe catch corridors
            verifySystemAccess(21, "INVALID_TOKEN");
        } catch (IllegalArgumentException | InsufficientPrivilegeException errorNode) {
            System.err.println("Audit Exception Blocked Intercept: " + errorNode.getMessage());
        } finally {
            System.out.println("Resource Safety Guard: Connection channels closed down safely.");
        }
    }
}
