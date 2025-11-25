package ie.atu;

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
    //It gives them the default values?
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

    //Calls instance method addDeposit on account
    @Test
    void addDeposit(){
        assertEquals( 20, account.addDeposit(20));
    }

    @Test
    void withdraw(){
        assertEquals(20, account.withdraw(20));
    }
}
