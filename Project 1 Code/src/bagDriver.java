//import org.hamcrest.SelfDescribing;

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
        System.out.println("Union method testing for linked bags: ");
        // linkedBag1 and linkedBag2
        System.out.print("linkedBag1: ");
        displayBag(linkedBag1);
        System.out.print("\nlinkedBag2: ");
        displayBag(linkedBag2);
        System.out.println("\nThe union of linked bag 1 and linked bag 2 is: ");
        linkedBag5 = linkedBag1.union(linkedBag1);
        displayBag(linkedBag5); //Expected output = "A", "Y", "A", "C", "d", "A", "A", "Y", "A", "C", "d", "A"
        System.out.println();

        System.out.println("The union of linked bag 2 and linked bag 1 is: ");
        linkedBag5 = linkedBag1.union(linkedBag2);
        displayBag(linkedBag5); //Expected output = "B", "Y", "D", "A", "A", "A", "Y", "A", "C", "d", "A"
        System.out.println();

        // linkedBag1 and linkedBag3
        System.out.print("linkedBag1: ");
        displayBag(linkedBag1);
        System.out.print("\nlinkedBag3 (empty bag): ");
        displayBag(linkedBag3);
        System.out.println("The union of linked bag 1 and linked bag 3 is: ");
        linkedBag5 = linkedBag1.union(linkedBag3);
        displayBag(linkedBag5); //Expected output = "A", "Y", "A", "C", "d", "A"

        // linkedBag1 and linkedBag4
        System.out.print("linkedBag1: ");
        displayBag(linkedBag1);
        System.out.print("\nlinkedBag4: ");
        displayBag(linkedBag4);
        System.out.println("The union of linked bag 1 and linked bag 4 is: ");
        linkedBag5 = linkedBag1.union(linkedBag4);
        displayBag(linkedBag5); //Expected output = " ", "S", "A", "A", "Y", "A", "C", "d", "A"

        System.out.println("-------------------------------------------------------------------------------------------------------------");

        System.out.println("Union testing for resizable bags");
        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        // System.out.print("\nresizableArrayBag1: ");
        // displayBag(linkedBag3);
        System.out.println("The union of resizable bag 1 to itself is: ");
        resizableBag5 = resizableBag1.union(resizableBag1);
        displayBag(resizableBag5); //Expected output = "A", "Y", "A", "C", "d", "A", "A", "Y", "A", "C", "d", "A"
        System.out.println();
        
        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        System.out.print("\nresizableArrayBag2: ");
        displayBag(resizableBag2);
        System.out.println("The union of resizable bag 1 and resizable bag 2 is: ");
        resizableBag5 = resizableBag1.union(resizableBag2);
        displayBag(resizableBag5); //Expected output = "A", "Y", "A", "C", "d", "A", "B", "Y", "D", "A", "A"
        System.out.println();
        
        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        System.out.print("\nresizableArrayBag3: ");
        displayBag(resizableBag3);
        System.out.println("The union of resizable bag 1 and resizable bag 3 is: ");
        resizableBag5 = resizableBag1.union(resizableBag3);
        displayBag(resizableBag5); //Expected output = "A", "Y", "A", "C", "d", "A"
        System.out.println();
        
        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        System.out.print("\nresizableArrayBag4: ");
        displayBag(resizableBag4);
        System.out.println("The union of resizable bag 1 and resizable bag 4 is: ");
        resizableBag5 = resizableBag1.union(resizableBag4);
        displayBag(resizableBag5); //Expected output = "A", "Y", "A", "C", "d", "A", " ", "S", "A"
        System.out.println();

        System.out.println("-------------------------------------------------------------------------------------------------------------");

        System.out.println("Let's check to see if interoperability is satisfied by unioning a resizable array bag with a linked bag: ");
        System.out.print("Resizable Arrag Bag: ");
        displayBag(resizableBag1);
        System.out.print("\nLinked Bag: ");
        displayBag(linkedBag2);
        
        System.out.print("\nResult of resizableBag1.union(linkedBag2): ");
        displayBag(resizableBag1.union(linkedBag2)); 
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        
        //Here we will begin testing the intersection method

        System.out.println("Intersection testing for linked bags");
        System.out.print("linkedBag1: ");
        displayBag(linkedBag1);
        System.out.println("The intersection of linked bag 1 to itself : ");
        linkedBag5 = linkedBag1.intersection(linkedBag1);
        displayBag(linkedBag5); //Expected output = "Y", "C", "d", "A", "A", "A"
        System.out.println();
        
        System.out.print("linkedBag1: ");
        displayBag(linkedBag1);
        System.out.print("\nlinkedBag2: ");
        displayBag(linkedBag2);
        System.out.println("The intersection of linked bag 1 and linked bag 2 is: ");
        linkedBag5 = linkedBag1.intersection(linkedBag2);
        displayBag(linkedBag5); //Expected output = "Y", "A", "A"
        System.out.println();

        System.out.print("linkedBag1: ");
        displayBag(linkedBag1);
        System.out.print("\nlinkedBag3: ");
        displayBag(linkedBag3);
        System.out.println("The intersection of linked bag 1 and linked bag 3 is: ");
        linkedBag5 = linkedBag1.intersection(linkedBag3);
        displayBag(linkedBag5); //Expected output = nothing
        System.out.println();

        System.out.print("linkedBag1: ");
        displayBag(linkedBag1);
        System.out.print("\nlinkedBag4: ");
        displayBag(linkedBag4);
        System.out.println("The intersection of linked bag 1 and linked bag 4 is: ");
        linkedBag5 = linkedBag1.intersection(linkedBag4);
        displayBag(linkedBag5); //Expected output = "A"
        System.out.println();

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        
        System.out.println("Intersection testing for resizable bags");

        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        // System.out.print("\nresizableArrayBag1: ");
        // displayBag(resizableBag4);
        System.out.println("The intersection of resizable bag 1 and itself: ");
        resizableBag5 = resizableBag1.intersection(resizableBag1);
        displayBag(resizableBag5); //Expected output = "A", "Y", "A", "C", "d", "A"
        
        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        System.out.print("\nresizableArrayBag2: ");
        displayBag(resizableBag2);
        System.out.println("The intersection of resizable bag 1 and resizable bag 2 is: ");
        resizableBag5 = resizableBag1.intersection(resizableBag2);
        displayBag(resizableBag5); //Expected output = "A", "A", "Y"
        
        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        System.out.print("\nresizableArrayBag3: ");
        displayBag(resizableBag3);
        System.out.println("The intersection of resizable bag 1 and resizable bag 3 is: ");
        resizableBag5 = resizableBag1.intersection(resizableBag3);
        displayBag(resizableBag5); //Expected output = nothing
        
        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        System.out.print("\nresizableArrayBag4: ");
        displayBag(resizableBag4);
        System.out.println("The intersection of resizable bag 1 and resizable bag 4 is: ");
        resizableBag5 = resizableBag1.intersection(resizableBag4);
        displayBag(resizableBag5); //Expected output = "A"
        
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        System.out.println("Let's check to see if interoperability is satisfied by intersecting a resizable array bag with a linked bag: ");
        System.out.print("Resizable Arrag Bag: ");
        displayBag(resizableBag1);
        System.out.print("\nLinked Bag: ");
        displayBag(linkedBag2);

        System.out.print("\nResult of resizableBag1.union(linkedBag2): ");
        displayBag(resizableBag1.intersection(linkedBag2));

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        
        // Here we will begin testing the difference method
        System.out.println("Difference testing for linked bags");

        System.out.print("linkedBag1: ");
        displayBag(linkedBag1);
        // System.out.print("\nlinkedBag1: ");
        // displayBag(linkedBag4);
        System.out.println("The difference of linked bag 1 and itself: ");
        linkedBag5 = linkedBag1.difference(linkedBag1);
        displayBag(linkedBag5); //Expected output = {}
        System.out.println();

        System.out.print("linkedBag1: ");
        displayBag(linkedBag1);
        System.out.print("\nlinkedBag2: ");
        displayBag(linkedBag2);
        System.out.println("The difference of linked bag 1 and linked bag 2 is: ");
        linkedBag5 = linkedBag1.difference(linkedBag2);
        displayBag(linkedBag5); //Expected output = "Y". "C", "d", "A", "A", "A"
        System.out.println();

        
        System.out.print("linkedBag1: ");
        displayBag(linkedBag1);
        System.out.print("\nlinkedBag3: ");
        displayBag(linkedBag3);
        System.out.println("The difference of linked bag 1 and linked bag 3 is: ");
        linkedBag5 = linkedBag1.difference(linkedBag3);
        displayBag(linkedBag5); //Expected output = Nothing
        System.out.println();

        System.out.print("linkedBag1: ");
        displayBag(linkedBag1);
        System.out.print("\nlinkedBag4: ");
        displayBag(linkedBag4);
        System.out.println("The difference of linked bag 1 and linked bag 4 is: ");
        linkedBag5 = linkedBag1.difference(linkedBag4);
        displayBag(linkedBag5); //Expected output = "Y", "C", "d", "A", "A"
        System.out.println();

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        
        System.out.println("Difference testing for resizable bags");

        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        // System.out.print("\nresizableArrayBag4: ");
        // displayBag(resizableBag4);
        System.out.println("The difference of resizable bag 1 and itself: ");
        resizableBag5 = resizableBag1.difference(resizableBag1);
        displayBag(resizableBag5); //Expected output = "C", "d", "A"
        System.out.println();
        
        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        System.out.print("\nresizableArrayBag2: ");
        displayBag(resizableBag2);
        System.out.println("The difference of resizable bag 1 and resizable bag 2 is: ");
        resizableBag5 = resizableBag1.difference(resizableBag2);
        displayBag(resizableBag5); //Expected output = "A". "Y", "A", "C", "d", "A"
        System.out.println();
        
        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        System.out.print("\nresizableArrayBag3: ");
        displayBag(resizableBag3);
        System.out.println("The difference of resizable bag 1 and resizable bag 3 is: ");
        resizableBag5 = resizableBag1.difference(resizableBag3);
        displayBag(resizableBag5); //Expected output = Nothing
        System.out.println();
        
        System.out.print("resizableArrayBag1: ");
        displayBag(resizableBag1);
        System.out.print("\nresizableArrayBag4: ");
        displayBag(resizableBag4);
        System.out.println("The difference of resizable bag 1 and resizable bag 4 is: ");
        resizableBag5 = resizableBag1.difference(resizableBag4);
        displayBag(resizableBag5); //Expected output = "Y", "A", "C", "d", "A"

        System.out.println("-------------------------------------------------------------------------------------------------------------");

        System.out.println("Let's check to see if interoperability is satisfied by difference between a resizable array bag with a linked bag: ");
        System.out.print("Resizable Arrag Bag: ");
        displayBag(resizableBag1);
        System.out.print("\nLinked Bag: ");
        displayBag(linkedBag2);

        System.out.print("\nResult of resizableBag1.union(linkedBag2): ");
        displayBag(resizableBag1.difference(linkedBag2));

        System.out.println("-------------------------------------------------------------------------------------------------------------");




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
