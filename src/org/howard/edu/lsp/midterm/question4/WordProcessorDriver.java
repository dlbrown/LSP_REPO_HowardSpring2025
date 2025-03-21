/**
 * Driver class to test the WordProcessor class
 */
package org.howard.edu.lsp.midterm.question4;

public class WordProcessorDriver {
    public static void main(String[] args) {
        // Test case 1: Sentence with single longest word
        WordProcessor wp4 = new WordProcessor("This is a test with amazing results, amazing achievements!");
        System.out.println("Test 4 - Longest words: " + wp4.findLongestWords());  
        // Expected Output: ["achievements"]

        // Test case 2: Sentence with multiple occurrences of the same longest word and length
        WordProcessor wp2 = new WordProcessor("Java is a powerful  tool!");
        System.out.println("Test 2 - Longest words: " + wp2.findLongestWords());  
        // Expected Output: ["powerful", "powerful"]

        // Test case 5: Sentence with single character words
        WordProcessor wp5 = new WordProcessor("A B C D E");
        System.out.println("Test 5 - Longest words: " + wp5.findLongestWords());  
        // Expected Output: ["A", "B", "C", "D", "E"]

        // Test case 6: Empty string input
        WordProcessor wp6 = new WordProcessor("");
        System.out.println("Test 6 - Longest words: " + wp6.findLongestWords());  
        // Expected Output: []
    }
}
