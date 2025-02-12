//By Devon L. Brown 
//HW 2 for Spring 2025 Object Oriented Programming
//References Below:
//https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
//https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
//https://stackoverflow.com/questions/14226830/java-csv-file-easy-read-write
//https://www.baeldung.com/java-csv
//https://www.youtube.com/watch?v=Ag-JPiwp1Oo
//https://medium.com/%40it.kissi.abdelaziz/building-a-robust-etl-pipeline-with-java-apache-spark-spring-boot-and-mongodb-285917025833
//https://www.javacodegeeks.com/2024/09/data-pipeline-vs-etl-pipeline-key-differences-and-use-cases.html


package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

//ETL pipe
public class ETLPipeline {
    public static void main(String[] args) {
        String inputFile = new File("data/products.csv").getAbsolutePath();
        String outputFile = new File("data/transformed_products.csv").getAbsolutePath();

        try {
            //chek to see if it exists
            File input = new File(inputFile);
            if (!input.exists()) {
            throw new FileNotFoundException("Input file not found: " + inputFile);
            }

            //read input
            List<String[]> data = readCSV(inputFile);

            //transform
            List<String[]> transformedData = transformData(data);

            //load transformed file
            writeCSV(outputFile, transformedData);

        System.out.println("ETL Process Completed Successfully!");
        } catch (FileNotFoundException e) 
        {
            System.err.println("File error: " + e.getMessage());
        } catch (IOException e) 
        {
        System.err.println("Error during ETL process: " + e.getMessage());
        }
    }

    //method on how to read the file
  private static List<String[]> readCSV(String filePath) throws IOException {
    List<String[]> records = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        int lineNumber = 0; //checking the line number
        br.readLine(); //don't readh header
        while ((line = br.readLine()) != null) {
            lineNumber++;
            String[] columns = line.split(",");
            if (columns.length < 4) { //check the columns
                System.err.println("Skipping invalid row at line " + lineNumber + ": " + line);
                continue;
            }
            records.add(columns);
        }
    }
    return records;
}


    //method - transofmr
    private static List<String[]> transformData(List<String[]> data) {
        List<String[]> transformed = new ArrayList<>();
        //put the header in
        transformed.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"});

        for (String[] record : data) {
    if (record.length < 4) { //ehcck the columns
        System.err.println("Skipping invalid record: " + Arrays.toString(record));
        continue;
    }
    String productId = record[0];
    String name = record[1];
    double price;
    try {
        price = Double.parseDouble(record[2]);
    } catch (NumberFormatException e) {
        System.err.println("Invalid price format for record: " + Arrays.toString(record));
        continue;
    }
    String category = record[3];
    String priceRange;

    //put in the transofms
    if (category.equalsIgnoreCase("Electronics")) {
        price *= 0.9; // Apply discount
        category = price > 500 ? "Premium Electronics" : "Electronics";
    }

    price = Math.round(price * 100.0) / 100.0; //roudning
    priceRange = getPriceRange(price);
    name = name.toUpperCase();//uppercases the whole name. Update for the assignment

    transformed.add(new String[]{
            productId,
            name,
            String.format("%.2f", price),
            category,
            priceRange
    });
}
        return transformed;
    }

    //chang prices
    private static String getPriceRange(double price) {
        if (price <= 10) {
            return "Low";
        } else if (price <= 100) {
            return "Medium";
        } else if (price <= 500) {
            return "High";
        } else {
            return "Premium";
        }
    }

    //removed after update to assignment
    private static String capitalizeWords(String input) {
        String[] words = input.split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                           .append(word.substring(1).toLowerCase())
                           .append(" ");
            }
        }
        return capitalized.toString().trim();
    }

    //put everything into the new file
    private static void writeCSV(String filePath, List<String[]> data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] record : data) {
                bw.write(String.join(",", record));
                bw.newLine();
            }
        }
    }

 

}

  
