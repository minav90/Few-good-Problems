import java.util.*;


public class BinaryTree {

  public static void main(String[] args) {
    
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.right.left = new Node(7);
    root.left.right.right = new Node(6);
    root.left.left.left = new Node(10);
    root.left.left.right = new Node(11);
    root.right.right = new Node(8);
    root.right.left = new Node(15);
    root.right.left.left = new Node(9);
    //System.out.println(readBinaryTree(root));
    System.out.println(isComplete(root));
  }

  
  public static boolean isComplete(Node root)
  {
    
    Queue<Node> res = new LinkedList<Node>();
    res.add(root);
    boolean flag = false;
    while(!res.isEmpty())
    {
      Node temp = res.poll();
      if(temp.left != null)
      {
        if(flag)
          return false;
        res.add(temp.left);
      }
      else
        flag = true;
      
      if(temp.right != null)
      {
        if(flag)
          return false;
         res.add(temp.right);
      }
      else
        flag = true;
    }
    
    
    
    return flag;
    
  }
  
  
  
  
  
  
  
  
  private static String readBinaryTree(Node root) {

    String res = "";
    if(root == null)
      return "#";
    
    res += root.val;
    res += readBinaryTree(root.left);
    res += readBinaryTree(root.right);
    
    return res;
  }


  static class Node
  {
    int val;
    Node left;
    Node right;
    Node(int val)
    {
      this.val = val;
    }
  }
  
}


