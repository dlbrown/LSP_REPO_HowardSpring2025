package org.howard.edu.lsp.midterm.question4;

import java.util.*;

public class WordProcessor {
    private String sentence;

    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }
/**
 * Finds longest words.
 * Reference: https://stackoverflow.com/questions/69998874/null-and-isempty-check-for-arraylists
 */
    public List<String> findLongestWords() {
        if (sentence == null || sentence.trim().isEmpty()) {
            return new ArrayList<>();
        }
/**
 * Looks at word length and finds the longest word.
 * Reference: https://stackoverflow.com/questions/60219613/how-to-print-out-longest-word-in-string-without-using-arrays-and-only-loops-in-j
 */
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
