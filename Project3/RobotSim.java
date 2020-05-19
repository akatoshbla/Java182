/**
* Project #3: A Curious or Hungry Robot
* File: RobotSim.java
* Programmers: Roland Avdalyan, Heston Jayasinghe, David Kopp
* Date: 12/8/13
* Description: This class contains the main method for Project 3. It creates and runs the robot simulation and returns an ave total distance travelled by the robot.
**/

import java.util.ArrayList;
import java.util.Random;
import java.awt.Point;

public class RobotSim {
   private ArrayList<EnergyNode> eList = new ArrayList<EnergyNode>();
   Random random = new Random();
   private Point movePoint;
   int step = 0;
   private boolean roboHasEnergy = true;
   private double aveDistance = 0;
   private double sumDistance = 0;

   // This is the simulator constructor
   public RobotSim(int numberNodes, int nodeEnergy, int roboEnergy, int prob, int runs) {
      System.out.println("Memory mode 1 = Closest First, Memory mode 2 = Random, Memory mode 3 = Fifo, Memory mode 4 = Lifo");
      Point roboCurrent = new Point(1,1);
      Robot robo = new Robot(roboCurrent, roboEnergy);
      
      // Selection of the memory structure for the robot to use.
      for (int s = 1; s <= 4; s++) {
      
         // This loop is for the number of times the simulation will run.
         for (int r = 0; r < runs; r++) { 
            double totalDistance = 0;
            
            // Creation of the energy sources
            while (eList.size() < numberNodes) {
               addEnergyNode(nodeEnergy);
            
            }
         
            // Creation of the robot
            robo.setRobotPos(new Point(random.nextInt(200), random.nextInt(200)));
            robo.setRobotEnergy(100);
            roboHasEnergy = true;
            // System.out.println("<Start> Robot's Position: " + robo.getPos() + ", Robot's Energy: " + robo.getEnergy());
         
            // This calls the selection of which data structure the robot is going to use.
            robo.memStructureLearn(s);
         
            // This loop figures out if the robot has energy to move and which mode is it in. (Curious, Hungry, or Inactive)
            while (roboHasEnergy == true) {
            
               // Curious Mode
               if (robo.getEnergy() > 50) {
                  movePoint = moveIt(robo, roboCurrent);
                  while (roboCurrent == movePoint) {
                     movePoint = moveIt(robo, roboCurrent);
                  
                  }
               
                  // Distance sum and updating the robot variables.
                  totalDistance += distTraveled(roboCurrent, movePoint);
                  robo.setRobotEnergy(robo.getEnergy() - (int)distTraveled(roboCurrent, movePoint));
                  robo.setRobotPos(movePoint);
                  roboCurrent = movePoint;
                  
                  // Step and the println are for debugging purposes.
                  // step += 1;
                  //System.out.println("<Curious> Step " + step + ": Robot's Position: " + robo.getPos() + ", Robot's Energy: " + robo.getEnergy());
                  
                  // This call is for detecting nodes near the robot.
                  detectEnergy(robo, roboCurrent);
               
               }
               
               // Hungry Mode
               else if (robo.getEnergy() <= 50 && robo.getEnergy() >= 0) {
               
                  // Probability to retrieve a memory check
                  movePoint = robo.hungryStateMove(roboCurrent, prob);
               
                  // Robot moves if the check passes
                  if (movePoint != roboCurrent) {
                     
                     // Step and the println are for debugging purposes.
                     // step += 1;
                     // System.out.println("<Hungry> Step " + step + ": Robot's Position: " + robo.getPos() + ", Robot's Energy: " + robo.getEnergy() + " (Recharging)");  
                     
                     // Updating robot energy based on travel and how much it consumed. (It is assumed here that the robot was successful in its memory retrieval. 
                     robo.setRobotEnergy(robo.getEnergy() - (int)distTraveled(roboCurrent, movePoint) + robo.hungryStateEat(movePoint, robo.getEnergy()));
                     
                     // Debugging println
                     // System.out.println("Robo used " + (int)distTraveled(roboCurrent, movePoint) + " energy to travel to the energy source.");
                  
                     // Lines 93 - 99 removes a energy source from the grid if its energy level is 0.
                     if (robo.isSourceEmpty() == true) {
                        for (int i = 0; i < eList.size(); i++) {
                           if (eList.get(i).getEnergyLocation() == movePoint) {
                           // System.out.print("System Message: Energy source at " + eList.get(i).getEnergyLocation() + " was removed because it was depleted. ");
                              eList.remove(i);
                              // System.out.print("Energy sources left: " + eList.size());
                              // System.out.println();
                           
                           }
                        } 
                     }                        
                  }
                  
                  // Robot fails to retrieve a memory
                  else {
                  
                     // Creation of a new step
                     movePoint = moveIt(robo, roboCurrent);
                  
                     while (roboCurrent == movePoint) {
                        movePoint = moveIt(robo, roboCurrent);
                     
                     }   
                  
                     robo.setRobotEnergy(robo.getEnergy() - (int)distTraveled(roboCurrent, movePoint));
                     // step += 1;                  
                     // System.out.println("<Failed Hungry - Curious Move> Step " + step + ": Robot's Position: " + robo.getPos() + ", Robot's Energy: " + robo.getEnergy());
                     detectEnergy(robo, movePoint);
                                        
                  }
                      
                  totalDistance += distTraveled(roboCurrent, movePoint);
                  robo.setRobotPos(movePoint);
                  roboCurrent = movePoint;
               
               }
               
               // Inactive Mode
               else {
                  roboHasEnergy = false;
                  step += 1;
                  robo.inactiveState(totalDistance, step);  
                  
                  // This calls a method to clear the grid list of energy sources.
                  eList.clear();
               
               }                                    
            }
            
            // aveDistance is a running sum of the total distance the robot traveled through one simulation.                             
            sumDistance += totalDistance;
             
         }           
         
         // Average of the total distance traveled by the robot for each memory mode.                                                                 
         aveDistance = sumDistance / runs;
         aveDistance = (int)((aveDistance + .00005) * 1000);
         System.out.println("The average distance over " + runs + " was " +  (aveDistance / 1000) + ". In memory mode: " + s + " and with a memory retrieval probability of " + prob + "%.");
      
      } 
      
      System.out.println();
                            
   }

