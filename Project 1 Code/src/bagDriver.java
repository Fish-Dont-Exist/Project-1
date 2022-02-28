/** Welcome! This class is here to showcase the methods union, intersection, and difference
    for a linked bag and a resizable array
 */

public class bagDriver
{
    public static void main(String[] args) throws NullPointerException
    {
        // Initializing bags
        BagInterface<String> linkedBag1 = new LinkedBag<>();
        BagInterface<String> linkedBag2 = new LinkedBag<>();
        BagInterface<String> linkedBag3 = new LinkedBag<>();
        BagInterface<String> linkedBag4 = new LinkedBag<>();
        BagInterface<String> linkedBag5 = new LinkedBag<>();
        BagInterface<String> resizableBag1 = new ResizableArrayBag<>();
        BagInterface<String> resizableBag2 = new ResizableArrayBag<>();
        BagInterface<String> resizableBag3 = new ResizableArrayBag<>();
        BagInterface<String> resizableBag4 = new ResizableArrayBag<>();
        BagInterface<String> resizableBag5 = new ResizableArrayBag<>();

        String[] contents1 = {"A", "Y", "A", "C", "d", "A"};
        String[] contents2 = {"B", "Y", "D", "A", "A"};
        String[] contents4 = {" ", "S", "A"};

        linkedBag1.add(contents1[0]);
        linkedBag1.add(contents1[1]);
        linkedBag1.add(contents1[2]);
        linkedBag1.add(contents1[3]);
        linkedBag1.add(contents1[4]);
        linkedBag1.add(contents1[5]);

        linkedBag2.add(contents2[0]);
        linkedBag2.add(contents2[1]);
        linkedBag2.add(contents2[2]);
        linkedBag2.add(contents2[3]);
        linkedBag2.add(contents2[4]);

        linkedBag4.add(contents4[0]);
        linkedBag4.add(contents4[1]);
        linkedBag4.add(contents4[2]);

        resizableBag1.add(contents1[0]);
        resizableBag1.add(contents1[1]);
        resizableBag1.add(contents1[2]);
        resizableBag1.add(contents1[3]);
        resizableBag1.add(contents1[4]);
        resizableBag1.add(contents1[5]);

        resizableBag2.add(contents2[0]);
        resizableBag2.add(contents2[1]);
        resizableBag2.add(contents2[2]);
        resizableBag2.add(contents2[3]);
        resizableBag2.add(contents2[4]);

        resizableBag4.add(contents4[0]);
        resizableBag4.add(contents4[1]);
        resizableBag4.add(contents4[2]);

        /*
            Here we will begin testing out the three methods
         */

        // Here we shall test out the union method

        System.out.println("Union method testing for linked bags");
        linkedBag5 = linkedBag1.union(linkedBag1);
        displayBag(linkedBag5); //Expected output = "A", "Y", "A", "C", "d", "A", "A", "Y", "A", "C", "d", "A"
        linkedBag5 = linkedBag1.union(linkedBag2);
        displayBag(linkedBag5); //Expected output = "B", "Y", "D", "A", "A", "A", "Y", "A", "C", "d", "A"
        linkedBag5 = linkedBag1.union(linkedBag3);
        displayBag(linkedBag5); //Expected output = "A", "Y", "A", "C", "d", "A"
        linkedBag5 = linkedBag1.union(linkedBag4);
        displayBag(linkedBag5); //Expected output = " ", "S", "A", "A", "Y", "A", "C", "d", "A"

        System.out.println("Union testing for resizable bags");
        resizableBag5 = resizableBag1.union(resizableBag1);
        displayBag(resizableBag5); //Expected output = "A", "Y", "A", "C", "d", "A", "A", "Y", "A", "C", "d", "A"
        resizableBag5 = resizableBag1.union(resizableBag2);
        displayBag(resizableBag5); //Expected output = "A", "Y", "A", "C", "d", "A", "B", "Y", "D", "A", "A"
        resizableBag5 = resizableBag1.union(resizableBag3);
        displayBag(resizableBag5); //Expected output = "A", "Y", "A", "C", "d", "A"
        resizableBag5 = resizableBag1.union(resizableBag4);
        displayBag(resizableBag5); //Expected output = "A", "Y", "A", "C", "d", "A", " ", "S", "A"

        //Here we will begin testing the intersection method

        System.out.println("Intersection testing for linked bags");
        linkedBag5 = linkedBag1.intersection(linkedBag1);
        displayBag(linkedBag5); //Expected output = "Y", "C", "d", "A", "A", "A"
        linkedBag5 = linkedBag1.intersection(linkedBag2);
        displayBag(linkedBag5); //Expected output = "Y", "A", "A"
        linkedBag5 = linkedBag1.intersection(linkedBag3);
        displayBag(linkedBag5); //Expected output = nothing
        linkedBag5 = linkedBag1.intersection(linkedBag4);
        displayBag(linkedBag5); //Expected output = "A"

        System.out.println("Intersection testing for resizable bags");
        resizableBag5 = resizableBag1.intersection(resizableBag1);
        displayBag(resizableBag5); //Expected output = "A", "Y", "A", "C", "d", "A"
        resizableBag5 = resizableBag1.intersection(resizableBag2);
        displayBag(resizableBag5); //Expected output = "A", "A", "Y"
        resizableBag5 = resizableBag1.intersection(resizableBag3);
        displayBag(resizableBag5); //Expected output = nothing
        resizableBag5 = resizableBag1.intersection(resizableBag4);
        displayBag(resizableBag5); //Expected output = "A"

        // Here we will begin testing the difference method

        System.out.println("Difference testing for linked bags");
        linkedBag5 = linkedBag1.difference(linkedBag1);
        displayBag(linkedBag5); //Expected output = "C", "d", "A"
        linkedBag5 = linkedBag1.difference(linkedBag2);
        displayBag(linkedBag5); //Expected output = "Y". "C", "d", "A", "A", "A"
        linkedBag5 = linkedBag1.difference(linkedBag3);
        displayBag(linkedBag5); //Expected output = Nothing
        linkedBag5 = linkedBag1.difference(linkedBag4);
        displayBag(linkedBag5); //Expected output = "Y", "C", "d", "A", "A"

        System.out.println("Difference testing for resizable bags");
        resizableBag5 = resizableBag1.difference(resizableBag1);
        displayBag(resizableBag5); //Expected output = "C", "d", "A"
        resizableBag5 = resizableBag1.difference(resizableBag2);
        displayBag(resizableBag5); //Expected output = "A". "Y", "A", "C", "d", "A"
        resizableBag5 = resizableBag1.difference(resizableBag3);
        displayBag(resizableBag5); //Expected output = Nothing
        resizableBag5 = resizableBag1.difference(resizableBag4);
        displayBag(resizableBag5); //Expected output = "Y", "A", "C", "d", "A"




    }
    public static void displayBag(BagInterface<String> aBag)
    {
        Object[] bagArray = aBag.toArray();

        for (int index = 0; index < bagArray.length; index++)
        {
            System.out.print(bagArray[index] + " ");
        } // end for
        System.out.println("");
    }
}
