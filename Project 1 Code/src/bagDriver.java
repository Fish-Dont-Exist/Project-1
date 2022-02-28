/** Welcome! This class is here to showcase the methods union, intersection, and difference
    for a linked bag and a resizable array
 */

public class bagDriver
{
    public static void main(String args[]) throws NullPointerException
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
        String[] contents3 = {};
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

        // linkedBag3.add(contents3[0]); not sure how to implement this

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

        // resizableBag3.add(contents3[0]); same here

        resizableBag4.add(contents4[0]);
        resizableBag4.add(contents4[1]);
        resizableBag4.add(contents4[2]);

        /*
            Here we will begin testing out the three methods
         */
        // Here we shall test out the union method
        linkedBag5 = linkedBag1.union(linkedBag2);
        System.out.println(linkedBag5); //Expected output = "A", "Y", "A", "C", "d", "A", "B", "Y", "D", "A", "A"
        linkedBag5 = linkedBag1.union(linkedBag3); //Expected output = "A", "Y", "A", "C", "d", "A"
        System.out.println(linkedBag5);
        linkedBag5 = linkedBag1.union(linkedBag4); //Expected output = "A", "Y", "A", "C", "d", "A", " ", "S", "A"
        System.out.println(linkedBag5);
        resizableBag5 = resizableBag1.union(resizableBag2); //Expected output = "A", "Y", "A", "C", "d", "A", "B", "Y", "D", "A", "A"
        System.out.println(resizableBag5);
        resizableBag1.union(resizableBag3); //Expected output = "A", "Y", "A", "C", "d", "A"
        resizableBag1.union(resizableBag4); //Expected output = "A", "Y", "A", "C", "d", "A", " ", "S", "A"




    }
}
