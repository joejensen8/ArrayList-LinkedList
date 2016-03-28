import java.util.*;

/**
 * This class is a demo that tests the functionality of NumListArray and NumLinkedList
 * @auther Joe Jensen
 * 
 */ 
public class NumListDemo
{
  /**
   * This main method creates a NumArrayList and NumLinkedList, adds elements to each, and calls meanSequence.
   */ 
  public static void main (String Args[])
  {
    NumArrayList myArrayList = new NumArrayList();
    myArrayList.insert(0,4.0); 
    myArrayList.insert(1,8.0);
    myArrayList.insert(2,12.0);
    myArrayList.insert(3,6.0);
    myArrayList.insert(1,10.0);
    System.out.println("Mean myArrayList Value: " + meanSequence(myArrayList)); // Mean should be 8.0
    
    NumLinkedList myLinkedList = new NumLinkedList();
    myLinkedList.insert(0,4.0);
    myLinkedList.insert(1,8.0);
    myLinkedList.insert(2,12.0);
    myLinkedList.insert(3,6.0);
    myLinkedList.insert(1,10.0);
    System.out.println("Mean myLinkedList Value: " + meanSequence(myLinkedList)); // Mean should be 8.0
  }
  
  /**
   * This method calculates the average value of all numbers in the list.
   * @param NumList is a sequence of doubles we will find the average value of.
   * @return double returns the average value of all numbers in the list.
   * Worst case running time: O(n).
   */ 
  public static double meanSequence(NumList list)
  {
    Iterator<Double> myI = list.iterator();
    double sum=0.0;
    while(myI.hasNext())
      sum += myI.next().doubleValue();
    return Double.valueOf(sum / list.size());
  }
}