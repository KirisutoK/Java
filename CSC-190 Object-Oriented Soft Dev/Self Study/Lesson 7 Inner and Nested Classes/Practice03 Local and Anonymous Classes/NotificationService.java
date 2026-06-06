// Creation Date: June 05, 2026. at 9:26 PM
// Last Modified: June 05, 2026. at 10:00 PM

public class NotificationService {
    //=======VARIABLES=======//
    private String ServiceName;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public NotificationService(String ServiceName) {
        this.ServiceName = ServiceName;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void sendEmail(String message) {
        //? CLASS (METHODS REQUIREMENTS)
        class EmailNotification implements Notifiable{
            @Override public String getType() {
                return "Email";
            }

            @Override public void sendNotification(String message) {
                System.out.println("EMAIL: "+message);
            }
        }

        //? THE OUTPUT
        EmailNotification TempEmailNotification = new EmailNotification();
        TempEmailNotification.sendNotification(message);
        System.out.println("TYPE: "+TempEmailNotification.getType());
    }

    public void sendSMS(String message) {
        //? CLASS (METHODS REQUIREMENTS)
        class SMSNotification implements Notifiable {
            @Override public String getType() {
                return "SMS";
            }

            @Override public void sendNotification(String message) {
                System.out.println("SMS: "+message);
            }
        }

        //? THE OUTPUT
        SMSNotification TempSMSNotification = new SMSNotification();
        TempSMSNotification.sendNotification(message);
        System.out.println("TYPE: "+TempSMSNotification.getType());
    }

    public void sendCustom(Notifiable notifiable, String message) {
        System.out.print(notifiable.getType()+": ");
        notifiable.sendNotification(message);
        System.out.println("TYPE: "+notifiable.getType());
    }


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    


    // ================================================== OTHER CLASSES ================================================== \\
}
