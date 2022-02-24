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

        // null bag test
        System.out.println("We will now be testing a null bag. ");
//        BagInterface<String> b1 = null;
        BagInterface<String> b2 = null;

        BagInterface<String> r2 = LBag.union(b2);



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
