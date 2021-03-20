/*Introduction to java Programming, Problem 9.7
* @author Mustafa Arinmis
* @since 05.14.2020
* */

import java.util.Date;

public class Account {
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

class Test {

    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        account.setAnnualIntrestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance: " + account.getBalance()
                + "\nMonthly Intrest: " +  account.getMonthlyIntrest()
                + "\nAccount created day: " + account.getDateCreated());
    }
}
