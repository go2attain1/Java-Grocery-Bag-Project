package groceries;

import java.util.ArrayList;

/**
 * This class tests the GroceryBag class for correct output.
 * It verifies that the methods in the class do what they are expected to do.
 *
 * @author G.J. Hu
 * @version 2025.07.21
 */

public class GroceryBagTest extends student.TestCase {
    private GroceryBag bag1;   
    private GroceryBag bag2;    
    private GroceryBag bag3;    
    private GroceryBag bag4;    
    private GroceryBag bag5;
    
    /**
     * Set up for all test methods. Runs before every test.
     */
    public void setUp()
    {
        bag1 = new GroceryBag();
        bag1.add("apples");
        bag1.add("chips");
        bag1.add("yogurt");
        bag1.add("chicken");
        bag1.add("pasta");

        bag2 = new GroceryBag();
        bag2.add("pizza");
        bag2.add("broccoli");
        bag2.add("pasta");
        bag2.add("pasta");
        bag2.add("apples");

        bag3 = new GroceryBag();
        bag3.add("apples");
        bag3.add("chicken");
        bag3.add("chicken");
        bag3.add("pasta");
        bag3.add("pizza");
        bag3.add("soda");
        bag3.add("yogurt");
        bag3.add("wheat");

        bag4 = new GroceryBag();
        bag4.add("chicken");
        bag4.add("chicken");
        bag4.add("pasta");
        bag4.add("pasta");
        bag4.add("yogurt");

        bag5 = new GroceryBag();
        bag5.add("pasta");
        bag5.add("yogurt");
        bag5.add("chicken");
        bag5.add("pasta");
        bag5.add("chicken");
    }

    /**
     * Tests that creating an empty bag using the default/specified capacity
     */   
    public void testInitialCapacity() {
        GroceryBag bag = new GroceryBag();
        int defaultCapacity = bag.contents().length;
        assertEquals(100, defaultCapacity);
        
        int initialCapacity = 80;
        GroceryBag bagInitial = new GroceryBag(initialCapacity);
        assertEquals(initialCapacity, bagInitial.contents().length);
    }
  
    /**
     * Tests that the equals() method returns the expected output
     */   
    public void testEquals() {
        assertTrue(bag1.equals(bag1));
        
        Object o = new ArrayList<Integer>();
        assertEquals(false, bag1.equals(o));
        
        Object a = null;
        assertEquals(false, bag1.equals(a));
        
        assertEquals(false, bag1.equals(bag3));
        
        assertTrue(bag4.equals(bag5));
        
        GroceryBag bag6;
        bag6 = new GroceryBag();
        bag6.add("apples");
        bag6.add("chips");
        bag6.add("yogurt");
        bag6.add("chicken");
        bag6.add("pasta");
        assertTrue(bag1.equals(bag6));
        
        assertEquals(false, bag2.equals(bag3));
        
        assertEquals(false, bag4.equals(bag6));
    }
    
    /**
     * Tests that the intersection() method returns the expected output
     */  
    public void testIntersection() {
        GroceryBag intersection1;
        intersection1 = new GroceryBag();
        intersection1.add("chicken");
        intersection1.add("chicken");
        intersection1.add("pasta");
        intersection1.add("yogurt");
        assertTrue((bag3.intersection(bag4)).equals(intersection1));
        
        GroceryBag intersection0;
        GroceryBag bag7;
        intersection0 = new GroceryBag();
        bag7 = new GroceryBag();
        assertTrue((bag1.intersection(bag7)).equals(intersection0));
        bag7.add("beef");
        bag7.add("salt");
        bag7.add("pepper");
        assertTrue((bag1.intersection(bag7)).equals(intersection0));

    }
}
