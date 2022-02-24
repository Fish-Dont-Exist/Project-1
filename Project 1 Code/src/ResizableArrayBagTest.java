import java.util.Arrays;

/**
 * Client program that contains a main method to test the three methods. This implements the three methods.
 */
public class ResizableArrayBagTest
{
    /**
     * The main will test the three methods union, intersection, and difference we will implement for the class
     * ResizableArrayBag.
     * @param args  Java command line arguments and is an array of type java.lang.String class
     */
    public static void main(String[] args)
    {
        // Adding to an initialily empty bag with sufficient capacity.
        System.out.println("Testing an initially empty bag with sufficient capacity: ");

        BagInterface<String> aBag = new ResizableArrayBag<>(6);

        String[] contentsOfBag1 = {"A", "B", "A"};
        String[] contentsOfBag2 = {"A", "B"};
        String[] contentsOfBag3 = {"Z"};

        testAdd(aBag, contentsOfBag1);
        testAdd(aBag, contentsOfBag2);
        System.out.print("\n The current size of the bag is: " + aBag.getCurrentSize() + "\n");

        testAdd(aBag, contentsOfBag3);
        System.out.print("\n The current size of the bag is: " + aBag.getCurrentSize());

        System.out.print("\n----------------------------------------------------------------------------------\n");
        // Testing union of two bags
        BagInterface<String> bag1 = new ResizableArrayBag<>(3);
        testAdd(bag1, contentsOfBag1);
        System.out.println();
        BagInterface<String> bag2 = new ResizableArrayBag<>(2);
        testAdd(bag2, contentsOfBag2);
        System.out.println();
        
        
        BagInterface<String> result = bag1.union(bag2);

        System.out.println("The union of the bag is: ");
        displayBag(result);
        
        // Testing intersection of two bags

        String[] testBag4 = {"a", "c", "a", "u", "j", "u"};
        String[] testBag5 = {"c", "a", "b", "u", "u"};

        BagInterface<String> tBag4 = new ResizableArrayBag<>(25);
        BagInterface<String> tBag5 = new ResizableArrayBag<>(25);
        testAdd(testBag4, tBag4);
        testAdd(testBag5, tBag5);

        BagInterface<String> tBag6 = tBag4.intersection(tBag5);
        System.out.println("The intersection of the bag is: ");
        displayBag(tBag6);


        //Array bag test for difference
      //Normal Case - equal size arrays
      System.out.println("Difference general use case where arrays are same size");
      BagInterface<String> diffBag1 = new ResizableArrayBag<>();//Initializing bag1 as a resizeable array bag.
      System.out.println("Displaying the contents of bag1");
      String[] a = {"A", "B", "C"};
      testAdd(diffBag1, a);// Adding the string a to bag1
      System.out.println("\nDisplaying the contents of bag2");

      BagInterface<String> diffBag2 = new ResizableArrayBag<>();
      String[] b = {"A", "C", "D"};
      testAdd(diffBag2, b);

      BagInterface<String> diffBag3 = diffBag1.difference(diffBag2); //Expected output is B
      System.out.println("\nDisplaying the difference between the two");

      displayBag(diffBag3);
  

      //Test Case different Size Arrays - Bigger B1
      System.out.println("\nDifference general use case where arrays are different sizes");
      System.out.println("\nDisplaying the contents of bag1 \n");
      String[] c = {"A", "B"};
      testAdd(diffBag1, a);//db1 Should be A B C A B

      System.out.println("\nDisplaying the contents of bag2 \n");
      displayBag(diffBag2);//db2 should be A C D
      diffBag3 = diffBag1.difference(diffBag2); //Expected output is B A B
      System.out.println("\nDisplaying the difference between bag1 and bag2\n");

      displayBag(diffBag3);


      System.out.println("\nDisplaying the difference between bag2 and bag1\n");
      diffBag3 = diffBag2.difference(diffBag1); 
      displayBag(diffBag3); //Bigger B2

      BagInterface<String> diffBag4 = new ResizableArrayBag<>();
      BagInterface<String> diffBag5 = new ResizableArrayBag<>();
      System.out.println("\nOutputting difference between empty array and normal array");
      diffBag3 = diffBag4.difference(diffBag2);
      displayBag(diffBag3);//Output should be a nothing due to array being empty

      System.out.println("\nOutputting difference normal array and empty array");
      diffBag3 = diffBag2.difference(diffBag4);
      displayBag(diffBag3);//Output should be the contents of B2
      
      System.out.println("\nOutputting difference empty array and empty array");
      diffBag3 = diffBag4.difference(diffBag5);
      displayBag(diffBag3);//Output should be the contents of B2




        // Here we will test the three methods
//        String[] bag1 = {"a", "b", "c"};
//        String[] bag2 = {"a", "a", "d", "e"};
//        ResizableArrayBag<String[]> baga = new ResizableArrayBag<>(bag1);
//        ResizableArrayBag<String[]> bagb = new ResizableArrayBag<>(bag2);
//
//        int[] intBag1 = {1, 2, 3};
//        int[] intBag2 = {3, 3, 1};
//        ResizableArrayBag<int[]> intBaga = new ResizableArrayBag<>(intBag1);
//        ResizableArrayBag<int[]> intBagb = new ResizableArrayBag<>(intBag2);


    }

    public static void testAdd(BagInterface<String> aBag, String[] content)
    {
        for (int index = 0; index < content.length; index ++)
        {
            if (aBag.add(content[index]))
            {
                System.out.print(content[index] + " " );
            }
            else
            {
                System.out.print("\nUnable to add " + content[index]);
            }
        } // end for

        System.out.println();
//        displayBag(aBag);
    }

    public static void displayBag(BagInterface<String> aBag)
    {
        Object[] bagArray = aBag.toArray();

        for (int index = 0; index < bagArray.length; index ++)
        {
            System.out.print(bagArray[index] + " ");
        } // end for
    }

    public static void testUnion(BagInterface<String> aBag, BagInterface<String> bBag, String[] content)
    {
        System.out.print("Unioning the two bags: ");
    }

}
