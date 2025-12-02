package atu.ie;
import atu.ie.BankAccount;


//Imports the class under test and JUnit 5 test annotations and assertions
import atu.ie.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    BankAccount account;

    //Creating an object of BankAccount called account. Which will be used by multiple tests
    //Runs before each test. Creates a fresh, valid BankAccount with balance 100. This avoids
    //the earlier bug where the no-arg constructor produced balance 0 and inconsistent tests.
    @BeforeEach
    public void setUp(){
        account = new BankAccount();
    }

    //Verifies the constructor stores values correctly
    //It gives them the default values
    @Test
    void constructorInitialisation(){

        account = new BankAccount( "ACC12345", "Jose", 100);
        assertEquals("ACC12345", account.getAccNo());
        assertEquals("Jose", account.getName());
        assertEquals(100, account.getBalance());
    }
     //Verifies invalid balance input, throws the expected exception and checks the exception message
    @Test
    void constructorNegativeInitialisation(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new BankAccount("ACC12345", "Jose", -100));
        assertEquals("Balance must be greater than 0", exception.getMessage());
    }

    //The user adds 20 t0 the balance
    @Test
    void addDeposit(){
        assertEquals( 20, account.addDeposit(20));
    }
    //The user can't add a negative amount
    @Test
    void addDepositNegative(){
        assertThrows(IllegalArgumentException.class, () -> account.addDeposit(-20));
    }
    //The user can't add 0 to the amount
    @Test
    void addDeposit_WhenAmountIsZero(){
        assertThrows(IllegalArgumentException.class, () -> account.addDeposit(0));
    }
    //Just withdrawing a regular positive amount greater than the balance or equal than the balance
    @Test
    void withdraw(){
        account =  new BankAccount("ACC12345", "Jose", 100);
        assertEquals(80, account.withdraw(20));
    }
    //If the user tries to withdraw a negative amount it won't let him do it
    @Test
    void withdrawNegative(){
        account = new BankAccount("ACC12345", "Jose", 100);
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(-20));
        assertEquals("Amount must be greater than 0", e.getMessage());
    }
    //If the user tries to withdraw more than the balance it won't let him do it
    @Test
    void withdraw_WhenAmountIsZero(){
        account = new BankAccount("ACC12345", "Jose", 100);
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(120));
        assertEquals("You can't withdraw more than balance, please try again", e.getMessage());
    }
}
