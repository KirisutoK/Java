// Creation Date: June 05, 2026. at 9:23 PM
// Last Modified: June 05, 2026. at  9:59 PM

public class Main {
    public static void main(String[] args) {
        // ============= CREATING OBJECT ============= \\
        NotificationService NotifService01 = new NotificationService("Apple");

        // ============= METHODS ============= \\
        NotifService01.sendEmail("Something");
        System.out.println(); // Space for Readability
        NotifService01.sendSMS("Something");
        System.out.println(); // Space for Readability
        NotifService01.sendCustom(new Notifiable() {
            public String getType() {
                return "PUSH NOTIFICATION";
            }

            public void sendNotification(String message) {
                System.out.println(message);
            }
        }, "Your order has arrived!");
    }
}
