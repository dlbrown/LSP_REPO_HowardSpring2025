

package org.howard.edu.lsp.assignment6;

/**
 * Custom exception to be thrown by IntegerSet when invalid operations are attempted,
 * such as getting the largest or smallest element from an empty set.
 */
public class IntegerSetException extends Exception {
    public IntegerSetException(String message) {
        super(message);
    }
}

