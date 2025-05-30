package com.delicious.utilities;

import com.delicious.model.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Utility class responsible for logging order details to a receipt file.

public class ReceiptLogger {

    private static final String RECEIPTS_FOLDER = "receipts";
    private static final DateTimeFormatter FILE_NAME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    /**
     * Saves the details of a completed order to a receipt file.
     * The file is named by the current date and time and saved in the 'receipts' folder.
     *
     * @param order The Order object to be logged.
     */
    public static void saveReceipt(Order order) {
        // Create the receipts folder if it doesn't exist
        File folder = new File(RECEIPTS_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs(); // Creates the directory and any necessary but nonexistent parent directories
        }

        // Generate file name based on current date and time
        String fileName = LocalDateTime.now().format(FILE_NAME_FORMATTER) + ".txt";
        File receiptFile = new File(folder, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFile))) {
            writer.write("DELI-cious Order Receipt\n");
            writer.write("-------------------------\n");
            writer.write("Order Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("-------------------------\n\n");

            String value = order.getDetails().replaceAll("\u001B\\[[;\\d]*m", "");

            writer.write(value); // Get the detailed string representation of the order

            writer.write("\n-------------------------\n");
            writer.write(String.format("Total Order Cost: $%.2f\n", order.calculateTotal()));
            writer.write("-------------------------\n");
            System.out.println("Receipt saved to: " + receiptFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }
}