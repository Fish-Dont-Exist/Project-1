/***
 *
 * @param <T> Generic Data Type
 */
public interface BagInterface<T>
{
    /***
     * The union of two collections consists of their contents combined into a new collection. The method union will
     * return a new bag the union of the bag receiving the call to the method and the bag that is the method's argument,
     * which in this case is bag2.
     * @param bag2 A bag of items will be added to the end of the bag that is calling the method
     * @return union of the two collections
     */
    public T union(T bag2);

    /***
     * The intersection of two collections is contains the overlapping entries. That is, the overlapping entries.
     * @param bag2 A bag of items that will be interected with the bag that is calling the method.
     * @return a new bag that is the intersection of the bag receiving the call to the method and the bag that is the
     * method' one argument which here is bag2.
     */
    public T intersection(T bag2);


    /***
     * The difference of two collections is a new collection of the entries that would be left in one collection after
     * removing those that also occur in the second.
     * @param bag2 A bag of items that will be used in finding the difference from the bag that is calling the method.
     * @return a new bag that is the difference of the bag receiving the call to the method and the bag that is the
     * method's one argument, which here is bag2.
     */
    public T difference(T bag2);
}
