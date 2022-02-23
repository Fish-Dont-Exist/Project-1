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

public T union(T entry)
{
   return null;
}

public T difference(T entry)
{
   return null;
}

public T intersection(T entry)
{
   return null;
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
   Node newNode = new Node(newEntry);
   newNode.setNextNode(firstNode);
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

   @Override
   public BagInterface union(BagInterface entry)
   {
      return null;
   }


   private class Node
   {
      private T    data; //Entry in the bag
      private Node next; //Link to the next node

      //Constructors
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      }//End constructor

      private Node(T dataPortion, Node nextNode)
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