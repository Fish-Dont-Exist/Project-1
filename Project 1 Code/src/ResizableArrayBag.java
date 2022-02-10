/**
 * The class ResizableArrayBag presents an implementation of the ADT bag using a resizable array.
 */
public class ResizableArrayBag<T> implements BagInterface<T>
{
    private T bag;

//    // Default constructor?? Do we need one?

    public ResizableArrayBag(T bag_)
    {
        bag = bag_;
    } // end constructor


    // Implement the three methods union, intersection, and difference for resizable arrays.
    @Override
    public T union(T bag2)
    {
        return null;
    }

    @Override
    public T intersection(T bag2)
    {
        return null;
    }

    @Override
    public T difference(T bag2)
    {
        return null;
    }
}
