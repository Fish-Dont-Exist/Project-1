import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedBagTest
{
    // TESTING UNION METHOD
    @Test
    public void unionSameSizedLinkedTest()
    {
        // Create two bags and an expected bag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of each of the bags
        String[] contentsOfBag1 = {"A", "B", "C"};
        String[] contentsOfBag2 = {"X", "Y", "Z"};
        String[] contentsOfExpectedBag = {"C", "B", "A", "Z", "Y", "X"};

        // Add the contents to the bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual results bag
        BagInterface<String> actualBag = rab1.union(rab2);

        // Test the array versions of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
        
    }

    @Test
    public void unionDifferentSizedLinkedTest()
    {
        // Create two bags and an expected bag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of each of the bags
        String[] contentsOfBag1 = {"A", "B"};
        String[] contentsOfBag2 = {"X", "Y", "Z"};
        String[] contentsOfExpectedBag = {"B", "A", "Z", "Y", "X"};

        // Add the contents to the bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual results bag
        BagInterface<String> actualBag = rab1.union(rab2);

        // Test the array versions of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void unionOneLinkedNullAndOtherNotLinkedTest()
    {
        // Testing the case that one of the bagInterfaces is null
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = null;

        // Make resizable array bag 1 not empty
        rab1.add("A");

        // Test union: Should throw NullPointerException (Got this from watching youtube tutorial on junit test cases)
        assertThrows(NullPointerException.class, () -> {
            rab1.union(rab2);
        });
    }

    @Test
    public void unionOneEmptyBagAndOneNonEmptyLinkedTest()
    {
        // Make the two array bags as well as the expectedBag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Get the contents of the bags
        String[] contentsOfBag1 = {}; // empty bag
        String[] contentsOfBag2 = {"Q", "W", "E", "R"}; // nonempty bag
        String[] contentsOfExpectedBag = {"R", "E", "W", "Q"};

        // Add contents to the bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual results bag
        BagInterface<String> actualBag = rab1.union(rab2);

        // Test array versions of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray()); // unioning empty bag to non-empty bag
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void unionNonEmptyBagAndOneEmptyLinkedTest()
    {
        // Make the two array bags as well as the expectedBag
        BagInterface<String> rab1 = new ResizableArrayBag<>();
        BagInterface<String> rab2 = new ResizableArrayBag<>();
        BagInterface<String> expectedBag = new ResizableArrayBag<>();

        // Get the contents of the bags
        String[] contentsOfBag1 = {"Q", "W", "E", "R"}; // nonempty bag
        String[] contentsOfBag2 = {}; // empty bag
        String[] contentsOfExpectedBag = {"Q", "W", "E", "R"};

        // Add contents to the bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual results bag
        BagInterface<String> actualBag = rab2.union(rab1);

        // Test array versions of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray()); // unioning empty bag to non-empty bag
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void unionTwoEmptyLinkedTest()
    {
        // Create two bags and the expected results bag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Get the contents of the bags
        String[] contentsOfBag1 = {}; // empty bag
        String[] contentsOfBag2 = {}; // empty bag
        String[] contentsOfExpectedBag = {};

        // Add contents to bag (even if it is empty)
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create the actual bag
        BagInterface<String> actualBag = rab1.union(rab2);

        // Test union
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void unionBagToSelfLinkedTest()
    {
        // Create one bag and one expected bag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();
        
        // Create contents of the bag
        String[] contentsOfBag1 = {"A", "B", "C"};
        String[] contentsOfExpectedBag = {"C", "B", "A", "C", "B", "A"};
        
        // Add contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(expectedBag, contentsOfExpectedBag);
        
        // Create actual results bag
        BagInterface<String> actualBag = rab1.union(rab1);

        // Test array versions of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }


    // TESTING DIFFERENCE METHOD
    @Test 
    public void differenceSameSizedLinkedTest()
    {
        // Create two bags of the same size
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of each of the bags
        String[] contentsOfBag1 = {"A", "B", "C", "D"};
        String[] contentsOfBag2 = {"A", "C", "A", "B"};
        String[] contentsOfExpectedBag = {"D"};

        // Add the contents to each of the bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);
        
        // Create actual results bag
        BagInterface<String> actualBag = rab1.difference(rab2);

        // Test the difference of the bags
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void differenceBetweenLargeAndSmallLinkedTest()
    {
        // Create two bags of the same size
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of each of the bags
        String[] contentsOfBag1 = {"A", "B", "C", "D"};
        String[] contentsOfBag2 = {"A", "C", "A", "B"};
        String[] contentsOfExpectedBag = {"D"};

        // Add the contents to each of the bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);
        
        // Create actual results bag
        BagInterface<String> actualBag = rab1.difference(rab2);

        // Test the difference of the bags
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void differenceBetweenSmallAndLargeLinkedTest()
    {
     // This will test what happens when we take the difference between a small bag and a large bag
        // Difference between larger and smaller
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define contents of bags
        String[] contentsOfBag1 = {"A", "B", "C", "E"};
        String[] contentsOfBag2 = {"A", "B", "A", "D", "F" };
        String[] contentsOfExpectedBag = {"E", "C"};

        // Add contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual result bag
        BagInterface<String> actualBag = rab1.difference(rab2);

        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray()); 
        assertTrue(checkContains(actualBag, expectedBag));   
    }

    @Test
    public void differenceResultsInEmptyBagLinkedTest()
    {
        // The difference between two bags results in a an empty bag
        // Create the two bags and the expectedBag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of the bags
        String[] contentsOfBag1 = {"A", "B", "C"};
        String[] contentsOfBag2 = {"A", "B", "D", "C"};
        String[] contentsOfExpectedBag = {};

        // Add the contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual result bag
        BagInterface<String> actualBag = rab1.difference(rab2);

        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test 
    public void differenceOneLinkedNullAndOtherNotLinkedTest()
    {
           // Testing the case that one of the bagInterfaces is null
           BagInterface<String> rab1 = new LinkedBag<>();
           BagInterface<String> rab2 = null;
   
           // Make resizable array bag 1 not empty
           rab1.add("A");
   
           // Test union: Should throw NullPointerException (Got this from watching youtube tutorial on junit test cases)
           assertThrows(NullPointerException.class, () -> {
               rab1.difference(rab2);
           });

    }

    @Test
    public void differenceBetweenOneEmptyBagAndOneNonEmptyLinkedTest()
    {
        // Create two bags (one empty and one non-empty) and the expected bag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>(); 
        BagInterface<String> expectedBag = new LinkedBag<>(); 

        // Create content for bags
        String[] contentsOfBag1 = {};
        String[] contentsOfBag2 = {"A", "B"};
        String[] contentsOfExpectedBag = {};
        
        // Fill in the bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual results bag
        BagInterface<String> actualBag = rab1.difference(rab2);
        
        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void differenceBetweenNonEmptyBagAndEmptyBagLinkedTest()
    {
        // Create the two bags and the expectedBag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of the bags
        String[] contentsOfBag1 = {"A", "B", "C"};
        String[] contentsOfBag2 = {};
        String[] contentsOfExpectedBag = {"C", "B", "A"};

        // Add the contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual result bag
        BagInterface<String> actualBag = rab1.difference(rab2);

        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void differenceTwoEmptyBagsLinkedTest()
    {
        // Create the two bags and the expectedBag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of the bags
        String[] contentsOfBag1 = {};
        String[] contentsOfBag2 = {};
        String[] contentsOfExpectedBag = {};

        // Add the contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual result bag
        BagInterface<String> actualBag = rab1.difference(rab2);

        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void differenceBagToSelfLinkedTest()
    {
        // Create the two bags and the expectedBag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of the bags
        String[] contentsOfBag1 = {"A", "B", "C"};
        String[] contentsOfExpectedBag = {};

        // Add the contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual result bag
        BagInterface<String> actualBag = rab1.difference(rab1);

        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }
    
    
    // TESTING THE INTERSECTION METHOD
    @Test 
    public void intersectionSameSizedLinkedWithNoRepeatsTest()
    {
        // Create the two bags and the expectedBag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of the bags
        String[] contentsOfBag1 = {"A", "B", "C", "E"};
        String[] contentsOfBag2 = {"A", "B", "D", "C"};
        String[] contentsOfExpectedBag = {"C", "B", "A"};

        // Add the contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual result bag
        BagInterface<String> actualBag = rab1.intersection(rab2);

        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void intersectionSameSizedLinkedWithRepeatsTest()
    {
        // Create the two bags and the expectedBag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of the bags
        String[] contentsOfBag1 = {"A", "B", "C", "C", "E"};
        String[] contentsOfBag2 = {"A", "B", "C", "D", "C"};
        String[] contentsOfExpectedBag = {"C", "C", "B", "A"};

        // Add the contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual result bag
        BagInterface<String> actualBag = rab1.intersection(rab2);

        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void intersectionDifferentSizedLinkedTest()
    {
        // Create the two bags and the expectedBag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new ResizableArrayBag<>();

        // Define the contents of the bags
        String[] contentsOfBag1 = {"B", "A"};
        String[] contentsOfBag2 = {"A", "B", "A"};
        String[] contentsOfExpectedBag = {"B", "A"};

        // Add the contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual result bag
        BagInterface<String> actualBag = rab1.intersection(rab2);

        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test 
    public void intersectionOneLinkedNullAndOtherNotTest()
    {
        // Testing the case that one of the bagInterfaces is null
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = null;

        // Make resizable array bag 1 not empty
        rab1.add("A");

        // Test union: Should throw NullPointerException (Got this from watching youtube tutorial on junit test cases)
        assertThrows(NullPointerException.class, () -> {
            rab1.intersection(rab2);
        });

    }

    @Test
    public void intersectionOneEmptyBagAndOneNonEmptyLinkedTest()
    {
        // Create the two bags and the expectedBag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of the bags
        String[] contentsOfBag1 = {};
        String[] contentsOfBag2 = {"A", "B", "C"};
        String[] contentsOfExpectedBag = {};

        // Add the contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual result bag
        BagInterface<String> actualBag = rab1.intersection(rab2);

        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void intersectionNonEmptyAndEmptyBagLinkedTest()
    {
       // Create the two bags and the expectedBag
       BagInterface<String> rab1 = new LinkedBag<>();
       BagInterface<String> rab2 = new LinkedBag<>();
       BagInterface<String> expectedBag = new LinkedBag<>();

       // Define the contents of the bags
       String[] contentsOfBag1 = {"A", "B", "C"};
       String[] contentsOfBag2 = {};
       String[] contentsOfExpectedBag = {};

       // Add the contents to bags
       addContent(rab1, contentsOfBag1);
       addContent(rab2, contentsOfBag2);
       addContent(expectedBag, contentsOfExpectedBag);

       // Create actual result bag
       BagInterface<String> actualBag = rab1.intersection(rab2);

       // Test the array version of the bags for equality
    //    assertArrayEquals(expectedBag.toArray(), actualBag.toArray()); 
    assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void intersectionTwoEmptyBagsLinkedTest()
    {
        // Create the two bags and the expectedBag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> rab2 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of the bags
        String[] contentsOfBag1 = {};
        String[] contentsOfBag2 = {};
        String[] contentsOfExpectedBag = {};

        // Add the contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(rab2, contentsOfBag2);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual result bag
        BagInterface<String> actualBag = rab1.intersection(rab2);

        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    @Test
    public void intersectionBagToSelfLinkedTest()
    {
        // Create the two bags and the expectedBag
        BagInterface<String> rab1 = new LinkedBag<>();
        BagInterface<String> expectedBag = new LinkedBag<>();

        // Define the contents of the bags
        String[] contentsOfBag1 = {"A", "B"};
        String[] contentsOfExpectedBag = {"B", "A"};

        // Add the contents to bags
        addContent(rab1, contentsOfBag1);
        addContent(expectedBag, contentsOfExpectedBag);

        // Create actual result bag
        BagInterface<String> actualBag = rab1.intersection(rab1);

        // Test the array version of the bags for equality
        // assertArrayEquals(expectedBag.toArray(), actualBag.toArray());
        assertTrue(checkContains(actualBag, expectedBag)); 
    }

    // Helper function 
    /**
     * Will take all of the items in content and add them to the bag aBag. 
     * @param aBag    The bag we will be adding content to 
     * @param content The content we will add to the bag
     */
    public static void addContent(BagInterface<String> aBag, String[] content)
    {
        for (int index = 0; index < content.length; index ++)
        {
            aBag.add(content[index]);
        } // end for
    } // end addContent

    /**
     * Will check if all the items inside bag1 appear in bag2
     * @param <T> The data type of the BagInterface
     * @param bag1 The first bag we take in 
     * @param bag2 The second bag we take in
     * @return True if everything in bag1 appears in bag2, false otherwise 
     */
    public static <T> boolean checkContains(BagInterface<T> bag1, BagInterface<T> bag2)
    {
        // Check if all the items in bag2 appear in bag2
        T[] lettersInBag1 = (T[]) bag2.toArray();
        if (bag1.getCurrentSize() == bag2.getCurrentSize())
        {
            for (int index = 0; index < bag1.getCurrentSize(); index++)
            {
                if (!(bag2.contains(lettersInBag1[index])))
                {
                    return false;
                }
                
            }
        }
        else 
        {
            return false; 
        } // end if - else statement 
        return true; 
    }
}