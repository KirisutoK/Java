// Main.java
public class Main {
    public static void main(String[] args) {
        Payment[] payments = new Payment[4];

        payments[0] = new CreditCard("John Doe", 150.00, "1234-5678-9012-3456");
        payments[1] = new PayPal("Sarah Smith", 75.50, "sarah@email.com");
        payments[2] = new BankTransfer("Mike Johnson", 200.00, "ACC123456");
        payments[3] = new CreditCard("Jane Wilson", 89.99, "9876-5432-1098-7654");

        System.out.println("=== All Payments ===");
        for (Payment p : payments) {
            p.displayInfo();
            System.out.println();
        }

        System.out.println("=== Processing Payments ===");
        for (Payment p : payments) {
            p.processPayment();
        }

        System.out.println("\n=== Refundable Payments ===");
        for (Payment p : payments) {
            if (p instanceof Refundable) {
                ((Refundable) p).refund();
            }
        }

        System.out.println("\n=== Verifiable Payments ===");
        for (Payment p : payments) {
            if (p instanceof Verifiable) {
                boolean verified = ((Verifiable) p).verify();
                System.out.println(p.getPayerName() + ": " + (verified ? "Verified" : "Failed"));
            }
        }

        System.out.println("\n=== Total Amount ===");
        double total = 0;
        for (Payment p : payments) {
            total += p.getAmount();
        }
        System.out.println("$" + total);
    }
}