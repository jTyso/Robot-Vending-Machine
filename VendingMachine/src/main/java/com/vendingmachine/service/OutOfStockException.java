
package com.vendingmachine.service;


public class OutOfStockException extends Exception{
    
    public OutOfStockException(String message){
        super(message);
    }
    
    public OutOfStockException(String message, Throwable ex){
        super(message, ex);
    }
}
