/**
* Project #2: Binary Search Tree Experiment
* File: BinaryTree.java
* Programmers: David Kopp
* Date: 11/1/13
* Description: This program reads a text file and creates a collection(array data-structure) of unknown type by using the new command, while also calling the 
*					a shape or text object's constructors. Then after the objects are created and placed into the array an iterator is used to traverse 
*					the array and to call the objects draw methods associated with each object's class.
**/

public class BSTree<BSTElement extends Comparable<BSTElement>> {
   private BSTNode<BSTElement> root;

// constructor of root = null
   public BSTree() {
      root = null;
   }

// public call to start the count of the levels of the tree.
   public int findLevel(BSTElement target) {
      if (root == null) {
         return 0;
      }
      
      else {
         return findLevel(root, 1, target);
      }
   }

// private call to count the levels of the tree.
   private int findLevel(BSTNode<BSTElement> current, int lvl, BSTElement target) {
      if (target.compareTo(current.getE()) == -1) {
         if (current.getLeft() == null) {
         //System.out.println("left error");
            return 0;
         }
         
         else {
            return findLevel(current.getLeft(), lvl + 1, target);
         }
      }
      
      else if (target.compareTo(current.getE()) == 1) {
         if (current.getRight() == null) {
         //System.out.println("Right Error");
            return 0;
         }
         
         else {
            return findLevel(current.getRight(), lvl + 1, target);
         }
      }
      else {
         return lvl;
      }
   }

// This section is used for visual purpose
   public void inOrder() {
      if (root == null) {
         System.out.println("The binary search tree is empty.");
      }
      
      else {
         inOrder(root, 1);
      }
   }

   private void inOrder(BSTNode<BSTElement> current, int lvl) {
      if (current.getLeft() != null) {
         inOrder(current.getLeft(), lvl +1);
      }
   
      System.out.println("Node: " + current.getE() + ", Level: " + lvl);
      if (current.getRight() != null) {
         inOrder(current.getRight(), lvl + 1);
      }
   
   }

// public method that calls the private insert method for insert cases
   public void insert(BSTElement newElement) {
      if (root == null) {
         root = new BSTNode<BSTElement>(newElement);
      }
      
      else {
         insert(root, newElement);
      }
   }

// Private method that inserts an element into the tree
   private void insert(BSTNode<BSTElement> current, BSTElement newElement) {
      if (newElement.compareTo(current.getE()) < 0) {
         if (current.getLeft() == null) {
            current.setLeft(new BSTNode<BSTElement>(newElement));
         }
         
         else {
            insert(current.getLeft(), newElement);
         }
      }
   
      if (newElement.compareTo(current.getE()) > 0) {
         if (current.getRight() == null) {
            current.setRight(new BSTNode<BSTElement>(newElement));
         }
         
         else {
            insert(current.getRight(), newElement);
         }
      }
   }

// Public method that calls private delete method for deletion cases	
   public void delete(BSTElement target) {
      if (root == null) {
         System.out.println("The binary search tree is already empty.");
      }
      
      else {
         root = delete(root, target);
      }
   }

// Private method that deletes target value in the tree
   private BSTNode<BSTElement> delete(BSTNode<BSTElement> current, BSTElement target) {
      if (target.compareTo(current.getE()) == -1) {
         if (current.getLeft() == null) {
         }
         
         else {
            current.setLeft(delete(current.getLeft(), target));
         }
      
         return current;
      }
      
      else if (target.compareTo(current.getE()) == 1) {
         if (current.getRight() == null) {
         }
         
         else {
            current.setRight(delete(current.getRight(), target));
         }
      
         return current;
      }
      
      else {
         BSTNode<BSTElement> left = current.getLeft();
         BSTNode<BSTElement> right = current.getRight();
         current.setLeft(null);
         current.setRight(null);
      
         if (left != null && right == null) {
            return left;
         }
         
         else if (left == null && right != null) {
            return right;
         }
         
         else if (left != null && right != null) {
            BSTNode<BSTElement> lastRight = mostRight(left);
            lastRight.setRight(right);
            return left;
         }
         
         else {
            return null;
         }
      }
   }

// This private method helps the private delete method to get the right most node
// for deletion case 7
   private BSTNode<BSTElement> mostRight(BSTNode<BSTElement> current) {
      if (current.getRight() != null) {
         return mostRight(current.getRight());
      }
      
      else {
         return current;
      }
   }

// Deletion method that deletes the entire tree
   protected void makeEmpty() {
      root = null;
   }
}