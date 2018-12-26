
package com.vendingmachine.view;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserIOTest {

    UserIO uio = new UserIO();
    
    public UserIOTest() {
    }

    @Test
    public void testReadBigDecimal100() {
        //BigDecimal bd = uio.readMoney("Enter your money.");
        int num = uio.readInt("enter a number");
        
        assertTrue(num == 1);
    }

}
