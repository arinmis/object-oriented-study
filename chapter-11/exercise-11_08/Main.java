import java.util.*;

/**
 *
 *  Introduction to Java Programming - Programming Exercise 11.8
 *
 *
 *  @author Mustafa Arinmis
 *  @since 22.08.2020
 *
 * */


public class Main {
    public static void main(String[] args) {
        Account account = new Account("George", 1122, 1000);
        account.deposit(30, "dep 1");
        account.deposit(40, "dep 2");
        account.deposit(50, "dep 3");

        account.withdraw(5, "withdraw 1");
        account.withdraw(4, "withdraw 2");
        account.withdraw(2, "withdraw 3");

        System.out.println(account);
    }
}

class Account {
    private String name;
    private int id = 0;
    private double balance = 0.0;
    private static double annualInterestRate = 1.5;
    private java.util.Date dateCreated;
    private ArrayList<Transection>  transections;

    public Account() {
        dateCreated = new java.util.Date();
    }

    public Account(String name, int id, double balace) {
        this();
        transections = new ArrayList<>();
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public String getDateCreated() {
        return this.dateCreated.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12 ;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount, String desc) {
        this.balance -= amount;
        transections.add(new Transection('W', amount, this.balance, desc));
    }

    public void deposit(double amount, String desc) {
        this.balance += amount;
        transections.add(new Transection('D', amount, this.balance, desc));
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nInterest rate: " + this.getAnnualInterestRate() +
                "\nBalance: " + this.balance + "\n-------------All Transections-------------\n " + this.transections;
    }
}

class Transection{
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String descripiton;

    public Transection(char type, double amount, double balance, String descripiton){
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.descripiton = descripiton;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescripiton() {
        return descripiton;
    }

    public void setDescripiton(String descripiton) {
        this.descripiton = descripiton;
    }

    @Override
    public String toString() {
        return "Transection date: " + this.date + "\nType: " + this.type +
                "\nAmount: " + amount + "\nBalance" + this.balance +
                "\nDescription: " + this.descripiton;
    }
}