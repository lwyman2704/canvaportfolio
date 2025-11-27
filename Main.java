
/**
 * This is a sample {@code Main} class that will be used to
 * test the {@code IntegerList} class. You are free to modify
 * this source code to extensively test your implementation.
 * No need to submit this file.
 *
 * @author Lorenzo Wyman
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        // declare a reference variable
        IntegerList myList;
        // instantiate a list with capacity of 5
        myList = new IntegerList(5);
        
        // print the capacity
        System.out.println(myList.getCapacity());
        
        // print the list
        myList.display();
        
        // print the size
        System.out.println(myList.getSize());
        
        // insert 5 integers
        myList.addElement(10);
        myList.addElement(20);
        myList.addElement(30);
        myList.addElement(40);
        myList.addElement(50);
        IntegerList duplicateList = myList.duplicate(); // instantiate a list with capacity of 5
        // print the list
        myList.display();
        
        // add another element
        myList.addElement(60);
        
        // print the list
        myList.display();

        // print the size
        System.out.println(myList.getSize());
        System.out.println("duplicate list: " );
        duplicateList.display();
        
        System.out.println("isequal: " + myList.isEqual(duplicateList)); // should return true
        // print the capacity
        System.out.println(myList.getCapacity() );

        myList.setElementAt(2,65 );
        myList.display(); // should display the list with 65 at index 2

        System.out.println("calculated avg: " + myList.getAverage());
        System.out.println("element at index: " + myList.getElementAt(2)); // should throw an exception
        System.out.println("element at list: " + myList.getElementAt(3));

        myList.reverse();
        myList.display(); // should display the list in reverse order

        myList.clear();
        myList.display(); // should be empty

        System.out.println(myList.isEmpty());
       
    }   

}