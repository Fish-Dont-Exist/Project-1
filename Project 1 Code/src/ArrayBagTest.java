import java.util.Arrays;

/**
 * Client program that contains a main method to test the three methods. This implements the three methods.
 */
public class ArrayBagTest
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
        String[] contentsOfBag2 = {"C", "D", "A"};
        String[] contentsOfBag3 = {"Z"};

        testAdd(aBag, contentsOfBag1);
        testAdd(aBag, contentsOfBag2);
        System.out.print("\n The current size of the bag is: " + aBag.getCurrentSize() + "\n");

        testAdd(aBag, contentsOfBag3);
        System.out.print("\n The current size of the bag is: " + aBag.getCurrentSize());

        




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
        displayBag(aBag);
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
