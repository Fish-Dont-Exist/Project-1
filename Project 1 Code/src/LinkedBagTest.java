public class LinkedBagTest
{
    public static void main(String[] args) throws NullPointerException
    {
        // Tests on a bag that is empty
        System.out.println("Creating an empty bag.");
        BagInterface<String> aBag = new LinkedBag<>();
        displayBag(aBag);

        // Addint strings
        String[] contentsOfBag = {"A", "B", "C"};
        testAdd(aBag, contentsOfBag);
        displayBag(aBag);


        // New bag for union
        System.out.println();
        BagInterface<String> bBag = new LinkedBag<>();
        String[] contentsOfBag2 = {"Z", "Y", "X"};
        testAdd(bBag, contentsOfBag2);


        // Test union
        System.out.println("The new bag after the union: ");
        BagInterface<String> result = aBag.union(bBag);


        displayBag(result);

        System.out.println();
        // what happens with empty bags
        System.out.println("Empty Bags. ");
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();

        BagInterface<String> r1 = bag1.union(bag2);
        displayBag(r1);

        // Mixing LinkedBag with ResizableArrayBag
        System.out.println("Mixing Resizable Array Bag with LinkedBag");
        BagInterface<String> LBag = new LinkedBag<>();
        BagInterface<String> RABBag = new ResizableArrayBag<>();
        String[] lcontents = {"L", "B", "A", "G"};
        String[] RABContents = {"R", "A", "B"};

        testAdd(LBag, lcontents);
        testAdd(RABBag, RABContents);

        BagInterface<String> mixing =  LBag.union(RABBag);

        displayBag(mixing);

        System.out.println();

        // NOTE: CANNOT TAKE CARE OF THE CASE WHEN BOTH ARE NULL
        System.out.println("We will now be testing a null bag. ");
//        BagInterface<String> b1 = null;
        BagInterface<String> b2 = null;

        BagInterface<String> r2 = LBag.union(b2);
//        BagInterface<String> r2 = b1.union(b2);



        // Intersection Tests
        // When two bags are different sized
        System.out.println("Intersection general use case when LinkedBags are different size");
        BagInterface<String> interBag4 = new LinkedBag<>();//Initializing bag1 as a resizeable array bag.
        System.out.println("Displaying the contents of bag1");
        String[] i4 = {"A", "B", "A", "C", "A"};
        testAdd(interBag4, i4);// Adding the string a to bag1
        System.out.println("\nDisplaying the contents of bag2");

        BagInterface<String> interBag5 = new LinkedBag<>();
        String[] i5 = {"A", "C", "A", "B", "C"};
        testAdd(interBag5, i5);

        BagInterface<String> interBag6 = interBag4.intersection(interBag5); //Expected output is A
        System.out.println("\nDisplaying the intersection between the two");

        displayBag(interBag6);



      // Difference Tests
      // Normal Case - equal size linked chains
      System.out.println("Difference general use case where linked bags are same size");
      BagInterface<String> diffBag1 = new LinkedBag<>();// Initializing bag1 as a linked bag.
      System.out.println("Displaying the contents of bag1");
      String[] a = {"A", "B", "C"};
      testAdd(diffBag1, a);// Adding the string a to bag1
      System.out.println("\nDisplaying the contents of bag2");

      BagInterface<String> diffBag2 = new LinkedBag<>();
      String[] b = {"A", "C", "D"};
      testAdd(diffBag2, b);

      BagInterface<String> diffBag3 = diffBag1.difference(diffBag2); // Expected output is B
      System.out.println("\nDisplaying the difference between the two");

      displayBag(diffBag3);
  

      // Test Case different Size Arrays - Bigger B1
      System.out.println("\nDifference general use case where arrays are different sizes");
      System.out.println("\nDisplaying the what is added to bag1, total is (A B C A B) \n");
      String[] c = {"A", "B"};
      testAdd(diffBag1, c);// db1 Should be A B C A B

      System.out.println("\nDisplaying the contents of bag2 \n");
      displayBag(diffBag2);// db2 should be A C D
      diffBag3 = diffBag1.difference(diffBag2); // Expected output is B A B
      System.out.println("\nDisplaying the difference between bag1 and bag2\n");

      displayBag(diffBag3);


      System.out.println("\nDisplaying the difference between bag2 and bag1\n");
      diffBag3 = diffBag2.difference(diffBag1); 
      displayBag(diffBag3); // Bigger B2 (D)

      BagInterface<String> diffBag4 = new LinkedBag<>();
      BagInterface<String> diffBag5 = new LinkedBag<>();
      System.out.println("\nOutputting difference between empty array and normal array");
      diffBag3 = diffBag4.difference(diffBag2);
      displayBag(diffBag3);// Output should be a nothing due to linked bag being empty

      System.out.println("\nOutputting difference normal array and empty array");
      diffBag3 = diffBag2.difference(diffBag4);
      displayBag(diffBag3);// Output should be the contents of B2 (A C D)
      
      System.out.println("\nOutputting difference empty array and empty array");
      diffBag3 = diffBag4.difference(diffBag5);
      displayBag(diffBag3);// Output should be nothing and lnked bag is empty
    }

    public static void displayBag(BagInterface<String> aBag)
    {
        Object[] bagArray = aBag.toArray();

        for (int index = 0; index < bagArray.length; index++)
        {
            System.out.print(bagArray[index] + " ");
        } // end for
    }

    public static void testUnion(BagInterface<String> aBag, BagInterface<String> bBag)
    {
        //
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
}
