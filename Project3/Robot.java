/**
* Project #3: A Curious or Hungry Robot
* File: Robot.java
* Programmers: Roland Avdalyan, Heston Jayasinghe, David Kopp
* Date: 12/8/13
* Description: This class is the robot object. The class has-a relationship with the RobotMemory.java interface.
**/

import java.awt.Point;
import java.util.Random;

public class Robot {  
   private RobotMemory<Memory> memoryStructure;
   private int robotEnergy;
   private Point robotPosition;
   private boolean energySourceWasDepleted;
   Random random = new Random();

   // Robot constructor
   public Robot(Point pos, int energy) {
      robotPosition = pos;
      robotEnergy = energy;
   
   }

   // Get method for MemoryStructure 
   public RobotMemory<Memory> getMemoryStructure() {
      return memoryStructure;
   }
   
   // Get method to get the robot's position
   public Point getPos() {
      return robotPosition;
   
   }

   // Get method to get the robot's energy level
   public int getEnergy() {
      return robotEnergy;
   
   }

   // Set method to set the robot's position
   public void setRobotPos(Point pos) {
      robotPosition = pos;
   
   }

   // Set method to set the robot's energy level
   public void setRobotEnergy(int energy) {
      robotEnergy = energy;
   
   }

   // This method allows the robot to use the specified memory structure
   public void memStructureLearn(int selectMemoryMode) {
      switch (selectMemoryMode) {
         case 1: memoryStructure = new ClosestFirstStructure<Memory>();             
            break;  
      
         case 2: memoryStructure = new RandomStructure<Memory>(); 
            break;
      
         case 3: memoryStructure = new FifoStructure<Memory>();
            break;
      
         case 4: memoryStructure = new LifoStructure<Memory>(); 
            break;
      
      }
   }

   // This method is the robot's curious mode and helps it move
   public Point curiousState(Point current) {
      int y = 0;
      int x = 0;      
      int moveSelector = random.nextInt(7);
      
      switch (moveSelector) {
         case 0: x = 0;
            y = 7;
            break; 
         case 1: x = 0;
            y = -7;
            break; 
         case 2: x = 7;
            y = 0;
            break; 
         case 3: x = -7;
            y = 0;
            break; 
         case 4: x = 7;
            y = -7;
            break; 
         case 5: x = -7;
            y = 7;
            break; 
         case 6: x = -7;
            y = -7;
            break; 
         case 7: x = 7;
            y = 7;
            break; 
      }
      
      Point move = new Point((int)current.getX() + x, (int)current.getY() + y);
      
      return move;
   
   }

   // This method allows the robot to retrieve a memory and eat, when it is hungry
   public Point hungryStateMove(Point pos, double prob) {
      Random random = new Random();
      if (random.nextDouble() * 100 <= prob) {
         return memoryStructure.retrieve(pos);
      }
      else {
         //System.out.println("Robo failed to retrieve an energy source from memory!");
         return pos;
      }
   }
   
   // This method returns the new energy amount after eating energy and also forgets the memory if its energy is zero
   public int hungryStateEat(Point pos, int robotEnergy) {
      energySourceWasDepleted = false;
      
      int temp = memoryAtLocation(pos).eatEnergy(100 - robotEnergy);
      
      if (memoryAtLocation(pos).getEnergy().getEnergyLevel() == 0) {
         memoryStructure.forget(memoryAtLocation(pos));
         energySourceWasDepleted = true;
         
      }
         
      return temp;
      
   }
   
   // This method allows access to the data structure that corresponds to the memory structure being used
   private Memory memoryAtLocation(Point pos) {
      Memory temp = memoryStructure.get(0);
      for (int i = 1; i < memoryStructure.size(); i++) {
         if (memoryStructure.get(i).getEnergy().getEnergyLocation() == pos)
            temp = memoryStructure.get(i);
            
      }
   
      return temp;
   
   }

   // The inactive state method
   public void inactiveState(double dist, int step) {
      wipeLists();
      //System.out.println("<Inactive> Step " + step + ": The robot has no more energy and is inactive and traveled " + dist);
   
   }
   
   // This method clears the memory structure being used
   private void wipeLists() {
      memoryStructure.wipe();
   
   }
   
   // This method is used to tell if an energy score was deleted from the robots memory
   public boolean isSourceEmpty() {
      return energySourceWasDepleted;
   
   } 
}