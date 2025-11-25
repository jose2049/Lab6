package atu.ie;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//Starts class definition
public class BankAccount {
    private String accNo;
    private String name;
    private double balance;

    //Constructor for bank account. It initializes the methods from the class BankAccount with a default values
    public  BankAccount(String accNo, String name, double balance) {

        //If balance is = 0 throw an error message
        if( balance <= 0 ){
            throw new IllegalArgumentException("Balance must be greater than 0");
        }
        //I store away the constructor arguments into the object's fields
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;

    }

    //No-argument constructor. It does nothing, so fields are left to Java defaults
    public BankAccount() {

    }
    //Simple getters to read the fields
    public String getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    //addDeposilt adds amount to balance and returns the updated balance
    public double addDeposit(double amount){

        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        balance += amount;
        return balance;
    }

    //Withdraw first checks if requested amount exceeds the current balance. If so, throws and exception
    //Then subtracts the amount and returns the new balance
    public double withdraw(double amount){

        if( amount > balance ){
            throw new IllegalArgumentException("You can't withdraw more than balance, please try again ");
        }
        balance = balance - amount;
        return balance;
    }
}