   // This method is for moving the robot.
   public Point moveIt(Robot robo, Point current) {
      Point move = robo.curiousState(current);
      
      while (move.getX() > 200 || move.getY() > 200 || move.getX() < 0 || move.getY() < 0) {
         move = robo.curiousState(current);
               
      }
      
      return move;
      
   }

   // This method searches the grid list of energy sources and calls the learn method in the memory structure being used.
   public void detectEnergy(Robot aRobot, Point current) {
      for (int i = 0; i < eList.size(); i++) {
         if (current.distance(eList.get(i).getEnergyLocation()) <= 15) {
            aRobot.getMemoryStructure().learn(new Memory(eList.get(i)));
         
         }
         
         else { } // do nothing
      
      }
   }
   
   // This method is used to help calculate distances
   public double distTraveled(Point p1, Point p2) {
      double result = 0;
      result = p1.distance(p2);
      return result; 
   
   }

   // This method adds a random energy source to the grid.
   public void addEnergyNode(int eLvl) {
      EnergyNode temp = new EnergyNode(random.nextInt(200), random.nextInt(200), eLvl);
      boolean result = true;
   
      for (int i = 0; i < eList.size(); i++) {
         if (temp.getEnergyLocation().distance(eList.get(i).getEnergyLocation()) < 20) {
            result = false;
         
         }
      }
   
      if (result == true) {
         eList.add(temp);
      
      }
   }

   // This is the main method that has 3 different calls to RobotSim. 
   // Parameters for RobotSim (# of Energy Soruces, Starting energy for sources, Robot starting energy, Probability, # of simulations)
   public static void main(String[] args) { 
      RobotSim sim1 = new RobotSim(40, 125, 100, 40, 16);
      RobotSim sim2 = new RobotSim(40, 125, 100, 60, 16);
      RobotSim sim3 = new RobotSim(40, 125, 100, 80, 16);
         
   }
}