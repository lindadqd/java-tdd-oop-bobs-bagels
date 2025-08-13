package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Receipt {
    private Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public void printReceipt() {
        System.out.println(makeReceipt());
    }

    public String makeReceipt() {
        StringBuilder receipt = new StringBuilder();

        receipt.append("    ~~~ Bob's Bagels ~~~\n\n");
        receipt.append("    ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");
        receipt.append("----------------------------\n\n");

        Map<String, Integer> bagelCounts = new HashMap<>();
        Map<String, Float> bagelTotals = new HashMap<>();

        for (Bagel bagel : order.getBagels()) {
            String variant = bagel.getVariant();
            bagelCounts.put(variant, bagelCounts.getOrDefault(variant, 0) + 1);
            bagelTotals.put(variant, bagelTotals.getOrDefault(variant, 0F) + bagel.getPrice());
        }

        for (String variant : bagelCounts.keySet()) {
            int count = bagelCounts.get(variant);
            float totalPrice = bagelTotals.get(variant);
            String name = variant + " Bagel";
            receipt.append(String.format("%-15s %8d  £%.2f\n", name, count, totalPrice));
        }

        int coffeeCount = order.getCoffees().size();
        if (coffeeCount > 0) {
            float coffeeTotal = 0;
            for (Coffee coffee : order.getCoffees()) {
                coffeeTotal += coffee.getPrice();
            }
            receipt.append(String.format("%-15s %8d  £%.2f\n", "Coffee", coffeeCount, coffeeTotal));
        }

        receipt.append("\n----------------------------\n");
        receipt.append(String.format("Total%18s£%.2f\n", "", order.getTotalCost()));
        receipt.append("\n        Thank you\n");
        receipt.append("      for your order!\n");

        return receipt.toString();
    }
}
