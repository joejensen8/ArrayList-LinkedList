/**
 * This class instantiates the Nodes used in the NumArrayList class
 * @auther Joe Jensen
 * 
 */

public class Node
{
  /**
   * This double value stores the value of the Node.
   */ 
  private double element;
  
  /**
   * This Node value is the reference to the next Node in the sequence.
   */ 
  private Node next;
  
  /**
   * This method instantiates all variables in the class.
   * Worst case running time: O(1).
   */ 
  public Node(double myElement, Node myNext)
  {
    element = myElement;
    next = myNext;
  }
  
  /**
   * This method returns the value of the current Node.
   * @return double the value of the current Node.
   * Worst case running time: O(1).
   */ 
  public double getValue()
  {
    return element;
  }
  
  /**
   * This method sets the reference of the current node to a new Node, myNode.
   * @param Node is the Node our current Node will refer to.
   * Worst case running time: O(1).
   */ 
  public void setNext(Node myNode)
  {
    next = myNode;
  }
  
  /**
   * This method returns the next Node in the sequence.
   * @return Node returns the next Node in the sequence.
   * Worst case running time: O(1)
   */ 
  public Node getNext()
  {
    return next;
  }
  
  
}
