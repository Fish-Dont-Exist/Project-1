public class LinkedBag<T> implements BagInterface<T>
{

private int numberOfEntries;
}
class Node<T>
{
   private T data; //Entry in the bag
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