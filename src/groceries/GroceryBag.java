package groceries;

import java.util.HashMap;

// -------------------------------------------------------------------------
/**
 * The Grocery Bag class is a bag data structure that holds String objects that
 * represent grocery store items.
 *
 * @author G.J. Hu
 * @version 2025.07.21
 */
public class GroceryBag
    extends ArrayBasedBag
{
    // Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public GroceryBag()
    {
        super();
    }


    /**
     * Creates a GroceryBag with the specified capacity.
     * 
     * @param initialCapacity
     *            Desired initial capacity
     */
    public GroceryBag(int initialCapacity)
    {
        super(initialCapacity);
    }


    // Public methods ........................................................
    /**
     * If an element is in both bags, then it will be in the intersection. If
     * there are multiple occurrences of that element, then the number of
     * occurrences of that element in the intersection will equal the minimum
     * number of occurrences in either set. Examples: intersection of
     * ({"apple","apple","cereal","chips"}, {"chips",
     * "apple","apple","chips","cake"}) = {"apple","apple","chips"}
     * 
     * @param bag
     *            Bag to be intersected with.
     * @return The intersection of the two bags.
     */
    public GroceryBag intersection(GroceryBag bag)
    {
        GroceryBag inters = new GroceryBag();
        String[] contents = this.contents();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < this.size(); i++) {
            String content = contents[i];
            if (!map.containsKey(content)) {
                int occ = Math.min(this.occurrence(content),
                                   bag.occurrence(content));
                for (int j = 0; j < occ; j++) {
                    inters.add(content);
                }
                map.put(content, this.occurrence(content));
            }
        }
        return inters;
        
    }


    /**
     * For two bags to be equal they need to contain items with the same names
     * and frequencies (so equality across specific attributes; identity is not
     * required). Order does not matter, but number of occurrences does.
     *
     * @param givenBag
     *            Other bag to be compared with for equality.
     * @return Returns true if the two bags have the same items.
     */
    @Override
    public boolean equals(Object givenBag)
    {
        if (givenBag == this) {
            return true;
        }
        if (givenBag == null) {
            return false;
        }
        if (this.getClass() != givenBag.getClass()) {
            return false;
        }
        GroceryBag bag = (GroceryBag) givenBag;
        if (this.size() != bag.size()) {
            return false;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < bag.size(); i++) {
            String content = this.contents()[i];
            if (!map.containsKey(content)) {
                int occ = this.occurrence(content);
                if (bag.occurrence(content) != occ) {
                    return false;
                }
                map.put(content, occ);
            }
        }
        return true;
    }
}
