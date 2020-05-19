/**
* Project #3: A Curious or Hungry Robot
* File: Memory.java
* Programmers: Roland Avdalyan, Heston Jayasinghe, David Kopp
* Date: 12/8/13
* Description: This class is the memory object that are created in the data structure of whatever memory structure the robot is using. 
*              It also has-a relationship with EnergyNode.java. 
**/

import java.awt.Point;

public class Memory {

   private EnergyNode energy;

   // Constructor for memory objects
   public Memory(EnergyNode aNode) {
      energy = aNode;
      
   }

   // Set method for a memory's energy level
   public int eatEnergy(int need) {
      if (need < energy.getEnergyLevel()) {
         energy.setEnergyLevel(energy.getEnergyLevel() - need);
         
      } 
      
      else {
         need = energy.getEnergyLevel();
         energy.setEnergyLevel(0);
         
      }
      
      //System.out.println("Robo retrieves memory successfully and moves to " + energy.getEnergyLocation() + ", and consumes " + need + " energy units.");
      return need;
         
   }

   // Get method for a energy node in the memory structure the robot is using
   public EnergyNode getEnergy() {
      return energy;
      
   }
}