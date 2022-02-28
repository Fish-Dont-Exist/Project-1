import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class ResizableArrayBagTest
{
    @Test
    public void sameSizedArraysTest()
    {
        BagInterface<String> rab1 = new ResizableArrayBag<>(4);
        BagInterface<String> rab2 = new ResizableArrayBag<>(4);
        BagInterface<String> expectedBag = new ResizableArrayBag<>(3);

        String[] contentsOfBag1 = {"A", "B", "C", "D"};
        String[] contentsOfBag2 = {"A", "C", "A", "B"};
        String[] contentsOfExpectedBag = {"A", "B", "C", "D", "A", "C", "A", "B"};

        for (int index = 0; index < contentsOfBag1.length; index++)
        {
            rab1.add(contentsOfBag1[index]);
            rab2.add(contentsOfBag2[index]);
        }

        for (int index = 0; index < contentsOfExpectedBag.length; index++)
        {
            expectedBag.add(contentsOfExpectedBag[index]);
        }


        BagInterface<String> actualBag = rab1.union(rab2);
        assertArrayEquals(expectedBag.toArray(), actualBag.toArray());


    }

    @Test
    public void differentSizedArraysTest()
    {
        ResizableArrayBag<String> rab1 = new ResizableArrayBag<>();
        ResizableArrayBag<String> rab2 = new ResizableArrayBag<>();
        ResizableArrayBag<String> expectedBag = new ResizableArrayBag<>();

        String[] contentsOfBag1 = {"A", "B"};
        String[] contentsOfBag2 = {"A", "A", "B", "A"};
        String[] contentsOfExpectedBag = {"A", "B", "A", "A", "B", "A"};

        for (int index = 0; index < contentsOfBag1.length; index++)
        {
            rab1.add(contentsOfBag1[index]);
        }

        for (int index = 0; index < contentsOfBag2.length; index++)
        {
            rab2.add(contentsOfBag2[index]);
        }

        for (int index = 0; index < contentsOfExpectedBag.length; index ++)
        {
            expectedBag.add(contentsOfExpectedBag[index]);
        }

        assertArrayEquals(expectedBag.toArray(), rab1.union(rab2).toArray());
    }

    @Test
    public void oneArrayNullAndOtherNotTest()
    {
        // Testing the case that one of the bagInterfaces is null
        BagInterface<String> rab1 = new ResizableArrayBag<>();
        BagInterface<String> rab2 = null;

        // Make resizable array bag 1 not empty
        rab1.add("A");

        // Test union: Should throw NullPointerException
        assertThrows(NullPointerException.class, () -> {
            rab1.union(rab2);
        });




    }

    @Test
    public void oneEmptyBagAndOneNonEmptyTest()
    {
        // Make the two array bags as well as the expectedBag
        BagInterface<String> rab1 = new ResizableArrayBag<>();
        BagInterface<String> rab2 = new ResizableArrayBag<>();
        BagInterface<String> expectedBag = new ResizableArrayBag<>();

        // Get the contents of the bags
        String[] contentsOfBag1 = {"Q", "W", "E", "R"}; // nonempty bag
        String[] contentsOfBag2 = {}; // empty bag
        String[] contentsOfExpectedBag = {"Q", "W", "E", "R"};

        // Add contents to bags
        for (int index = 0; index < contentsOfBag1.length; index++)
        {
            rab1.add(contentsOfBag1[index]);
        }

        for (int index = 0; index < contentsOfExpectedBag.length; index++)
        {
            expectedBag.add(contentsOfExpectedBag[index]);
        }

        // We will test unioning the bags both ways
        assertArrayEquals(expectedBag.toArray(), rab2.union(rab1).toArray()); // unioning non-empty bag to empty bag
        assertArrayEquals(expectedBag.toArray(), rab1.union(rab2).toArray()); // unioning empty bag to non-empty bag

    }

    @Test
    public void unionTwoEmptyBagsTest()
    {
        // Make the two array bags as well as the expectedBag
        BagInterface<String> rab1 = new ResizableArrayBag<>();
        BagInterface<String> rab2 = new ResizableArrayBag<>();
        BagInterface<String> expectedBag = new ResizableArrayBag<>();

        // Get the contents of the bags
        String[] contentsOfBag1 = {}; // empty bag
        String[] contentsOfBag2 = {}; // empty bag
        String[] contentsOfExpectedBag = {};

        // Test union
        assertArrayEquals(expectedBag.toArray(), rab1.union(rab2).toArray());

    }

    @Test
    public void unionBagToSelfTest()
    {
        // Make only one bag that is non-empty
        BagInterface<String> rab1 = new ResizableArrayBag<>();
        BagInterface<String> expectedBag = new ResizableArrayBag<>();
        BagInterface<String> resultBag = new ResizableArrayBag<>();

        // Create contents of the bag
        String[] contentsOfBag1 = {"A", "B", "C"};
        // String[] contentsOfExpectedBag = {"A", "A", "B", "B", "C", "C"};
        String[] contentsOfExpectedBag = {"A", "B", "C", "A", "B", "C"};

        // Add contents to bag1
        for (int index = 0; index < contentsOfBag1.length; index++)
        {
            rab1.add(contentsOfBag1[index]);
        }

        // Add content to expected bag
        for (int index = 0; index < contentsOfExpectedBag.length; index ++)
        {
            expectedBag.add(contentsOfExpectedBag[index]);
        }

        resultBag = rab1.union(rab1);

        // Test Union
        assertArrayEquals(expectedBag.toArray(), rab1.union(rab1).toArray());

    }
}