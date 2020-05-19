/**
* Project #3: A Curious or Hungry Robot
* File: ClosestFirstStructure.java
* Programmers: Roland Avdalyan, Heston Jayasinghe, David Kopp
* Date: 12/8/13
* Description: This class is the memory structure for the robot that uses a LinkedList and implements the interface RobotMemory.java.               
**/

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;
import java.util.Hashtable;

public class ClosestFirstStructure<E extends Memory> implements RobotMemory<E> {
   private LinkedList<E> list; 

   // Constructor
   public ClosestFirstStructure() {
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

   // Get method finds the closest memory(energy node) to the robot's position 
   private E findClosest(Point p) {      
      E closest = list.get(0);
      double shortestDistance = p.distance(closest.getEnergy().getEnergyLocation());
      
      for (int i = 1; i < list.size(); i++) {
         double tempDistance = p.distance(list.get(i).getEnergy().getEnergyLocation());
         
         if (tempDistance < shortestDistance) {
            shortestDistance = tempDistance;
            closest = list.get(i);
         }
         
         else { }
      }
      
      return closest;
   
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

   // Get method to return the closest memory's(energy node) location to the robot's position
   public Point retrieve(Point robotPosition) {
      if (list.size() > 0) {
         return findClosest(robotPosition).getEnergy().getEnergyLocation();
         
      }
      
      else {
         //System.out.println("Robo's memory is empty!");
         return robotPosition;
      
      }
   }  
   
   // This method clears the LinkedList (Can only be accessed through a private method in Robot.java)
   public void wipe() {
      list.clear();
   
   }
}