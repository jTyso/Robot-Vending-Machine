
package com.vendingmachine.dao;

import com.vendingmachine.dto.Robot;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class RobotFileDaoTest {
    
    RobotDao dao = new RobotFileDao();
    
    public RobotFileDaoTest() {
        
    }

    
    @Test
    public void testGetAllRobots() throws Exception {
       dao.getAllRobots();
       assertTrue(dao.getAllRobots().size()== 1);
    }

    
    @Test
    public void testGetRobot() throws Exception {
        Robot bot = dao.getRobot("A1");
        assertTrue(bot.getName().equals("Jordo-tron"));
    }
    
    @Test 
    public void testUpdateRobot() throws Exception{
        Robot bot = dao.getRobot("A1");
        int botQuantity = bot.getQuantity();
        dao.updateRobot(bot, botQuantity-1);
        
        assertTrue(bot.getQuantity()==botQuantity-1);
    }
}
