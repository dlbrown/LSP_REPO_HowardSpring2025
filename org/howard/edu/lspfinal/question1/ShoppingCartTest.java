package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

/**
 * adding valid item
 */
    @Test
    @DisplayName("Test for adding valid item")
    public void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        assertDoesNotThrow(() -> cart.addItem("Book", 29.99));
        assertEquals(29.99, cart.getTotalCost());
    }
/**
 * adding with 0 price
 */
    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    public void testAddItemZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        assertDoesNotThrow(() -> cart.addItem("Free Sample", 0.0));  // Valid because 0.0 is not negative
        assertEquals(0.0, cart.getTotalCost());
    }

/**
 * adding with negative price
 */
    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    public void testAddItemNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Invalid Item", -5.00));
    }

/**
 * applying SAVE10 discount code
 */
    @Test
    @DisplayName("Test for applying SAVE10 discount code")
    public void testApplySave10() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

/**
 * applying SAVE20 discount code
 */
    @Test
    @DisplayName("Test for applying SAVE20 discount code")
    public void testApplySave20() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

/**
 * applies invalid discount code SAVEE50
 */
    @Test
    @DisplayName("Test for applying invalid discount code (expect exception)")
    public void testApplyInvalidDiscountCode() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE50"));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(""));
    }

/**
 * Totals fosts
 */
    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Pen", 1.50);
        cart.addItem("Notebook", 3.50);
        assertEquals(5.00, cart.getTotalCost());
    }

/**
 * Cost with discount
 */
    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Shoes", 50.00);
        cart.addItem("Hat", 20.00);
        cart.applyDiscountCode("SAVE10");
        assertEquals(63.00, cart.getTotalCost());  // 70 - 7
    }

/**
 * empty cart cost
 */
    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost());
    }

/**
 * removing items
 */
    @Test
    @DisplayName("Test removing existing item")
    public void testRemoveExistingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Keyboard", 25.00);
        cart.addItem("Mouse", 15.00);
        cart.removeItem("Mouse");
        assertEquals(25.00, cart.getTotalCost());
    }

/**
 * removing non esisting items
 */
    @Test
    @DisplayName("Test removing non-existent item")
    public void testRemoveNonExistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Charger", 18.00);
        cart.removeItem("Nonexistent");  // Should not affect anything
        assertEquals(18.00, cart.getTotalCost());
    }

/**
 * update after adding/removing
 */
    @Test
    @DisplayName("Test cart size updates correctly after adding/removing")
    public void testCartSizeUpdate() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("A", 5.0);
        cart.addItem("B", 10.0);
        assertEquals(2, cart.getItemCount()); //updated from items.size to getItemCount


        cart.removeItem("A");
        assertEquals(1, cart.getItemCount()); //updated to get items

    }
}
