package org.howard.edu.lsp.midterm.question4;

import java.util.*;

/**
 * A class that processes a sentence and returns all longest words.
 */
public class WordProcessor {
    private String sentence;

    /**
     * Constructs a WordProcessor with a given sentence.
     * @param sentence The input sentence to be processed.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all longest words in the sentence.
     * @return A list of longest words in the sentence.
     */
    public List<String> findLongestWords() {
        if (sentence == null || sentence.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        String[] words = sentence.split("\\s+");
        List<String> longestWords = new ArrayList<>();
        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWords.clear();
                longestWords.add(word);
            } else if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }
        return longestWords;
    }
}