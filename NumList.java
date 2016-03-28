/**
 * This abstract class is a parent class for list classes. Contains methods used for most lists.
 * @auther Joe Jensen
 * 
 */ 
import java.util.*;

public interface NumList<Double> extends Iterable<Double>
{
  /**
   * This method returns the size or length of the NumArrayList sequence.
   * @return int returns the size or length of the NumArrayList sequence.
   */ 
  public int size();
 
  /**
  * This method inserts a value into the sequence at a specified index with a specified value.
  * @param int is the index at which the user intends to add value
  * @param double is the value the user wishes to insert.
  */  
  public void insert(int i, double value);
 
  /**
   * This method remvoes a value from the sequence at index i.
   * @param int is the index of the value the user wishes to remove from the sequence.
   */ 
  public void remove(int i);
  
  /**
   * This method returns the value from the array at a given index.
   * @param int is the index of the value the user wishes to look up.
   * @return double returns the value from the sequence at the specified index.
   */ 
  public double lookup(int i);
  
  /**
   * This method creates an iterator to iterate through the sequence.
   * @return Iterator this return is an iterator used to iterate through the sequence.
   */  
  public Iterator<Double> iterator();
}
