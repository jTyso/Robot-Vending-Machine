
package com.vendingmachine.dao;

public class VendingMachineStorageException extends Exception{
    
    public VendingMachineStorageException(String message){
        super(message);
    }
    
    public VendingMachineStorageException(String message, Throwable cause){
        super(message, cause);
    }
    
}
