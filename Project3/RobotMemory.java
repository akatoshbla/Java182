/**
* Project #3: A Curious or Hungry Robot
* File: RobotMemory.java
* Programmers: Roland Avdalyan, Heston Jayasinghe, David Kopp
* Date: 12/8/13
* Description: This class is the interface for the memory structures that the robot uses.                
**/

import java.awt.Point;

public interface RobotMemory<E> {
   
   // Methods that implementing class must have
   public E get(int index);

   public int size();

   public void forget(E episode);

   public void learn(E episode);

   public Point retrieve(Point robotPosition);
   
   public void wipe();
   
}
