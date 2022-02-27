/**
 * The class LinkedBag implements the ADT bag using a linked list.
 */
public class LinkedBag<T> implements BagInterface<T>
{
private Node firstNode;
private int numberOfEntries;

public LinkedBag()
{
   firstNode = null;
   numberOfEntries = 0;
}//end default constructor

//Union, Difference, Intersection methods for linked list

   /**
    * Combines the two entries of the two bags and returns a newly combined bag
    * @param bag2 The second bag to be combined with
    * @return A bag which contains the entries of both bags
    */
   public BagInterface<T> union(BagInterface<T> bag2)
{
   try
   {
      // Initialize result that will be returned and the currentNode
      BagInterface<T> result = new LinkedBag<>();
      Node currentNode = firstNode;

      // Add all the elements from bag1 to the result
      int counter = 0;
      while ((counter < numberOfEntries) && (currentNode != null))
      {
         result.add(currentNode.getData());        // add the data of the current node
         currentNode = currentNode.getNextNode();  // traverse the chain (visit the next node
         counter ++;
      }

      // Add all the elements from bag2 to the result
      T[] otherBag = (T[]) bag2.toArray();
      for (int index = 0; index < bag2.getCurrentSize(); index++)
      {
         result.add(otherBag[index]);
      }

      return result;
   }
   // Used to catch any NULL entries
   catch (NullPointerException e)
   {
      System.out.println(e.getMessage() + " nice going nerd.");
   }
   return null;
} //end union

   /**
    * Takes two bags and returns a bag containing the entries they shared
    * @param otherBag A bag which will be intersected with the bag that is calling the method
    * @return A bag containing the entries that the first and second bag shared
    */
   public BagInterface<T> intersection(BagInterface<T> otherBag)
{
   // Set up the results bag and the used bag
//   BagInterface<T> usedBag = new LinkedBag<>();

   BagInterface <T> results = new LinkedBag<>();
   Node currentNode1 = firstNode;


   // Check the frequency of every element in the referenced bag and then compare the frequency that appears in entry
   int counter = 0;
   while (counter < getCurrentSize() && (currentNode1 != null))
   {
      // Get the data to avoid making so many function calls
      T data = currentNode1.getData();

      int freq1 = getFrequencyOf(data);


      // Check to see if it appears in entry bag and make sure that we have not already used it
      if (otherBag.contains(data) && !(results.contains(data)))
      {


         // Find the frequency of the item
         int freq2 = otherBag.getFrequencyOf(data);

         // Insert the item the minimal number of times
         int smallerNumber = Math.min(freq1, freq2);
         for (int j = 0; j < smallerNumber; j++)
         {
            results.add(data);
         }

      }

      // Change the current node to the next node
      currentNode1 = currentNode1.getNextNode();

      counter++;
   }

   return results;
} //end intersection

   /**
    * Takes two bags and returns the difference between the first and the second bag's entries
    * @param bag2 A bag of items which will be subtracted from the bag that calls the method
    * @return A bag that contains the difference between the first and the second bag's entries
    */
   public BagInterface<T> difference(BagInterface<T> bag2)
{
   BagInterface<T> b3 = new LinkedBag<>();
   Node currentNode = firstNode; // Copies node
   T[] b2 = bag2.toArray();
   int amount = 0;
   for(int i = 0; i < getCurrentSize(); i++)
   {
      T entry = currentNode.getData(); //
      
      amount = this.getFrequencyOf(currentNode.getData());
      int sub = 0;
      if (b3.contains(entry))
      {
         currentNode = currentNode.getNextNode();
      }
      else
      {
         for (int k = 0; k < bag2.getCurrentSize(); k ++)
         {
            if(entry.equals(b2[k]))
            {
               sub += 1;
            }
         }

         amount = amount - sub;
         for(int j = 0; j < amount; j++)
         {
            b3.add(entry);
         }
         currentNode = currentNode.getNextNode();
      }  
   }
   return b3;
} //end difference


//General methods

   /**
    * Gets the current size of the bag
    * @return The integer value of the size of the bag
    */
   public int getCurrentSize()
{
   return numberOfEntries;
}//end getCurrentSize

   /**
    * Checks to see if the bag is empty
    * @return A boolean that is true if the bag is empty or false otherwise
    */
   public boolean isEmpty()
   {
   return numberOfEntries == 0;
   }//end isEmpty

