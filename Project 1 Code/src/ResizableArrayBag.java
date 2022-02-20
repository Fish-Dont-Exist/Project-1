import java.util.Arrays;

/**
 * The class ResizableArrayBag presents an implementation of the ADT bag using a resizable array.
 */
public class ResizableArrayBag<T> implements BagInterface<T>
{
    private T[] bag; // We remove the final modifier
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Creates an empty bag whose initial capacity is 25.
     */
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor


    /**
     * Creates an empty bag having a given initial capacity.
     * @param desiredCapacity Capacity we want for the array
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
        return numberOfEntries;
    } // end getCurrentSize

    @Override
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end isEmpty

    @Override
    public boolean add(T newEntry)
    {
        if (isArrayFull())
        {
            doubleCapacity();
        } // end if
        bag[numberOfEntries] = newEntry;
        numberOfEntries ++;
        return true; // so that it follows the structure of the interface
    } // end add

    /**
     * Doubles the size of the array bag.
     */
    private void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    } // end doubleCapacity

    /**
     * Throws an exception if the client requests a capacity that is too large.
     * @param capacity Capacity being tested
     */
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY) throw new IllegalStateException("Attempt to create a bag whose" +
                " capacity exceeds allowed " + "maximum of " + MAX_CAPACITY);
    } // end checkCapacity

    /**
     * Returns true if the bag is full, or false if not
     * @return True if the array is full, false otherwise.
     */
    private boolean isArrayFull()
    {
        return numberOfEntries >= bag.length;
    } // end isArrayFull

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

    /**
     * Retrieves all entries that are in this bag.
     * @return A newly allocated array of all the entries in the bag.
     */
    public T[] toArray()
    {
        // The case is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
                T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        } // end for
        return result;
    } // end toArray

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
