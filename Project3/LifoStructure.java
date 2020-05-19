/**
* Project #3: A Curious or Hungry Robot
* File: LifoStructure.java
* Programmers: Roland Avdalyan, Heston Jayasinghe, David Kopp
* Date: 12/8/13
* Description: This class is the memory structure for the robot that uses a the Deque interface with a LinkedList(Acting like a stack) and implements the interface RobotMemory.java.                
**/

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;

public class LifoStructure<E extends Memory> implements RobotMemory<E> {

   private Deque<E> stack;

   // Constructor method
   public LifoStructure() {
      stack = new LinkedList<E>();
      
   }

   // Get method
   public E get(int index) {
      return stack.getFirst();
      
   }

   // Get method
   public int size() {
      return stack.size();
      
   }

   // This method removes memories(energy nodes) that have been depleted
   public void forget(E episode) {
      stack.removeFirst();
         
      if (stack.size()  > 0) {
         if (stack.peek().getEnergy().getEnergyLevel() == 0) {
            //System.out.println("Robo forgets energy source at: " + episode.getEnergy().getEnergyLocation() +  ", because it has an energy level of " + episode.getEnergy().getEnergyLevel() + ". Energy sources left in memory: " + stack.size());
            forget(episode);
            
         }
            
         else { }
         
      }
         
      else { }        
         
   }

   // This method adds memories(energy nodes) to the stack(Deque LinkList)
   public void learn(E episode) {
      if (episode.getEnergy().getEnergyLevel() > 0) {
         stack.addFirst(episode);
         
      }
   
      //System.out.println("Robo learned about an energy node at: "  + episode.getEnergy().getEnergyLocation() +  ", and has an energy level of " + episode.getEnergy().getEnergyLevel() + ". Energy sources in memory: " + stack.size());
   
   }

   // Get method that returns the first memory(energy node, at the head of the Deque LinkedList) location that will be retrieved by the robot
   public Point retrieve(Point robotPosition) {
      if (stack.size() > 0) {
         return stack.getFirst().getEnergy().getEnergyLocation();
      
      }
      
      else {
         //System.out.println("Robo's memory is empty!");
         return robotPosition;      
         
      }
   }  
   
   // This method clears the stack(Deque LinkedList)
   public void wipe() {
      stack.clear();
   
   }
}