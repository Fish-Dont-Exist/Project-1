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

public BagInterface<T> union(BagInterface<T> bag2)
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

public BagInterface<T> intersection(BagInterface<T> entry)
{
   return null;
}

public BagInterface<T> difference(BagInterface<T> bag2)
{
   BagInterface<T> b3 = new LinkedBag<>();
   Node currentNode = firstNode;
   T[] b2 = bag2.toArray();
   int amount = 0;
   for(int i = 0; i < getCurrentSize(); i++)
   {
      T entry = currentNode.getData();
      
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
}


//General methods

public int getCurrentSize()
{
   return numberOfEntries;
}//end getCurrentSize

public boolean isEmpty()
{
   return numberOfEntries == 0;
}//end isEmpty

public void clear()
{
   while(!isEmpty())
      remove();
}//end clear

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