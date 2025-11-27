/**
 * The {@code IntegerList} class implements a growable array of integers.
 * Like an array, it contains elements that can be accessed
 * using an integer index. However, the size of a IntegerList
 * can grow as needed to accommodate adding items
 * after the {@code IntegerList} has been created.
 *
 * @author Lorenzo Wyman
 * @version 1.0
 */

public class IntegerList { //constructs an empty list so that internal data array has capacity of 10

    private int arrayCapacity; //current capacity of the internal array
    private int elementCount; //number of currebt elements in integerlist object
    private int[] internalArray; //internal array where elements are stored

    public IntegerList(){

        this(10); //so we dont have to repeat the code in the next function

    }

    public IntegerList(int initialCapacity){ //constructor function that makes and empty list with specified initial capacity.
        
        this.arrayCapacity = initialCapacity; //set the initial capacity

        if (arrayCapacity < 1){ //ensure capacity is at least 1
            arrayCapacity = 1;
        }
        this.internalArray = new int[arrayCapacity];
        this.elementCount = 0  ; //initialize element count to 0

    }

    public void addElement(int newValue){ //adds value to end of list then increasing size by 1

        if (elementCount == arrayCapacity){
            
            int[]newArray = new int[arrayCapacity * 2]; //create a new array with double the capacity
            
            for (int i = 0; i < elementCount; i++){

                newArray[i] = internalArray[i]; //copy elements from the old array to the new array
                
            }
            internalArray = newArray; 
            arrayCapacity *= 2; //update the capacity

            internalArray[elementCount] = newValue; //add the new value to the end of the list
            elementCount++; // increment the element count

        } else {

            internalArray[elementCount++] = newValue; //add the new value to the end of the list

        }

    }

    public void clear(){ //removes all elements from the list, making it empty

        elementCount = 0; //reset element count to 0

    }

    public void display(){ //prints the elements in the list, separated by spaces

        if (elementCount == 0){

            System.out.println();
            return;

        }

        for (int i = 0; i < elementCount - 1; i++){

            System.out.print(internalArray[i] + " ");

        }

        System.out.println(internalArray[elementCount - 1]); //print and add /n after last charachter

    }

    public IntegerList duplicate(){ //returns new inteerlist instance containing same elements and capacity as list

        if (internalArray == null){
            return null; //there is nothing to duplicate
        }

        IntegerList duplicateList = new IntegerList(arrayCapacity); // create a new IntegerList with the same capacity

        for (int i = 0; i < elementCount; i++){

            duplicateList.addElement(internalArray[i]); //copy all elements from myList to duplicateList like in main.java given to us

        }

        return duplicateList; //return the new IntegerList instance

    }

    public int find(int value){ //returns the index of the first occurrence of value in the list, or -1 if not found

        if (internalArray == null || elementCount == 0){ //if the list is empty or null, return -1
            return -1;
        }

        for (int i = 0; i < elementCount; i++){

            if (internalArray[i] == value) { //if the current element matches the value

                return i; //return the index if the value was found
            }

        }

        return -1; //Return if the list does not contain the element

    }

    public double getAverage(){ //returns average

        if (elementCount == 0){
            return 0.0; //has to be double so 0.0
        }

        double realAverage = 0.0; //initialize realAverage to 0

        for (int i = 0; i < elementCount; i++){
    
            realAverage += internalArray[i]; //sum up all elements in the list
        }
        return realAverage / elementCount; 

    }

    public int getCapacity(){ //returns current capacity of list

        if (arrayCapacity == 0){
            return 0; //thats the default capacity
        }

        return arrayCapacity; //otherwise, return the current capacity of list

    }

    public int getElementAt(int index){ //access an element from the list given an index

        if(internalArray == null){
            return -1;
        }

        for (int i = 0; i < elementCount; i++){

            if (index < 0 || index >= elementCount){ //if the index is less than 0 or greater than the amount of elements, then return -1 for out of bounds
                //System.out.println("Index out of bounds: " + index + " :( ");
                return -1; //index is out of bounds

            }
        }
        
        return (internalArray[index]); //return the element at the specified index
    }

    public int getSize(){ //just returns the number of elements in the list

        return elementCount;

    }

    public boolean isEmpty(){ //check if list is empty

        if (this.elementCount == 0){ //if there are 0 elements then it returns true that the list is empty, otherwise it returns false

            return true;

        } 

        return false;
    }

    public boolean isEqual(IntegerList otherList){ //Compare with otherlist to see f theyre equal

        if (otherList == null || this.internalArray == null){ //if either list is null, they cannot be equal
            return false;
        }

       if (this.getSize() == otherList.getSize() && this.getCapacity() == otherList.getCapacity()){ //if the sizes & capacities of both lists are equal

            for (int i = 0; i < this.getSize(); i++){

                if (this.getCapacity() != otherList.getCapacity() || this.getElementAt(i) != otherList.getElementAt(i)){ //if the capacties or elements are not equal

                    return false; //if any element or capacity is different, return false
                }
            }

            return true; //return true only if all elements and capacities are equal in oth lists

        } else {

            return false; //return false as default if they are not the same
        }
    }

    public void reverse(){ //reverse order of list in place

        for (int i = 0; i < elementCount / 2; i++){ //swap elements from start and end like usual

            int temp = internalArray[i]; 

            internalArray[i] = internalArray[elementCount - 1 - i]; //swap with the corresponding element from the end
            internalArray[elementCount - 1 - i] = temp; 
        }   
    }

    public void setElementAt(int index, int newValue){ //replaces element at spot with another

        if (internalArray == null){
            //System.out.println("The list is empty!");
            return;
        }

        if (index < 0 || index >= elementCount){ //Split up error checking to make more clear
            //System.out.println("Index is out of bounds: " + index + " :( ");
            return;
        }

        internalArray[index] = newValue; //make that index of the previus value equal to newValue
    }

}