   /**
    * Removes all entries from a bag
    */
   public void clear()
   {
   while(!isEmpty())
      remove();
   }//end clear

   /**
    * Adds an entry to the bag
    * @param newEntry The object to be added as a new entry
    * @return A boolean that is true if the object was successfully added and false otherwise
    */
   public boolean add(T newEntry)
   {
   //Adding to the beginning of the chain
   Node newNode = new Node(newEntry); // now newNode.data = newEntry, newNode.next = null
   newNode.setNextNode(firstNode);    // now newNode.data = newEntry, newNode.next = firstNode
//   newNode.next = firstNode; // New node reference is the rest of the chain

   firstNode = newNode; // New node is at the beginning of the chain
   numberOfEntries++;

   return true;
   }//end add

   /**
    * Searches for a specific entry in a bag
    * @param anEntry The specific entry to be searched for
    * @return The node that the entry was found in
    */
   private Node getReferenceTo(T anEntry)
   {
      boolean found = false;
      Node currentNode = firstNode;

      while(!found &&(currentNode != null))
      {
         if (anEntry.equals(currentNode.getData()))
            found = true;
         else
            currentNode = currentNode.getNextNode();
      }//end while
      return currentNode;
   }

   /**
    * Attempts to remove an entry from the bag
    * @return Returns the removed entry, or NULL otherwise
    */
   public T remove()
{
   T result = null;
   if (firstNode != null)
   {
      result = firstNode.getData();
      firstNode = firstNode.getNextNode();
      numberOfEntries--;
   }
   return result;
}

   /**
    * Attempts to remove an entry from the bag
    * @param anEntry The entry to be removed.
    * @return Returns a boolean that is true if the removal is successful and false otherwise
    */
   public boolean remove(T anEntry)
{
   boolean result = false;
   Node nodeN = getReferenceTo(anEntry);

   if (nodeN != null)
   {
      nodeN.setData(firstNode.getData());

      firstNode = firstNode.getNextNode();

      numberOfEntries--;
   }
   return result;
}

   /**
    * Gets the frequency of the times a given entry is listed in a bag
    * @param anEntry The entry to be counted
    * @return Returns an integer of the amount of times the entry appears in the bag
    */
   public int getFrequencyOf(T anEntry)
{
   int frequency = 0;
   int counter = 0;
   Node currentNode = firstNode;
   while ((counter < numberOfEntries) && (currentNode != null))
   {
      if(anEntry.equals(currentNode.getData()))
      {
         frequency++;
      }//end if
      counter++;
      currentNode = currentNode.getNextNode();
   }//end while
   return frequency;
}//end getFrequencyOf

   /**
    * Searches for an entry in the bag
    * @param anEntry The entry to find.
    * @return Returns a boolean that is true if the entry was found and false otherwise
    */
   public boolean contains(T anEntry)
{
   boolean found = false;
   Node currentNode = firstNode;

   while (!found && (currentNode != null))
   {
      if (anEntry.equals(currentNode.getData()))
         found = true;
      else
         currentNode = currentNode.getNextNode();
   }//end while
   return found;
}//end contains

   /**
    * Retrieves all entries inside the bag
    * @return Returns a newly created Node with all the entries in the bag
    */
   public T[] toArray()
{
   @SuppressWarnings("unchecked")
   T[] result = (T[])new Object[numberOfEntries];

   int index = 0;
   Node currentNode = firstNode;
   while ((index < numberOfEntries) && (currentNode != null))
   {
      result[index] = currentNode.getData(); 
      index++;
      currentNode = currentNode.getNextNode();
   }//end while
   return result;
}

   /**
    * The class used to create the node for the bag
    */
   private class Node
   {
      private T    data; //Entry in the bag
      private Node next; //Link to the next node

      //Constructors
      private Node(T dataPortion) // This is the constructor that creates the initial node (the first desk)
      {
         this(dataPortion, null);
      }//End constructor

      private Node(T dataPortion, Node nextNode) // This is the constructor for a non-empty chain.
      {
         data = dataPortion;
         next = nextNode;
      }//End constructor

      //Methods
      private T getData()
      {
         return data;
      }//End getData

      private void setData(T newData)
      {
         data = newData;
      }//End setData

      private Node getNextNode()
      {
         return next;
      }//End getNextNode

      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      }//End setNextNode


   }

}