/**
* Project #2: Binary Search Tree Experiment
* File: BinaryTree.java
* Programmers: David Kopp
* Date: 11/1/13
* Description: This program reads a text file and creates a collection(array data-structure) of unknown type by using the new command, while also calling the 
*					a shape or text object's constructors. Then after the objects are created and placed into the array an iterator is used to traverse 
*					the array and to call the objects draw methods associated with each object's class.
**/

import java.util.*;

public class Project2 {

// Project2 constructor
   public Project2(int totalSize, int builds) {
   
   // Construction of array with sorted values 1 through size
      int[] elements = new int[totalSize];
      int j = 1;
      for (int i = 0; i < totalSize; i++) {
         elements[i] = j;
         j++;
      }
   
   // Constructing the binary tree object 
      BSTree<BSTElement> testTree = new BSTree<BSTElement>();
   
   // Calls the method to do the simulation of the created binary tree
      simulate(totalSize, builds, testTree, elements);
   } 

// Public insert methods to populate a Balanced Tree
   public void fillTree(int[] array, BSTree<BSTElement> tree) {
      fillTree(0, (array.length - 1) / 2, array.length - 1, array, tree);
   }

// Private insert method	
   private void fillTree(int begin, int mid, int end, int[] array, BSTree<BSTElement> tree){
      tree.insert(new BSTElement(array[mid])); // Inserts the middle value for first and recursive calls
   
   // insert left sub-array
      if(mid - begin > 1) { // If left is not a leaf recursive call
         fillTree(begin, (begin + mid - 1)/2 , mid - 1, array, tree); 
      }
      
      // If left is a leaf insert
      else { 
         tree.insert(new BSTElement(array[begin]));
      }
   
   // Insert right sub-array
      if(end - mid > 1) { // if right is a not a leaf recursive call
         fillTree(mid + 1, (mid + 1 + end)/2, end, array, tree);
      }
      
      else {// If right is a leaf insert
         tree.insert(new BSTElement(array[end]));
      }
   }

// Insert method to populate a Random Tree
   private void fillRandomTree(int[] array, BSTree<BSTElement> tree) {
      for (int i = 0; i < array.length; i++) {
         tree.insert(new BSTElement(array[i]));
      }
   }

// Simulation method   
   public void simulate(int size, int sims, BSTree<BSTElement> tree, int[] array) {
      double aveLvlB = 0;
      int aveMaxLvlB = 0;
      double aveLvlBD = 0;
      int aveMaxLvlBD = 0;
      double aveLvlBDI = 0;
      int aveMaxLvlBDI = 0;
      double aveLvlR = 0;
      int aveMaxLvlR = 0;
      double aveLvlRD = 0;
      int aveMaxLvlRD = 0;
      double aveLvlRDI = 0;
      int aveMaxLvlRDI = 0;
   
      for (int i = 0; i < sims; i++) {
      // Balanced Tree
         fillTree(array, tree);
         aveLvlB += aveLevel(array.length, tree, array);
         aveMaxLvlB += maxLevel(tree, array);
      
      // Balanced Tree Half Delete
         shuffleArray(array);
         deleteHalf((array.length - 1) / 2, tree, array);
         aveLvlBD += aveLevel((array.length - 1) / 2, tree, array);
         aveMaxLvlBD += maxLevel(tree, array);
      
      // Balanced Tree Quarter Insert
         insertQuarter((array.length - 1) / 4, tree, array);
         aveLvlBDI += aveLevel((array.length - 1) / 4 + (array.length - 1) / 2, tree, array);
         aveMaxLvlBDI += maxLevel(tree, array);
      
      // Random Tree
         tree.makeEmpty();
         shuffleArray(array);
         fillRandomTree(array, tree);
         aveLvlR += aveLevel(array.length, tree, array);
         aveMaxLvlR += maxLevel(tree, array);
      
      // Random Tree Half Delete
         shuffleArray(array);
         deleteHalf((array.length - 1) / 2, tree, array);
         aveLvlRD += aveLevel((array.length - 1) / 2, tree, array);
         aveMaxLvlRD += maxLevel(tree, array);
      
      // Random Tree Quarter Insert
         insertQuarter((size - 1) / 4, tree, array);
         aveLvlRDI += aveLevel((array.length - 1) / 4 + (array.length - 1) / 2, tree, array);
         aveMaxLvlRDI += maxLevel(tree, array);
         tree.makeEmpty();
         selectionSort(array);
      }
   
   // Printout for the 12 dependent variables
      System.out.println("Balanced tree simulator with " + size + " nodes results: ");
      simResults(sims, aveLvlB, aveMaxLvlB);
      System.out.println("Balanced tree simulator with " + (size - 1) / 2 + " nodes after half deletion results: ");
      simResults(sims, aveLvlBD, aveMaxLvlBD);
      System.out.println("Balanced tree simulator with " + ((size - 1) / 4 + (size -1) / 2) + " nodes after half deletion and quarter inserts results: ");
      simResults(sims, aveLvlBDI, aveMaxLvlBDI);
   
      System.out.println("Random tree simulator with " + size + " nodes results: ");
      simResults(sims, aveLvlR, aveMaxLvlR);
      System.out.println("Random tree simulator with " + (size - 1) / 2 + " nodes after half deletion results: ");
      simResults(sims, aveLvlRD, aveMaxLvlRD);
      System.out.println("Random tree simulator with " + ((size - 1) / 4 + (size - 1) / 2) + " nodes after half deletion and quarter inserts results: ");
      simResults(sims, aveLvlRDI, aveMaxLvlRDI);
   }

// Simulation Results calculations method
   public void simResults(int sim, double aveLvlSum, int aveMaxLvlSum) {
      aveLvlSum = (int)(((aveLvlSum / sim) + 0.005) * 100);
      System.out.println("The average level over " + sim + " simulations: " + aveLvlSum / 100); 
      System.out.println("The average max level over " + sim + " simulations: " + aveMaxLvlSum / sim);
      System.out.println();
   }

// Delete Half the nodes
   private void deleteHalf(int half, BSTree<BSTElement> tree, int[] array) {
      for (int i = 0; i <= half; i++) {
         tree.delete(new BSTElement(array[i]));
      }
   }

// Insert Quarter of the nodes
   private void insertQuarter(int quarter, BSTree<BSTElement> tree, int[] array) {
      for (int i = 0; i <= quarter; i++) {
         tree.insert(new BSTElement(array[i]));
      }
   }

// Calculation of the average level of the tree
   public double aveLevel(int length, BSTree<BSTElement> tree, int[] array) {
      int[] lvls = new int[array.length];
      int sum = 0;
      double average = 0;
   
      for (int i = 0; i < array.length; i++) {
         lvls[i] = tree.findLevel(new BSTElement(array[i]));
         sum += lvls[i];
      } 
   
      return average = (double)sum / length;
   }

// Finds the max level of the tree
   public int maxLevel(BSTree<BSTElement> tree, int[] array) {
      int[] maxs = new int[array.length];
      int maxLvl = 0;
      for (int i = 0; i < array.length; i++) {
         maxs[i] = tree.findLevel(new BSTElement(array[i]));
         if (maxLvl < maxs[i]) {
            maxLvl = maxs[i];
         }
         
         else {
         }
      }
   
      return maxLvl;
   }

// Shuffles the array by swaping indexs
   private void shuffleArray(int[] array) {
      Random random = new Random();
      for (int i = 0; i < array.length; i++) {
         int shuffle = random.nextInt(array.length);
         int temp = array[i];
         array[i] = array[shuffle];
         array[shuffle] = temp;
      }
   }

// Selection sort for the array
   private void selectionSort(int[] array) {
      for (int i = 0; i < array.length - 1; i++) {
         int currentMin = array[i];
         int currentMinIndex = i;
      
         for (int j = i + 1; j < array.length; j++) {
            if (currentMin > array[j]) {
               currentMin = array[j];
               currentMinIndex = j;
            }
         }
         
         if (currentMinIndex != i) {
            array[currentMinIndex] = array[i];
            array[i] = currentMin;
         }
      }
   }

// Main Method that calls Project2 constructor
   public static void main(String[] args) { 
      Project2 bstree = new Project2(1023, 20);
   }
}