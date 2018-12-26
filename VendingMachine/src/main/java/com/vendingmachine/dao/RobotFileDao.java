package com.vendingmachine.dao;

import com.vendingmachine.dto.Robot;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RobotFileDao implements RobotDao {

    Map<String, Robot> robots = new HashMap<>();
    private static final String ROBOT_LIST = "robots.txt";
    private static final String DELIMITER = "/";

    @Override
    public Map<String, Robot> getAllRobots() throws VendingMachineStorageException {
        loadBots();
        Map<String, Robot> bots = robots;
        return bots;
    }

    @Override
    public Robot getRobot(String id) throws VendingMachineStorageException {
        loadBots();

        if (robots.containsKey(id.toUpperCase())) {
            Robot bot = robots.get(id.toUpperCase());
            return bot;
        } else {
            throw new VendingMachineStorageException("Robot does not exist.");
        }
    }

    private void loadBots() throws VendingMachineStorageException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROBOT_LIST)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineStorageException("File not found.");
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            if (currentTokens.length == 5) {
                Robot robot = new Robot(currentTokens[0], currentTokens[1], Integer.parseInt(currentTokens[3]), new BigDecimal(currentTokens[2]), currentTokens[4]);
                robots.put(robot.getId(), robot);
            }
        }
        scanner.close();
    }

    private void writeBots() throws VendingMachineStorageException {
        try (PrintWriter pw = new PrintWriter(ROBOT_LIST)) {
            for (Robot r : robots.values()) {
                pw.print(r.getId());
                pw.print(DELIMITER);
                pw.print(r.getName());
                pw.print(DELIMITER);
                pw.print(r.getPrice());
                pw.print(DELIMITER);
                pw.print(r.getQuantity());
                pw.print(DELIMITER);
                pw.print(r.getInfo());
                pw.println();
            }
        } catch (FileNotFoundException e) {
            throw new VendingMachineStorageException("File not found.");
        }
    }

    @Override
    public Robot updateRobot(Robot bot, int quantity) throws VendingMachineStorageException {
        bot.setQuantity(quantity);
        writeBots();
        return bot;
    }
}
