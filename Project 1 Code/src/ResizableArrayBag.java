/**
 * The class ResizableArrayBag presents an implementation of the ADT bag using a resizable array.
 */
public class ResizableArrayBag<T> implements BagInterface<T>
{
    private T[] bag; // We remove the final modifier
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    /**
     * Creates an empty bag whose initial capacity is 25.
     */
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor


    /**
     * Creates an empty bag having a given initial capacity.
     * @param desiredCapacity
     */
    public ResizableArrayBag(int desiredCapacity)
    {
        // The case is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[]) new Object[desiredCapacity]; // unchecked cast
        bag = tempbag;
        numberOfEntries = 0;
    } // End constructor


    @Override
    public int getCurrentSize()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public boolean add(T newEntry)
    {
        return false;
    }

    @Override
    public T remove()
    {
        return null;
    }

    @Override
    public boolean remove(T anEntry)
    {
        return false;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public int getFrequencyOf(T anEntry)
    {
        return 0;
    }

    @Override
    public boolean contains(T anEntry)
    {
        return false;
    }

    @Override
    public T[] toArray()
    {
        return null;
    }

    // Implement the three methods union, intersection, and difference for resizable arrays.
    @Override
    public T union(T entry)
    {
        return null;
    }

    @Override
    public T intersection(T entry)
    {
        return null;
    }

    @Override
    public T difference(T entry)
    {
        return null;
    }
}
