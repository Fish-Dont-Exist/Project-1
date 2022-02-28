import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class ResizableArrayBagTest
{
    //Testing the union method
    @Test
    public void unionSameSizedArraysTest()
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
    public void unionDifferentSizedArraysTest()
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
    public void unionOneArrayNullAndOtherNotTest()
    {
        // Testing the case that one of the bagInterfaces is null
        BagInterface<String> rab1 = new ResizableArrayBag<>();
        BagInterface<String> rab2 = null;

        // Make resizable array bag 1 not empty
        rab1.add("A");

        // Test union: Should throw NullPointerException (Got this from watching youtube tutorial on junit test cases)
        assertThrows(NullPointerException.class, () -> {
            rab1.union(rab2);
        });
    }

    @Test
    public void unionOneEmptyBagAndOneNonEmptyTest()
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


    // Testing the difference method
    @Test 
    public void differenceSameSizedArraysTest()
    {
        // Create two bags of the same size
        BagInterface<String> rab1 = new ResizableArrayBag<>(4);
        BagInterface<String> rab2 = new ResizableArrayBag<>(4);
        BagInterface<String> expectedBag = new ResizableArrayBag<>(3);

        String[] contentsOfBag1 = {"A", "B", "C", "D"};
        String[] contentsOfBag2 = {"A", "C", "A", "B"};
        String[] contentsOfExpectedBag = {"D"};

        for (int index = 0; index < contentsOfBag1.length; index++)
        {
            rab1.add(contentsOfBag1[index]);
            rab2.add(contentsOfBag2[index]);
        }

        for (int index = 0; index < contentsOfExpectedBag.length; index++)
        {
            expectedBag.add(contentsOfExpectedBag[index]);
        }


        BagInterface<String> actualBag = rab1.difference(rab2);
        assertArrayEquals(expectedBag.toArray(), actualBag.toArray());


    }

    @Test
    public void differenceBetweenLargeAndSmallArraysTest()
    {
        // This will test what happens when we take the difference between a large bag and a small bag
        // Difference between larger and smaller
        BagInterface<String> rab1 = new ResizableArrayBag<>();
        BagInterface<String> rab2 = new ResizableArrayBag<>();
        BagInterface<String> expectedBag = new ResizableArrayBag<>();

        String[] contentsOfBag1 = {"A", "B", "C"};
        String[] contentsOfBag2 = {"A", "B"};
        String[] contentsOfExpectedBag = {"C"};

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

        // Create actual result bag
        BagInterface<String> actualBag = rab1.difference(rab2);

        assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
    }

    @Test
    public void differenceBetweenSmallAndLargeArraysTest()
    {
     // This will test what happens when we take the difference between a small bag and a large bag
        // Difference between larger and smaller
        BagInterface<String> rab1 = new ResizableArrayBag<>();
        BagInterface<String> rab2 = new ResizableArrayBag<>();
        BagInterface<String> expectedBag = new ResizableArrayBag<>();

        String[] contentsOfBag1 = {"A", "B", "C", "E"};
        String[] contentsOfBag2 = {"A", "B", "A", "D", "F" };
        String[] contentsOfExpectedBag = {"C", "E"};

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

        // Create actual result bag
        BagInterface<String> actualBag = rab1.difference(rab2);

        assertArrayEquals(expectedBag.toArray(), actualBag.toArray());   
    }

    @Test
    public void differenceResultsInEmptyBagArraysTest()
    {
        // The difference between two bags results in a an empty bag
        // Create the two bags and the expectedBag
        BagInterface<String> rab1 = new ResizableArrayBag<>(3);
        BagInterface<String> rab2 = new ResizableArrayBag<>(4);
        BagInterface<String> expectedBag = new ResizableArrayBag<>();

        String[] contentsOfBag1 = {"A", "B", "C"};
        String[] contentsOfBag2 = {"A", "B", "D", "C"};
        String[] contentsOfExpectedBag = {};

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

        // Create actual result bag
        BagInterface<String> actualBag = rab1.difference(rab2);

        assertArrayEquals(expectedBag.toArray(), actualBag.toArray());

    }

    @Test 
    public void differenceOneArrayNullAndOtherNotArrayTest()
    {
           // Testing the case that one of the bagInterfaces is null
           BagInterface<String> rab1 = new ResizableArrayBag<>();
           BagInterface<String> rab2 = null;
   
           // Make resizable array bag 1 not empty
           rab1.add("A");
   
           // Test union: Should throw NullPointerException (Got this from watching youtube tutorial on junit test cases)
           assertThrows(NullPointerException.class, () -> {
               rab1.difference(rab2);
           });

    }

    @Test
    public void differenceBetweenOneEmptyBagAndOneNonEmptyArrayTest()
    {
        // Create two bags (one empty and one non-empty) and the expected bag
        BagInterface<String> rab1 = new ResizableArrayBag<>();
        BagInterface<String> rab2 = new ResizableArrayBag<>(); 
        BagInterface<String> expectedBag = new ResizableArrayBag<>(); 

        // Create content for bags
        String[] contentsOfBag1 = {};
        String[] contentsOfBag2 = {"A", "B"};
        String[] contentsOfExpectedBag = {};
        
        // Fill in the bags
        // Place all of contents in bag1
        for (int index = 0; index < contentsOfBag1.length; index++)
        {
            rab1.add(contentsOfBag1[index]);
        } 

        // Place appropriate contents in bag2
        for (int index = 0; index < contentsOfBag2.length; index++)
        {
            rab2.add(contentsOfBag2[index]);
        } 

        // Place appropraite contents in expectedBag
        for (int index = 0; index < contentsOfExpectedBag.length; index++)
        {
            expectedBag.add(contentsOfExpectedBag[index]);
        }

        // Create actual results bag
        BagInterface<String> actualBag = rab1.difference(rab2);
        
        // Test difference
        assertArrayEquals(expectedBag.toArray(), actualBag.toArray());


    }

    @Test
    public void differenceBetweenNonEmptyBagAndEmptyBagArrayTest()
    {

    }

    @Test
    public void differenceTwoEmptyBagsTest()
    {

    }

    @Test
    public void differenceBagToSelfTest()
    {

    }
    
    
    // Testing the intersection method
    @Test 
    public void intersectionSameSizedArraysTest()
    {

    }

    @Test
    public void intersectionDifferentSizedArraysTest()
    {
        // Difference between larger and smaller

        // Difference between smaller and larger
    }

    @Test 
    public void intersectionOneArrayNullAndOtherNotTest()
    {

    }

    @Test
    public void intersectionOneEmptyBagAndOneNonEmptyTest()
    {

    }

    @Test
    public void intersectionTwoEmptyBagsTest()
    {

    }

    @Test
    public void intersectionBagToSelfTest()
    {
        
    }

}