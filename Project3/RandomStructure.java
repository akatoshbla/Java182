/**
* Project #3: A Curious or Hungry Robot
* File: RandomStructure.java
* Programmers: Roland Avdalyan, Heston Jayasinghe, David Kopp
* Date: 12/8/13
* Description: This class is the memory structure for the robot that uses a LinkedList(Elements are Retrieved Randomly) and implements the interface RobotMemory.java.              
**/

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

public class RandomStructure<E extends Memory> implements RobotMemory<E> {

   private LinkedList<E> list;

   // Constructor method
   public RandomStructure() {
      list = new LinkedList<E>();
      
   }

   // Get method
   public E get(int index) {
      return list.get(index);
      
   }

   // Get method
   public int size() {
      return list.size();
      
   }
   
   // This method removes memories(energy nodes) that have been depleted
   public void forget(E episode) {
      for (int i = 0; i < list.size(); i++) {                    
         if (list.get(i).getEnergy().getEnergyLocation() == episode.getEnergy().getEnergyLocation()) {
            list.remove(i);  
            i--;
            
         }
            
         else { }
            
      }
            
      //System.out.println("Robo forgets energy source at: " + episode.getEnergy().getEnergyLocation() +  ", because it has an energy level of " + episode.getEnergy().getEnergyLevel() + ". Energy sources left in memory: " + list.size());
      
   }

   // This method adds memories(energy nodes) to the LinkedList
   public void learn(E episode) {
      if (episode.getEnergy().getEnergyLevel() > 0) {
         list.add(episode);
         
      }
   
      //System.out.println("Robo learned about an energy node at: "  + episode.getEnergy().getEnergyLocation() +  ", and has an energy level of " + episode.getEnergy().getEnergyLevel() + ". Energy sources in memory: " + list.size());
   
   }

   // Get method that returns a random memory's(energy node) location that will be retrieved by the robot
   public Point retrieve(Point robotPosition) {
      Random rng = new Random();
      
      if (list.size() > 0) {
         return list.get(rng.nextInt(list.size())).getEnergy().getEnergyLocation();
            
      }
      
      else {
         //System.out.println("Robo's memory is empty!");
         return robotPosition;
      
      }   
   }
   
   // This method clears the LinkedList
   public void wipe() {
      list.clear();
   
   }
}