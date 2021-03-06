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
    private boolean integrityOK;

    /**
     * Creates an empty bag whose initial capacity is 25.
     */
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    } // end default constructor


    /**
     * Creates an empty bag having a given initial capacity.
     * @param desiredCapacity Capacity we want for the array.
     * @throws IllegalStateException If capacity will exceed maximum capacity.
     */
    public ResizableArrayBag(int desiredCapacity)
    {
        integrityOK = false;
        if (desiredCapacity <= MAX_CAPACITY)
        {
            // The case is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity]; // unchecked cast
            bag = tempBag;
            numberOfEntries = 0;
            integrityOK = true; // Last action
        }
        else
        {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
        }

    } // End constructor

    // Public methods
    /**
     * Gets the current number of entries in this bag.
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    } // end getCurrentSize


    /**
     * Sees whether this bag is empty.
     * @return True if the bag is empty, or false if not.
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end isEmpty


    /**
     * Adds a new entry to this bag.
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
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
     * Removes one unspecified entry from this bag, if possible.
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove()
    {
        checkIntegrity();
        T result = null;
        if (numberOfEntries > 0)
        {
            result = bag[numberOfEntries - 1]; // store the value we are removing
            bag[numberOfEntries - 1] = null;  // we flag the removed object for garbage collection
            numberOfEntries --;
        } // end if
        return result;
    } // end remove


    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }


    /**
     * Removes all entries from this bag.
     */
    public void clear()
    {
        while (!isEmpty())
        {
            remove(); // just keep on removing entries.
        }
    } // end clear


    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry)
    {
        checkIntegrity();
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++)
        {
            if (anEntry.equals(bag[index]))
            {
                counter ++;
            }
        }
        return counter;
    } // end getFrequencyOf


    /**
     * Tests whether this bag contains a given entry.
     * @param anEntry The entry to find.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry)
    {
        checkIntegrity();
        boolean found = false;
        int index = 0;
        while (!found && (index < numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {
                found = true;
            }
            else
                index++;
        }
        return found;
    } // end contains


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

    /**
     * Combines the entries of two bags and returns a newly combined bag.
     * @param bag2 The second bag to unionize.
     * @return A newly unionized bag with entries from both bags.
     */
    @Override
    public BagInterface<T> union(BagInterface<T> bag2)
    {
        try
        {
            checkIntegrity();
            BagInterface<T> result = new ResizableArrayBag<>();

            // Add all the elements from bag1 to the result
            for (int index = 0; index < getCurrentSize(); index++)
            {
                result.add(bag[index]);
            }
            // Add all the elements from bag2 to the result
            T[] otherBag = (T[]) bag2.toArray();
            for (int index = 0; index < bag2.getCurrentSize(); index++)
            {
                result.add(otherBag[index]);
            }

            return result;
        } // end try
        catch (NullPointerException e)
        {
            throw new NullPointerException("Argument cannot be null.");
        } // end catch
    } //end union

    /**
     * Takes two bags and returns a bag containing the entries they shared.
     * @param bag2 A bag of items that will be intersected with the bag that is calling the method.
     * @return A bag of entries of which both bags contained.
     */
    @Override
    public BagInterface<T> intersection(BagInterface<T> bag2)
    {
        try
        {
            checkIntegrity();
            // Testing for empty bags; will return the empty bag if found
            if (this.isEmpty())
            {
            return this;
            }
            else if (bag2.isEmpty())
            {
                return bag2;
            }
            else if (this.equals(bag2))
            {
                return this;
            }

            // Initialize results bag
            BagInterface<T> bag3 = new ResizableArrayBag<>();
            // Get the frequency of each element in both bags & store it in bag3 the lowest of two frequencies
            for (int i = 0; i < getCurrentSize(); i++)
            {
                int freq1 = getFrequencyOf(bag[i]); // This will get the frequency of the bag

                // Check if bag2 has the item and also make sure that our results bag doesn't already have it inside
                if (bag2.contains(bag[i]) && !(bag3.contains(bag[i])))
                {
                    // If bag2 contains this item, we will find the frequency of the item
                    int freq2 = bag2.getFrequencyOf(bag[i]);

                    // Now we store the value that is SMALLER
                    int smallerNumber = Math.min(freq1, freq2);
                    for (int j = 0; j < smallerNumber; j++)
                    {
                        bag3.add(bag[i]);
                    }
                }
            }
            return bag3;
        } // end try
        catch (NullPointerException e)
        {
            throw new NullPointerException("Cannot pass null as argument.");
        } // end catch
    } //end intersection

    /**
     * Takes two bags and returns the difference between the first and the second bag's entries.
     * @param bag2 A bag of items that will be subtracted from the first bag's items.
     * @return A bag with entries containing the difference between the first and the second bag's entries.
     */
    @Override
    public BagInterface<T> difference(BagInterface<T> bag2)
    {
      try
      {
        checkIntegrity(); //Validates given array
        T[] b1 = bag; //Copies main bag
        T[] b2 = bag2.toArray(); //Copies Parameter and converts it to array
        BagInterface<T> b3 = new ResizableArrayBag<>(); //initializes new Array Bag
  
        for (int i = 0; i < this.getCurrentSize(); i++)
        {
           boolean match = false; // Reset match variable for each iteration
           for (int j = 0; j < bag2.getCurrentSize(); j++)
           {
              if(b1[i].equals(b2[j]))
              {
                 b2[j] = null;
                 match = true;
                 break;
              }//If there is a match set item in b2 to null and break loop
           }//End of Loop j for b2
           if (!match)
           {
              b3.add(b1[i]);
           }//If item is not cancelled out add it to b3
        }//End of Loop i for b1
        return b3;
      }  
      catch (NullPointerException e)
      {
          throw new NullPointerException("Cannot pass null as an argument.");
      }
      
   } //end difference

    // Private methods
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
     * @param capacity Capacity being tested.
     */
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY) throw new IllegalStateException("Attempt to create a bag whose" +
                " capacity exceeds allowed " + "maximum of " + MAX_CAPACITY);
    } // end checkCapacity

    /**
     * Checks the bag to see if it is full.
     * @return True if the array is full, false otherwise.
     */
    private boolean isArrayFull()
    {
        return numberOfEntries >= bag.length;
    } // end isArrayFull

    /**
     * Throws an exception if this object is not initialized.
     * Each vital method of the class can check the status of the field before operation.
     */
    private void checkIntegrity()
    {
        if (!integrityOK)
        {
            throw new SecurityException("ResizableArrayBag object is corrupt.");
        } // end checkIntegrity
    }

    /**
     * Locates a given entry within the array bag.
     * Precondition: checkIntegrity has been called.
     * @param anEntry The entry to be located.
     * @return Returns the index of the entry if it is located or -1 otherwise.
     */
    private int getIndexOf(T anEntry)
    {
        int where = -1;
        boolean found = false;
        int index = 0;
        while (!found && (index < numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            }
            else
                index++;
        } // end while
        return where;
    } // end getIndexOf

    /**
     * Removes an entry at the given index of the bag.
     * Precondition: 0 <= givenIndex < numberOfEntries; checkIntegrity has been called.
     * @param givenIndex The index with the entry to be removed.
     * @return Returns the entry that was removed if it was located or NULL otherwise.
     */
    private T removeEntry(int givenIndex)
    {
        T result = null;
        if (!isEmpty() && (givenIndex >= 0)) // givenIndex >= 0 is kinda like extra coding
        {
            result = bag[givenIndex]; // entry that will be removed
            bag[givenIndex] = bag[numberOfEntries - 1]; // replace it with last entry
            bag[numberOfEntries - 1] = null; //remove the last entry & then put it up for garbage collection
            numberOfEntries --;
        } // end if
        return result;
    } // end removeEntry
}
