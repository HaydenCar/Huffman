//package BinaryTrees;

public class TreeNode
{
  private int freq;
  private char symbol;
  private TreeNode leftChild;
  private TreeNode rightChild;

  public TreeNode(int f, char s)
  {
  // Initializes tree node with item and no children.
    freq = f;
    symbol = s;
    leftChild  = null;
    rightChild = null;
  }  // end constructor

  public TreeNode(int f, char s,
                  TreeNode left, TreeNode right)
                  {
  // Initializes tree node with item and
  // the left and right children references.
	freq = f;
	symbol = s;
    leftChild  = left;
    rightChild = right;
  }  // end constructor

  public int getFreq()
  {
  // Returns the item field.
    return freq;
  }  // end getItem

  public void setFreq(int f)
  {
  // Sets the item field to the new value newItem.
	  freq = f;
  }  // end setItem
  
  public char getSymbol()
  {
  // Returns the item field.
    return symbol;
  }  // end getItem

  public void setSymbol(char s)
  {
  // Sets the item field to the new value newItem.
	  symbol = s;
  }  // end setItem

  public TreeNode getLeft()
  {
  // Returns the reference to the left child.
    return leftChild;
  }  // end getLeft

  public void setLeft(TreeNode left)
  {
  // Sets the left child reference to left.
    leftChild  = left;
  }  // end setLeft

  public TreeNode getRight()
  {
  // Returns the reference to the right child.
    return rightChild;
  }  // end getRight

  public void setRight(TreeNode right)
  {
  // Sets the right child reference to right.
    rightChild  = right;
  }  // end setRight
}  // end TreeNode