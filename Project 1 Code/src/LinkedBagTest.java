public class LinkedBagTest
{
    public static void main(String[] args)
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
        String[] contentsOfBag2 = {"Z", "B", "C"};
        testAdd(bBag, contentsOfBag2);


        // Test union
        System.out.println("The new bag after the union: ");
        BagInterface<String> result = aBag.union(bBag);


        displayBag(result);


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
