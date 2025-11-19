package ie.atu;

import atu.ie.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    public void setUp(){
        account = new BankAccount();
    }

    @Test
    void constructorInitialisation(){

        account = new BankAccount( "ACC12345", "Jose", 100);
        assertEquals("ACC12345", account.getAccNo());
        assertEquals("Jose", account.getName());
        assertEquals(100, account.getBalance());
    }

    @Test
    void constructorNegativeInitialisation(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new BankAccount("ACC12345", "Jose", -100));
        assertEquals("Balance must be greater than 0", exception.getMessage());
    }
}
