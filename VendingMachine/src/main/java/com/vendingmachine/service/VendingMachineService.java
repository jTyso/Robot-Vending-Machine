package com.vendingmachine.service;

import com.vendingmachine.dao.RobotDao;
import com.vendingmachine.dao.VendingMachineStorageException;
import com.vendingmachine.dto.Robot;
import java.math.BigDecimal;
import java.util.Map;

public class VendingMachineService {

    private RobotDao fileDao;
    private BigDecimal money = new BigDecimal("0.00");

    public VendingMachineService(RobotDao fileDao) {
        this.fileDao = fileDao;
    }

    public Map<String, Robot> getAllRobots() throws VendingMachineStorageException {
        return fileDao.getAllRobots();
    }

    public Robot getRobot(String id) throws VendingMachineStorageException {
        return fileDao.getRobot(id);
    }

    /* Talk with corbin about throwing exceptions 
     * with the two if statements 
     * in the try block. 
     */
    public Robot buyRobot(String id) throws OutOfStockException, InsufficientFundsException, VendingMachineStorageException {
        Robot bot = fileDao.getRobot(id);
        if (bot.getQuantity() == 0) {
            throw new OutOfStockException("Robot model is currently out of stock. Sorry for the inconvenience!");
        }
        if (money.compareTo(bot.getPrice()) < 0) {
            throw new InsufficientFundsException("Not enough money, please add more.");
        }
        fileDao.updateRobot(bot, bot.getQuantity() - 1);
        money = money.subtract(bot.getPrice());
        return bot;
    }

    public void addMoney(BigDecimal moneyToBeAdded) {
        money = money.add(moneyToBeAdded);
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void clearMoney() {
        money = money.multiply(BigDecimal.ZERO);
    }
}

/*
try {
            Robot bot = fileDao.getRobot(id);
            
            if (money.compareTo(bot.getPrice()) < 0) {
                
                throw new InsufficientFundsException("Not enough money, please add more.");
                
            }
            if (bot.getQuantity() == 0) {
                throw new OutOfStockException("There is no more of that type of robot in stock. Sorry for the inconvenience.");
            }
            
            fileDao.updateRobot(bot, bot.getQuantity() - 1);
            money = money.subtract(bot.getPrice());

            return bot;

        } catch (InsufficientFundsException | OutOfStockException e) {
            new Exception("Error -_-", e);
        }
        return null;
 */
