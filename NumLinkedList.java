import java.util.*;
/**
 * This class is an extension of NumList using Linked Nodes to create a list of doubles.
 * @auther Joe Jensen
 * 
 */

public class NumLinkedList implements NumList
{
  /**
   * This variable stores the first Node in the sequence.
   */ 
  private Node head;
  
  /**
   * This variable stores the length or size of the sequence.
   */ 
  private int listSize;
  
  /**
   * Initializes all of the NumLinkedList fields.
   */ 
  public NumLinkedList()
  {
    listSize = 0;
  }
  
  /**
   * This method returns the length or size of the sequence.
   * @return int returns the length or size of the sequence.
   * Worst case running time: O(1).
   */ 
  public int size()
  {
    return listSize;
  }
  
  /**
   * This method inserts a specified double value into the sequence at a given index i.
   * @param int is the index the user wants value to be entered to.
   * @param double is the value the user wants inserted to the sequence.
   * Worst case running time: O(n).
   */ 
  public void insert(int i, double value) 
  {
     if (i<0)
       throw new IllegalArgumentException("Index Out of Bounds");
     if (listSize==0) // if there are no elements set head to the inserted value
     {
       head=new Node(value,null);
     }
     else if (i>=listSize)// if i parameter is larger than # elements add to end of list
     {
       Node head1=head;
       for (int x=0;x<listSize-1;x++)
       {
         head1 = head1.getNext();
       }
       head1.setNext(new Node(value,null));
     }
     else // else find index and add value where specified.
     {
       Node head2=head;
       for (int j=0;j<i-1;j++)
       {
         head2=head2.getNext();
       }
       head2.setNext(new Node(value,head2.getNext()));
     }
     listSize++;
  }
  
  /**
   * This method remvoes a value from the sequence at index i.
   * @param int is the index of the item in the sequence the user intends to remove.
   * Worst case running time: O(n).
   */ 
  public void remove(int i) // get rid of i=0 case? can't
  {
    if (i<0 || i>=listSize)
       throw new IllegalArgumentException("Index Out of Bounds");
    if (i==0) // if removing first element just increment head to point to the next value.
    {
      head = head.getNext();
    }
    else // else find Node before index and point to node after index.
    {
      Node head1=head;
      for (int j=0;j<i-1;j++)
      {
        head1=head1.getNext();
      }
      head1.setNext(head1.getNext().getNext());
    }
    listSize--;
  }
  
  /**
   * This method returns the value from the array at a given index.
   * @param int is the index of the item in the sequence the user intends to look up.
   * @return double returns the value from the sequence at the specified index.
   * Worst case running time: O(n).
   */ 
  public double lookup(int i) 
  {
    if (i<0 || i>=listSize)
       throw new IllegalArgumentException("Index Out of Bounds");
    Node head1=head;
    for (int j=0;j<i;j++) // loop to get to element i.
    {
      head1=head1.getNext();
    }
    return head1.getValue(); 
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
       * This field keeps track of the current Node.
       */ 
      private Node myHead = head;
      
      /**
       * This method determines if the sequence has a next value.
       * @return boolean true if has next value false if there is no next value.
       * Worst case running time: O(1).
       */ 
      public boolean hasNext()
      {
        if (listSize == 0)
          return false;
        else
          return myHead != null;
      }
      
      /**
       * This method returns the current value and moves the pointer to the next value.
       * @return Double returns the current value.
       * Worst case running time: O(1).
       */       
      public Double next()
      {
        Double temp = myHead.getValue();
        myHead = myHead.getNext();
        return temp;
      }
      
      /**
       * This method does nothing. This is not implemented.
       */       
      public void remove(){}
    };
  }
}