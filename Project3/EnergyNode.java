/**
* Project #3: A Curious or Hungry Robot
* File: EnergyNode.java
* Programmers: Roland Avdalyan, Heston Jayasinghe, David Kopp
* Date: 12/8/13
* Description: This class is the energy node object that are created in the data structure of RobotSim. 
**/

import java.awt.Point;
import java.util.ArrayList;

public class EnergyNode {

   private Point energyLocation;
   private int energyLevel;

   // This is the objects constructor
   public EnergyNode(int x, int y, int eLvl) {
      setEnergyLocation(x, y);
      setEnergyLevel(eLvl);
   
   }

   // Set method for energyLevel
   public void setEnergyLevel(int eLvl) {
      energyLevel = eLvl;
   
   }
   
   // Get method for energyLevel
   public int getEnergyLevel() {
      return energyLevel;
   
   }

   // Get method for energyLocation
   public Point getEnergyLocation() {
      return energyLocation;
   
   }

   // Set method for energyLocation
   public void setEnergyLocation(int x, int y) {
      Point newPoint = new Point(x, y);
      energyLocation = newPoint;
   
   }

   // Set method for energyLocation an overload method
   public void setEnergyLocation(Point newPoint)  {
      energyLocation = newPoint;
   
   }

   // This is a override method for toString for debugging
   public String toString() {
      return "Energy Node at: " + energyLocation + ", Energy Level: " + energyLevel;
   
   }
}