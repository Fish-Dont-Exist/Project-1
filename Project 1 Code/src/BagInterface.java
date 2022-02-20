/***
 *
 * @param <T> Generic Data Type
 */
public interface BagInterface<T>
{

    /**
     * Gets the current number of entries in this bag.
     * @return The integer number of entries currently in the bag
     */
    public int getCurrentSize();

    /**
     * Sees whether this bag is empty.
     * @return True if the bag is empty, or false if not.
     */
    public boolean isEmpty();

    /**
     * Adds a new entry to this bag.
     * @param newEntry The object to be added as a new entry
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry);

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove();

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry);

    /**
     * Removes all entries from this bag.
     */
    public void clear();

    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry The entry to be counted
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry);

    /**
     * Tests whether this bag contains a given entry.
     * @param anEntry The entry to find.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry);

    /**
     * Retrieves all entries that are in this bag.
     * @return A newly allocated array of all the entries in the abg.
     * Note: If the bag is empty, the returned array is empty.
     */
    public T[] toArray();

    /***
     * The union of two collections consists of their contents combined into a new collection. The method union will
     * return a new bag the union of the bag receiving the call to the method and the bag that is the method's argument,
     * which in this case is bag2.
     * @param entry A bag of items will be added to the end of the bag that is calling the method
     * @return union of the two collections
     */
    public T union(T entry);

    /***
     * The intersection of two collections is contains the overlapping entries. That is, the overlapping entries.
     * @param entry A bag of items that will be interected with the bag that is calling the method.
     * @return a new bag that is the intersection of the bag receiving the call to the method and the bag that is the
     * method' one argument which here is bag2.
     */
    public T intersection(T entry);


    /***
     * The difference of two collections is a new collection of the entries that would be left in one collection after
     * removing those that also occur in the second.
     * @param entry A bag of items that will be used in finding the difference from the bag that is calling the method.
     * @return a new bag that is the difference of the bag receiving the call to the method and the bag that is the
     * method's one argument, which here is bag2.
     */
    public T difference(T entry);
}
