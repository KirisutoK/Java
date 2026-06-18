// Creation Date: June 14, 2026. at 2:31 AM
// Last Modified: June 18, 2026. at 12:38 AM

import Exceptions.AccountFrozenException;
import Exceptions.InsufficientFundsException;
import Exceptions.InvalidDepositException;

public class Main {
    public static void main(String[] args) {
        //======= CREATING OBJECTS/INSTANCES =======//
        BankAccount BankAccount01 = new BankAccount("Christ Aerjil Dampog", 0);

        //======= METHODS =======//
        try {
            // [DEPOSIT]
            BankAccount01.deposit(10);
            // BankAccount01.deposit(-1);          //... <============ ERROR
            // [WITHDRAW]
            BankAccount01.withdraw(100);
            // BankAccount01.withdraw(100);           //... <============ ERROR
            BankAccount01.freezeAcount();
            // BankAccount01.deposit(10);      //... <============ ERROR
            // BankAccount01.withdraw(999); //... <============ ERROR

            BankAccount01.displayInfo();
        } catch (AccountFrozenException e) {
            // e.getMessage(); //... <========= THIS RETURNS A STRING
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            // e.getMessage(); //... <========= THIS RETURNS A STRING
            System.out.println(e.getMessage());
        } catch (InvalidDepositException e) {
            // e.getMessage(); //... <========= THIS RETURNS A STRING
            System.out.println(e.getMessage());
        }catch (Exception e) {
        }
    }
}
