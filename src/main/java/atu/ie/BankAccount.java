package atu.ie;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BankAccount {
    private String accNo;
    private String name;
    private double balance;

    public  BankAccount(String accNo, String name, double balance) {

        if( balance <= 0 ){
            throw new IllegalArgumentException("Balance must be greater than 0");
        }
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;

    }

    public BankAccount() {

    }

    public String getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double addDeposit(double amount){
        balance += amount;
        return balance;
    }

    public double withdraw(double amount){

        if( amount > balance ){
            throw new IllegalArgumentException("You can't withdraw more than balance, please try again ");
        }
        balance = balance - amount;
        return balance;
    }
}