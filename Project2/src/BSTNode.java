/**
* Project #2: Binary Search Tree Experiment
* File: BinaryTree.java
* Programmers: David Kopp
* Date: 11/1/13
* Description: This file creates the nodes for the binary tree and has get and set methods for its children. 
**/

public class BSTNode<BSTElement extends Comparable<BSTElement>> {
   private BSTElement element;
   private BSTNode<BSTElement> left, right;

// constructor with parameters
   public BSTNode(BSTElement e) {
      element = e;
      right = null;
      left = null;
   }

// override for compareTo
   public int compareTo(BSTNode<BSTElement> other) {
      return element.compareTo(other.getE());
   }

// get methods
   public BSTElement getE() {
      return element; 
   }

   public BSTNode<BSTElement> getLeft() {
      return left;
   }

   public BSTNode<BSTElement> getRight() {
      return right;
   }

// set methods
   public void setElement(BSTElement e) {
      element = e;
   }
 
   public void setLeft(BSTNode<BSTElement> newLeft) {
      left = newLeft;
   }

   public void setRight(BSTNode<BSTElement> newRight) {
      right = newRight;
   }
}