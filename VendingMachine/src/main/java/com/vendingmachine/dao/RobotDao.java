
package com.vendingmachine.dao;

import com.vendingmachine.dto.Robot;
import java.util.Map;


public interface RobotDao {
    
    public Map<String, Robot> getAllRobots() throws VendingMachineStorageException;
    
    public Robot getRobot(String robot) throws VendingMachineStorageException;
    
    public Robot updateRobot(Robot bot, int quantity) throws VendingMachineStorageException;
    
}
