package DesignPatterns;

// 1. Defining the Core Interface System Contract
interface NotificationChannel {
    void dispatchAlert(String messagePayload);
}

// 2. Concrete Product Implementation Alpha
class SMSNotification implements NotificationChannel {
    @Override
    public void dispatchAlert(String messagePayload) {
        System.out.println("SMS Core Switch: Telemetry dispatched -> " + messagePayload);
    }
}

// 3. Concrete Product Implementation Beta
class EmailNotification implements NotificationChannel {
    @Override
    public void dispatchAlert(String messagePayload) {
        System.out.println("SMTP Relay Server: Routing transmission -> " + messagePayload);
    }
}

// 4. Creational Factory Core (Decouples client logic from instance initialization)
class NotificationFactory {
    public static NotificationChannel initializeChannel(String channelType) {
        if (channelType == null || channelType.trim().isEmpty()) {
            throw new IllegalArgumentException("Factory Exception: Missing deployment configuration profile.");
        }
        
        switch (channelType.toUpperCase()) {
            case "SMS":
                return new SMSNotification();
            case "EMAIL":
                return new EmailNotification();
            default:
                throw new UnsupportedOperationException("Factory Exception: Unrecognized infrastructure endpoint: " + channelType);
        }
    }
}

// 5. Execution Orchestration Engine
public class FactoryPatternCore {
    public static void main(String[] args) {
        System.out.println("--- Bootstrapping Factory Component Route ---");
        
        // Dynamically instantiate components without mentioning concrete implementation names directly
        NotificationChannel activeChannel = NotificationFactory.initializeChannel("SMS");
        activeChannel.dispatchAlert("System Alert: High thread usage detected.");

        System.out.println("\n--- Switching Factory Component Route ---");
        activeChannel = NotificationFactory.initializeChannel("EMAIL");
        activeChannel.dispatchAlert("Security Audit: Admin credential check successful.");
    }
}
