/**
* Project #3: A Curious or Hungry Robot
* File: Memory.java
* Programmers: David Kopp
* Date: 12/8/13
* Description: This program 
**/

import java.awt.Point;

public class Memory {

private Point energyLocation;
private int energyAmount;

public Memory(Point place, int amount) {
energyLocation = place;
energyAmount = amount;

}

public int getEnergy(int need) {

if (need < energyAmount) {
return energyAmount - need; 

}

else {
return energyAmount;

}

}

}