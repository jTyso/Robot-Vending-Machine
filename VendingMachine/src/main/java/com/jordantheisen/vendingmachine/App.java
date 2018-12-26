package com.jordantheisen.vendingmachine;

import com.vendingmachine.controller.VMController;
import com.vendingmachine.dao.RobotDao;
import com.vendingmachine.dao.RobotFileDao;
import com.vendingmachine.service.VendingMachineService;
import com.vendingmachine.view.UserIO;
import com.vendingmachine.view.VendingMachineView;

public class App {

    public static void main(String[] args) {

        UserIO myIo = new UserIO();
        VendingMachineView myView = new VendingMachineView(myIo);
        RobotDao myDao = new RobotFileDao();
        VendingMachineService myService = new VendingMachineService(myDao);
        VMController myController = new VMController(myService, myView);

        myController.run();
    }
}
