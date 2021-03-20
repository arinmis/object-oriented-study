import java.util.Date;
import java.util.Scanner;

/*
10.7 (Game: ATM machine) Use the Account class created in Programming Exer-
cise 9.7 to simulate an ATM machine. Create ten accounts in an array with id
0 , 1 , . . . , 9 , and initial balance $100. The system prompts the user to enter an
id. If the id is entered incorrectly, ask the user to enter a correct id. Once an id
is accepted, the main menu is displayed as shown in the sample run. You can
enter a choice 1 for viewing the current balance, 2 for withdrawing money, 3 for
depositing money, and 4 for exiting the main menu. Once you exit, the system
will prompt for an id again. Thus, once the system starts, it will not stop.
*/

public class Workout {

    public static void main(String[] args) {
        Account[] accounts = new Account[10];

        for(int i=0; i<10; i++) {
            accounts[i] = new Account(i, 100);
        }

        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Enter id number: ");

            int id;

            while (true) {
                id = input.nextInt();
                if (id < 0 || id > 9)
                    System.out.println("ERROR: Enter valid id number: ");
                else
                    break;
            }
            displayMenu(id, accounts);

        }

    }

    public static void displayMenu(int id,Account[] accounts) {
        Scanner input = new Scanner(System.in);
        String menu = "Main Menu\n" + "1: check balance\n" + "2: withdraw\n"
                    + "3: deposit\n" + "4: exit\n" + "Enter a choose: " ;

        while(true) {
            System.out.println(menu);
            int order = input.nextInt();

            if(order == 1) {
                System.out.println("The balance is: " + accounts[id].getBalance());
            }
            else if(order == 2) {
                System.out.println("Enter amount of withdraw: ");
                int amount = input.nextInt();
                accounts[id].withdraw(amount);
            }
            else if(order == 3) {
                System.out.println("Enter amount of deposit: ");
                int amount = input.nextInt();
                accounts[id].deposit(amount);
            }
            else if(order == 4)
                break;
        }

    }

}

/*Introduction to java Programming, Problem 9.7
 * @author Mustafa Arinmis
 * @since 05.14.2020
 * */

class Account {
    private int id = 0;
    private double balance  = 0;
    private double annualIntrestRate = 0;
    private Date dateCreated;


    public Account() {
        dateCreated = new Date();
    }


    public Account(int id, double balance) {
        dateCreated = new Date();
        this.id = id;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualIntrestRate() {
        return annualIntrestRate;
    }

    public void setAnnualIntrestRate(double annualIntrestRate) {
        this.annualIntrestRate = annualIntrestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyIntrestRate() {
        return this.annualIntrestRate/(12*100);
    }

    public double getMonthlyIntrest() {
        return  this.getMonthlyIntrestRate() * balance;
    }

    public void withdraw( double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}

