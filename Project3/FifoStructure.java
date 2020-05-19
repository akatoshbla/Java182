/**
* Project #3: A Curious or Hungry Robot
* File: FifoStructure.java
* Programmers: Roland Avdalyan, Heston Jayasinghe, David Kopp
* Date: 12/8/13
* Description: This class is the memory structure for the robot that uses a the Deque interface with a LinkedList(Acting like a queue) and implements the interface RobotMemory.java.                
**/

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;

public class FifoStructure<E extends Memory> implements RobotMemory<E> {

   private Deque<E> queue;

   // Construtor method
   public FifoStructure() {
      queue = new LinkedList<E>();
      
   }

   // Get method
   public E get(int index) {
      return queue.getFirst();
      
   }

   // Get method
   public int size() {
      return queue.size();
      
   }

   // This method removes memories(energy nodes) that have been depleted
   public void forget(E episode) {
      queue.removeFirst();
         
      if (queue.size()  > 0) {
         if (queue.peek().getEnergy().getEnergyLevel() == 0) {
            //System.out.println("Robo forgets energy source at: " + episode.getEnergy().getEnergyLocation() +  ", because it has an energy level of " + episode.getEnergy().getEnergyLevel() + ". Energy sources left in memory: " + queue.size());
            forget(episode);
            
         }
            
         else { }
         
      }
         
      else { }        
         
   }

   // This method adds memories(energy nodes) to the queue(Deque LinkList)
   public void learn(E episode) {
      if (episode.getEnergy().getEnergyLevel() > 0) {
         queue.addLast(episode);
         
      }
      
      //System.out.println("Robo learned about an energy node at: "  + episode.getEnergy().getEnergyLocation() +  ", and has an energy level of " + episode.getEnergy().getEnergyLevel() + ". Energy sources in memory: " + queue.size());
   
   }

   // Get method that returns the first memory(energy node, at the head of the Deque LinkedList) location that will be retrieved by the robot
   public Point retrieve(Point robotPosition) {
      if (queue.size() > 0) {
         return queue.getFirst().getEnergy().getEnergyLocation();
         
      }
      
      else {
         //System.out.println("Robo's memory is empty!");
         return robotPosition;
      
      }
   }
   
   // This method clears the queue(Deque LinkedList)
   public void wipe() {
      queue.clear();
   
   }
}