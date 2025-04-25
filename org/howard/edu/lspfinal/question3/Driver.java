package org.howard.edu.lspfinal.question3;

/**
 * generates the report using the patternn
 */
public class Driver {
    public static void main(String[] args) {
        Report sales = new SalesReport();
        Report inventory = new InventoryReport();

        sales.generateReport();
        inventory.generateReport();
    }
}