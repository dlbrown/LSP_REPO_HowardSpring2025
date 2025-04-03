//By Devon L. Brown 
//HW 6 for Spring 2025 Object Oriented Programming
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




package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


/**
 * JUnit test for IntegerSet
 */
public class IntegerSetTest {
    IntegerSet set1;
    IntegerSet set2;

    /**
     * Initializes
     */
    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    /**
     * Testing to make sure it works
     */
    @Test
    @DisplayName("Sanity test")
    public void testSanity() {
        assertEquals(2, 1 + 1);
    }

    /**
     * Tests clear().
     */
    @Test
    @DisplayName("Test case for clear() and isEmpty()")
    public void testClearAndIsEmpty() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    /**
     * Tests ength() .
     */
    @Test
    @DisplayName("Test case for length()")
    public void testLength() {
        set1.add(10);
        set1.add(20);
        assertEquals(2, set1.length());
    }

    /**
     * Tests Equals().
     */
    @Test
    @DisplayName("Test case for equals()")
    public void testEquals() {
        set1.add(5);
        set1.add(10);
        set2.add(10);
        set2.add(5);
        assertTrue(set1.equals(set2));
    }

    /**
     * Tests contains() - true and false.
     */
    @Test
    @DisplayName("Test case for contains()")
    public void testContains() {
        set1.add(100);
        assertTrue(set1.contains(100));
        assertFalse(set1.contains(200));
    }

    /**
     * Tests largest().
     */
    @Test
    @DisplayName("Test case for largest() with values")
    public void testLargest() throws IntegerSetException {
        set1.add(3);
        set1.add(8);
        set1.add(1);
        assertEquals(8, set1.largest());
    }

    /**
     * Tests largest().
     */
    @Test
    @DisplayName("Test case for largest() exception")
    public void testLargestException() {
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.largest();
        });
        assertEquals("Set is empty", exception.getMessage());
    }

    /**
     * Tests smallest() - vals.
     */
    @Test
    @DisplayName("Test case for smallest() with values")
    public void testSmallest() throws IntegerSetException {
        set1.add(7);
        set1.add(2);
        set1.add(10);
        assertEquals(2, set1.smallest());
    }

    /**
     * Tests smallest() - excep
     */
    @Test
    @DisplayName("Test case for smallest() exception")
    public void testSmallestException() {
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.smallest();
        });
        assertEquals("Set is empty", exception.getMessage());
    }

    /**
     * Tests that add()
     */
    @Test
    @DisplayName("Test case for add() - avoids duplicates")
    public void testAdd() {
        set1.add(4);
        set1.add(4);
        assertEquals(1, set1.length());
    }

    /**
     * Tests remove()
     */
    @Test
    @DisplayName("Test case for remove()")
    public void testRemove() {
        set1.add(9);
        set1.remove(9);
        assertFalse(set1.contains(9));
    }

    /**
     * Tests union()
     */
    @Test
    @DisplayName("Test case for union()")
    public void testUnion() {
        set1.add(1);
        set2.add(2);
        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
    }

    /**
     * Tests intersect()
     */
    @Test
    @DisplayName("Test case for intersect()")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertEquals(1, set1.length());
        assertTrue(set1.contains(2));
    }

    /**
     * Tests diff()
     */
    @Test
    @DisplayName("Test case for diff()")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(4);
        set1.diff(set2);
        assertFalse(set1.contains(2));
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(3));
    }

    /**
     * Tests complement() items in set2 not in set1.
     */
    @Test
    @DisplayName("Test case for complement()")
    public void testComplement() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.complement(set2);
        assertEquals(1, set1.length());
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(2));
    }

    /**
     * Tests string 
     */
    @Test
    @DisplayName("Test case for toString()")
    public void testToString() {
        set1.add(7);
        set1.add(9);
        String result = set1.toString();
        assertTrue(result.contains("7"));
        assertTrue(result.contains("9"));
    }
}
