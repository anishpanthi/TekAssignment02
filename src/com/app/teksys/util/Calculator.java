package com.app.teksys.util;

import com.app.teksys.service.Order;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

public class Calculator {

    /**
     * receives a collection of orders. For each order, iterates on the order
     * lines and calculate the total price which is the item's price * quantity
     * * taxes.
     *
     * For each order, print the total Sales Tax paid and Total price without
     * taxes for this order
     * @param o Map&lt;String, Order&gt;
     */
    public void calculate(Map<String, Order> o) {

        double grandtotal = 0;
        Map<String, Order> treeMap = new TreeMap<>(o);
        DecimalFormat df = new DecimalFormat("###.##");
        // Iterate through the orders
        for (String key : treeMap.keySet()) {
            System.out.println("*******" + key + "*******");
            Order r = o.get(key);

            double totalTax = 0;
            double total = 0;

            // Iterate through the items in the order
            for (int i = 0; i < r.size(); i++) {

                // Calculate the taxes
                double tax = 0;
                tax = (r.get(i).getItem().getDescription().toLowerCase().contains("imported")) ? r.get(i).getItem().getPrice() * 0.15 : r.get(i).getItem().getPrice() * 0.10;
                tax = Double.parseDouble(df.format(tax));

                // Calculate the total price
                double totalprice = r.get(i).getItem().getPrice() + tax;

                // Print out the item's total price
                System.out.println("1 " + r.get(i).getItem().getDescription() + ": " + df.format(totalprice));

                // Keep a running total
                totalTax += tax;
                total += r.get(i).getItem().getPrice();
            }

            // Print out the total taxes
            System.out.println("Sales Tax: " + df.format(totalTax));

            // Print out the total amount
            System.out.println("Total: " + df.format(total));

            grandtotal += total;
        }

        System.out.println("Sum of orders: " + df.format(grandtotal));
    }
}
