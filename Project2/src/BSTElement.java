/**
* Project #2: Binary Search Tree Experiment
* File: BSTElement.java
* Programmers: David Kopp
* Date: 11/1/13
* Description: This file creates the generic type BSTElement and implements the Comparable interface in the java library.
**/

public class BSTElement implements Comparable<BSTElement> {
   private Integer key;

// constructor with parameters that also sets
   public BSTElement(int aKey) {
      key = new Integer(aKey); 
   }

// get methods
   public Integer get() {
      return key;
   }

// Override for compareTo// 
   public int compareTo(BSTElement other) {
      if (key < other.get()) {
         return -1;
      }
      
      else if (key > other.get()) {
         return 1;
      }
      
      else {
         return 0;
      }
   }

   public String toString() {
      return "" + key;
   }
}