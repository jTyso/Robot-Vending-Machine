package com.vendingmachine.service;

import com.vendingmachine.dao.RobotDao;
import com.vendingmachine.dao.RobotFileDaoStub;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class VendingMachineServiceTest {

    private VendingMachineService service;

    public VendingMachineServiceTest() {
        RobotDao dao = new RobotFileDaoStub();
        service = new VendingMachineService(dao);
    }

    @Test
    public void testBuyRobotSufficientFunds18575() throws Exception {
        service.addMoney(new BigDecimal("185.75"));
        service.buyRobot("A1");
    }

    @Test
    public void testBuyRobotInsufficientFunds18574() throws Exception {
        service.addMoney(new BigDecimal("185.74"));
        try {
            service.buyRobot("A1");
            fail("Expected InsufficientFundsException was not thrown.");
        } catch (InsufficientFundsException e) {
            return;
        }
    }

    @Test
    public void testBuyRobotInsufficientFunds18576() throws Exception {
        service.addMoney(new BigDecimal("185.76"));
        try {
            service.buyRobot("A1");
        } catch (InsufficientFundsException e) {
            return;
        }
    }

    @Test
    public void testBuyRobotOutOfStockExceptionTrue() throws Exception {
        service.addMoney(new BigDecimal("200"));
        try {
            service.buyRobot("B2");
            fail("Expected OutOfStockException was not thrown.");
        } catch (OutOfStockException e) {
            return;
        }
    }

    @Test
    public void testBuyRobotOutOfStockExceptionFalse() throws Exception {
        service.addMoney(new BigDecimal("200"));
        service.buyRobot("A1");
        assertEquals(3, service.getRobot("A1").getQuantity());
    }
}
