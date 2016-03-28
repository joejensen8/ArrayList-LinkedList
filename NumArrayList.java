import java.util.*;
/**
 * This class is an extended class of NumList that creates a sequential list of doubles.
 * @auther Joe Jensen
 * 
 */
public class NumArrayList implements NumList
{
  /**
   * This integer type variable keeps track of the number of elements in the sequence.
   */ 
  private int listSize;
  
  /**
   * This double array stores all the elements in the num list.
   */ 
  private double [] numList; 
  
  /**
   * Initializes all of the NumArrayList fields.
   * Worst case running time: O(1).
   */ 
  public NumArrayList()
  {
    numList = new double[20]; 
    listSize=0;
  }
  
  /**
   * This method returns the size or length of the NumArrayList sequence.
   * @return int returns the size or length of the NumArrayList sequence.
   * Worst case running time: O(1)
   */ 
  public int size()
  {
    return listSize;
  }
  
  
 /**
  * This method inserts a value into the sequence at a specified index with a specified value.
  * @param int is the index of the value the user is looking to insert into the sequence.
  * @param double is the value the user wants to insert at index i.
  * Worst case running time: O(n).
  */ 
  public void insert(int i, double value)
  {
    if (i<0)
      throw new IllegalArgumentException("Index Out of Bounds");
    if (listSize >= numList.length) // dealing with resizing the array when it becomes full
    {
      double [] tmp = new double[listSize];
      for (int x=0;x<numList.length;x++) // copies elements into a tmp array
      {
        tmp[x]=numList[x];
      }
      this.numList = new double[(listSize)*2]; // resizes array to double the length
      if (i < listSize) // copies elements back into numList array while also adding element
      {
        for (int j=0; j<i;j++)
          numList[j] = tmp[j];
        numList[i] = value;
        for (int y=i+1; y<tmp.length+1; y++)
          numList[y] = tmp[y-1];
      }
      if (i >= listSize)
      {
        for (int j=0; j<tmp.length;j++)
          numList[j] = tmp[j];
        numList[listSize] = value;
      }
    }
    else if (i>=listSize) // if i parameter is larger than number of elements add to end of list
      numList[listSize]=value;
    else
    {
      for (int j=listSize;j>=i;j--){ // loop that moves all values in front of ith element one spot forward
        numList[j+1]=numList[j];
      }
      numList[i]=value; 
    }
    listSize++;
  }
  
  /**
   * This method remvoes a value from the sequence at index i.
   * @param int is the index of the item in the sequence the user intends to remove.
   * Worst case running time: O(n).
   */ 
  public void remove(int i)
  {
    if (i<0 || i>=listSize) 
      throw new IllegalArgumentException("Index Out of Bounds");
    if ((listSize * 3) < numList.length) //shrinks the array if sequence size *3 is less than array length
    {
      double [] tmp = new double[listSize];
      for (int x=0;x<listSize;x++) //copies elements from current array to tmp array
      {
        tmp[x]=numList[x];
      }
      int tempLength = numList.length/2;
      this.numList = new double[tempLength]; //resizes current array to half the orginial length
      for (int j=0; j<i;j++) //copies elements back skipping index i
        numList[j] = tmp[j];
      for (int y=i+1; y<tmp.length; y++)
        numList[y] = tmp[y];
    }
    for (int j=i;j<listSize;j++) // copy elements from ith element on one spot backwards
    {
      numList[j]=numList[j+1];
    }
    listSize--;
  }
  
  /**
   * This method returns the value from the array at a given index.
   * @param int is the index of the item in the sequence the user intends to look up.
   * @return double returns the value from the sequence at the specified index.
   * Worst case running time: O(1).
   */ 
  public double lookup(int i)
  {
    if (i<0 || i>=listSize)
      throw new IllegalArgumentException("Index Out of Bounds");
    return numList[i];
  }
  
  /**
   * This method creates an iterator to iterate through the sequence.
   * @return Iterator this return is an iterator used to iterate through the sequence.
   * Worst case running time: O(1).
   */ 
  public Iterator<Double> iterator()
  {
    return new Iterator<Double>()
    {
      /**
       * This field keeps track of the current spot in the sequence.
       */
      private int pointer = 0;
      
      /**
       * This method determines if the sequence has a next value.
       * @return boolean true if has next value false if there is no next value.
       * Worst case running time: O(1).
       */ 
      public boolean hasNext()
      {
        if(listSize == 0)
          return false;
        else
          return pointer < listSize;
      }
      
      /**
       * This method returns the current value and moves the pointer to the next value.
       * @return Double returns the current value.
       * Worst case running time: O(1).
       */ 
      public Double next()
      {
        Double temp = numList[pointer];
        pointer++;
        return temp;
      }
      
      /**
       * This method does nothing. This is not implemented.
       */ 
      public void remove(){}
    };
  }
}