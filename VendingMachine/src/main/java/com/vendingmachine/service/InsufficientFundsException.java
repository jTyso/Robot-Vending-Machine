
package com.vendingmachine.service;


public class InsufficientFundsException extends Exception {
    
    public InsufficientFundsException(String message){
        super(message);
    }
    
    public InsufficientFundsException(String message, Throwable ex){
        super(message, ex);
    }
}
