package com.vendingmachine.dao;

import com.vendingmachine.dto.Robot;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class RobotFileDaoStub implements RobotDao {

    Map<String, Robot> robots = new HashMap<>();
    private Robot bot1, bot2;

    public RobotFileDaoStub() {
        bot1 = new Robot("A1", "Jordo-maximus", 4, new BigDecimal("185.75"), "I will eat all your mac and cheese.");
        bot2 = new Robot("B2", "Chad", 0, new BigDecimal("100"), "Pikachu I choose you!");
        robots.put(bot1.getId(), bot1);
        robots.put(bot2.getId(), bot2);
    }

    @Override
    public Map<String, Robot> getAllRobots() throws VendingMachineStorageException {
        return robots;
    }

    @Override
    public Robot getRobot(String robotId) throws VendingMachineStorageException {
        Robot bot = robots.get(robotId);
        return bot;
    }

    @Override
    public Robot updateRobot(Robot bot, int quantity) throws VendingMachineStorageException {
        bot.setQuantity(quantity);
        return bot;
    }

}
