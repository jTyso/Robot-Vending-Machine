package com.vendingmachine.controller;

import com.vendingmachine.dao.VendingMachineStorageException;
import com.vendingmachine.dto.Change;
import com.vendingmachine.dto.Robot;
import com.vendingmachine.service.InsufficientFundsException;
import com.vendingmachine.service.OutOfStockException;
import com.vendingmachine.service.VendingMachineService;
import com.vendingmachine.view.VendingMachineView;
import java.util.Map;

public class VMController {

    VendingMachineView view;
    VendingMachineService service;

    public VMController(VendingMachineService service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;

        while (keepGoing) {
            menuSelection = getMenuSelection();
            try {
                switch (menuSelection) {
                    case 1:
                        listBots();
                        break;
                    case 2:
                        addMoney();
                        break;
                    case 3:
                        buyBot();
                        break;
                    case 4:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            } catch (VendingMachineStorageException | OutOfStockException | InsufficientFundsException e) {
                errorMessage(e.getMessage());
            }
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection(service.getMoney());
    }

    private void listBots() throws VendingMachineStorageException {
        view.displayRobotsBanner();
        Map<String, Robot> bots = service.getAllRobots();
        view.printAllBots(bots);
    }

    private void addMoney() {
        view.displayAddMoneyBanner();
        service.addMoney(view.printAndGetMoney());
    }

    private void buyBot() throws VendingMachineStorageException, OutOfStockException, InsufficientFundsException {
        view.displayBuyBotBanner();
        Map<String, Robot> bots = service.getAllRobots();
        view.printAllBots(bots);
        Robot bot = service.buyRobot(view.getBotId(service.getMoney()));
        //Dispensing change
        Map<String, String> change = Change.dispenseChange(service.getMoney());
        view.printChange(change);
        service.clearMoney();
        view.printBuyBotSuccessBanner(bot);
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void errorMessage(String msg) {
        view.displayErrorMessage(msg);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
}
