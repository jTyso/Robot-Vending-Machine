package com.vendingmachine.view;

import com.vendingmachine.dto.Robot;
import java.math.BigDecimal;
import java.util.Map;

public class VendingMachineView {

    UserIO io = new UserIO();

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection(BigDecimal money) {
        System.out.println("");
        io.print("**** Bot Vender X4 ****");
        io.print("Money : $" + money.toString());
        io.print("1. See Robot Selection");
        io.print("2. Add Money");
        io.print("3. Buy Robot");
        io.print("4. Exit");

        return io.readInt("Please select from the above choices.", 1, 4);
    }

    public void printAllBots(Map<String, Robot> bots) {
        io.print("======== Robots For Sale ========");
        for (Robot bot : bots.values()) {
            if (bot.getQuantity() > 0) {
                io.print(
                        "ID: " + bot.getId() + " | Name: " + bot.getName() + " | Price: " + bot.getPrice()
                        + " | Quantity: " + bot.getQuantity() + " | Info : " + bot.getInfo()
                );
            }
        }
        io.print("");
    }

    public BigDecimal printAndGetMoney() {
        return io.readMoney("How much money would you like to add?");
    }

    public String getBotId(BigDecimal money) {
        io.print("Money : $" + money.toString());
        return io.readString("Enter the Robot ID that you want to buy.");
    }

    public void printChange(Map<String, String> change) {
        io.print("");
        io.print(".... Dispensing Change ....");
        if (!change.isEmpty()) {

            change.keySet().forEach((typeOfChange) -> {
                io.print("Number of " + typeOfChange + ": " + change.get(typeOfChange));
            });
        } else {
            io.print("Paid exact price for robot. No change to dispense.");
        }
    }

    // ******************************** DISPLAY BANNERS *************************************
    // **************************************************************************************
    public void displayRobotsBanner() {
        io.print("");
        io.print("=== Display All Robots In Inventory ===");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("");
        io.print(errorMsg);
    }

    public void displayAddMoneyBanner() {
        io.print("");
        io.print("=== Add Money ===");
    }

    public void displayExitBanner() {
        io.print("Goodbye!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Uknown Command!!!");
    }

    public void displayBuyBotBanner() {
        io.print("=== Buy A Robot ===");
    }

    public void printBuyBotSuccessBanner(Robot bot) {
        io.print("");
        io.print("=== Successfully purchased (ID): " + bot.getId() + " (Name): " + bot.getName());
    }
}
