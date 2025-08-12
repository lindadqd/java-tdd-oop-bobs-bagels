package com.booleanuk.extension;

public class Receipt {
    Order order;
    public Receipt(Order order) {
        this.order = order;
    }


    public String generateReceipt() {
        return "";
    }

    public void printReceipt() {
    }
}
