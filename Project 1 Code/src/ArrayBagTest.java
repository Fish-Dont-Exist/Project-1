import java.lang.reflect.Array;

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
        // Here we will test the three methods
        String[] bag1 = {"a", "b", "c"};
        String[] bag2 = {"a", "a", "d", "e"};
        ResizableArrayBag<String[]> baga = new ResizableArrayBag<>(bag1);
        ResizableArrayBag<String[]> bagb = new ResizableArrayBag<>(bag2);

        int[] intBag1 = {1, 2, 3};
        int[] intBag2 = {3, 3, 1};
        ResizableArrayBag<int[]> intBaga = new ResizableArrayBag<>(intBag1);
        ResizableArrayBag<int[]> intBagb = new ResizableArrayBag<>(intBag2);




    }

}
