package com.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Change {

    public static Map<String, String> dispenseChange(BigDecimal money) {
        Map<String, String> changeMap = new HashMap<>();
        BigDecimal wholeMoney = new BigDecimal(money.toBigInteger().toString());
        BigDecimal changeCents = money.subtract(wholeMoney);

        //Money
        BigDecimal twenty = new BigDecimal("20");
        BigDecimal ten = new BigDecimal("10");
        BigDecimal five = new BigDecimal("5");
        BigDecimal one = new BigDecimal("1");

        //Change
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickle = new BigDecimal("0.05");
        BigDecimal penny = new BigDecimal("0.01");

        if (wholeMoney.divide(twenty).compareTo(BigDecimal.ONE) >= 0) {
            BigDecimal num20 = wholeMoney.divide(twenty, 0, RoundingMode.FLOOR);
            changeMap.put("$20's", num20.toString());
            wholeMoney = wholeMoney.remainder(twenty);
        }

        if (wholeMoney.divide(ten).compareTo(BigDecimal.ONE) >= 0) {
            BigDecimal num10 = wholeMoney.divide(ten, 0, RoundingMode.FLOOR);
            changeMap.put("$10's", num10.toString());
            wholeMoney = wholeMoney.remainder(ten);
        }

        if (wholeMoney.divide(five).compareTo(BigDecimal.ONE) >= 0) {
            BigDecimal num5 = wholeMoney.divide(five, 0, RoundingMode.FLOOR);
            changeMap.put("$5's", num5.toString());
            wholeMoney = wholeMoney.remainder(five);
        }

        if (wholeMoney.divide(one).compareTo(BigDecimal.ONE) >= 0) {
            BigDecimal num1 = wholeMoney.divide(one, 0, RoundingMode.FLOOR);
            changeMap.put("$1's", num1.toString());
        }

        if (changeCents.divide(quarter).compareTo(BigDecimal.ONE) >= 0) {
            BigDecimal numQuarters = changeCents.divide(quarter, 0, RoundingMode.FLOOR);
            changeMap.put("Quarters's(0.25)", numQuarters.toString());
            changeCents = changeCents.remainder(quarter);
        }
        
        if (changeCents.divide(dime).compareTo(BigDecimal.ONE) >= 0) {
            BigDecimal numDimes = changeCents.divide(dime, 0, RoundingMode.FLOOR);
            changeMap.put("Dime's(0.10)", numDimes.toString());
            changeCents = changeCents.remainder(dime);
        }
        
        if (changeCents.divide(nickle).compareTo(BigDecimal.ONE) >= 0) {
            BigDecimal numNickles = changeCents.divide(nickle, 0, RoundingMode.FLOOR);
            changeMap.put("Nickle's(0.05)", numNickles.toString());
            changeCents = changeCents.remainder(nickle);
        }
        
        if (changeCents.divide(penny).compareTo(BigDecimal.ONE) >= 0) {
            BigDecimal numPennies = changeCents.divide(penny, 0, RoundingMode.FLOOR);
            changeMap.put("Pennie's(0.01)", numPennies.toString());
        }

        return changeMap;
    }

}
