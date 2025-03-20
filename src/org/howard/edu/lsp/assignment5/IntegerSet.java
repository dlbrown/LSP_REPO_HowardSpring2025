//By Devon L. Brown 
//HW 5 for Spring 2025 Object Oriented Programming
//References Below:
// https://stackoverflow.com/questions/4763974/directly-setting-values-for-an-arraylist-in-java
// https://www.geeksforgeeks.org/how-to-convert-arraylist-to-hashset-in-java/
// https://www.geeksforgeeks.org/set-clear-method-in-java-with-examples/
// https://www.geeksforgeeks.org/set-size-method-in-java-with-example/
// https://stackoverflow.com/questions/9506303/public-boolean-equalsobject-other
// https://www.geeksforgeeks.org/set-contains-method-in-java-with-examples/
// https://www.geeksforgeeks.org/collections-max-method-in-java-with-examples/
// https://www.geeksforgeeks.org/collections-min-method-in-java-with-examples/
// https://www.geeksforgeeks.org/hashset-add-method-in-java/
// https://stackoverflow.com/questions/4534146/properly-removing-an-integer-from-a-listinteger
// https://stackoverflow.com/questions/23314789/how-to-write-a-intersection-and-union-methods-for-sets-in-java
// https://stackoverflow.com/questions/14782981/get-intersection-of-several-lists-using-retainall-in-java
// https://stackoverflow.com/questions/18644579/getting-the-difference-between-two-sets
// https://stackoverflow.com/questions/51145107/if-i-have-a-listsetinteger-what-is-a-fast-way-to-remove-any-sets-which-are-s
// https://www.geeksforgeeks.org/set-isempty-method-in-java-with-examples/
// https://stackoverflow.com/questions/45985723/returning-elements-of-a-set-in-java-using-tostring-method-on-separate-lines




package org.howard.edu.lsp.assignment5;

import java.util.*;

/**
 * IntegerSet class represents a mathematical set that stores unique integers.
 */
public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();
    
    /**
     * Constructor that initializes an empty set.
     * Reference: https://stackoverflow.com/questions/4763974/directly-setting-values-for-an-arraylist-in-java
     */
    public IntegerSet() {
    }
    
    
    /**
     * Initialized list.
     * @param set List of integers.
     * Reference: https://www.geeksforgeeks.org/how-to-convert-arraylist-to-hashset-in-java/
     */
     public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }
    
    /** Clears set. 
     * Reference: https://www.geeksforgeeks.org/set-clear-method-in-java-with-examples/
    */
    public void clear() {
        set.clear();
    }
    
    /**
     * Returns items in the set.
     * @return size of the set.
     * Reference: https://www.geeksforgeeks.org/set-size-method-in-java-with-example/
     */
    public int length() {
        return set.size();
    }
    
    /**
     * Checks if equal.
     * @param o object to compare.
     * @return true if sets are equal, false otherwise.
     * Reference: https://stackoverflow.com/questions/9506303/public-boolean-equalsobject-other
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof IntegerSet) {
            IntegerSet other = (IntegerSet) o;
            return new HashSet<>(set).equals(new HashSet<>(other.set));
        }
        return false;
    }
    
    /**
     * Checks for specific value.
     * @param value The value.
     * @return true if in the set, false otherwise.
     * Reference: https://www.geeksforgeeks.org/set-contains-method-in-java-with-examples/
     */
    public boolean contains(int value) {
        return set.contains(value);
    }
    
    /**
     * Largest value in the set.
     * Reference: https://www.geeksforgeeks.org/collections-max-method-in-java-with-examples/
     * @return maximum integer.
     */
    public int largest() {
        return Collections.max(set);
    }
    
    /**
     * Returns the smallest value 
     * @return minimum integer.
     * Reference: https://www.geeksforgeeks.org/collections-min-method-in-java-with-examples/
     */
    public int smallest() {
        return Collections.min(set);
    }
    
    /**
     * Adds an item if not already there.
     * @param item The integer to add.
     * Reference: https://www.geeksforgeeks.org/hashset-add-method-in-java/
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }
    
    /**
     * Removes an item.
     * @param item The integer to remove.
     * Reference: https://stackoverflow.com/questions/4534146/properly-removing-an-integer-from-a-listinteger
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }
    
    /**
     * Performs the union of sets.
     * @param intSetb Another IntegerSet.
     * Reference: https://stackoverflow.com/questions/23314789/how-to-write-a-intersection-and-union-methods-for-sets-in-java
     */
    public void union(IntegerSet intSetb) {
        for (int num : intSetb.set) {
            this.add(num);
        }
    }
    
    /**
     * Performs the intersection with sets.
     * @param intSetb Another IntegerSet.
     * Reference: https://stackoverflow.com/questions/14782981/get-intersection-of-several-lists-using-retainall-in-java
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }
    
    /**
     * Computes the difference (this set - intSetb).
     * @param intSetb Another IntegerSet.
     * Reference: https://stackoverflow.com/questions/18644579/getting-the-difference-between-two-sets
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }
    
    /**
     * Computes the complement (elements in intSetb but not in this set).
     * @param intSetb Another IntegerSet.
     * Reference: https://stackoverflow.com/questions/51145107/if-i-have-a-listsetinteger-what-is-a-fast-way-to-remove-any-sets-which-are-s
     */
    public void complement(IntegerSet intSetb) {
        set = new ArrayList<>(intSetb.set);
        set.removeAll(this.set);
    }
    
    /**
     * Checks if the set is empty.
     * @return true if the set is empty, false otherwise.
     * Reference: https://www.geeksforgeeks.org/set-isempty-method-in-java-with-examples/
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }
    
    /**
     * Returns the string representation of the set.
     * @return A string with the set contents.
     * Reference: https://stackoverflow.com/questions/45985723/returning-elements-of-a-set-in-java-using-tostring-method-on-separate-lines
     */
    @Override
    public String toString() {
        return set.toString();
    }
}