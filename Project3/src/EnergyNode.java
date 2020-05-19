/**
* Project #3: A Curious or Hungry Robot
* File: Memory.java
* Programmers: David Kopp
* Date: 12/8/13
* Description: This program 
**/

import java.awt.Point;
import java.util.ArrayList;

public class EnergyNode<EnergyNode> {

Point energyLocation;
int energyLevel;

public EnergyNode(int x, int y, int eLvl) {
setEnergyLocation(x, y);
setEnergyLevel(eLvl);

}

public void setEnergyLevel(int eLvl) {
energyLevel = eLvl;

}

public Point getEnergyLocation() {
return energyLocation;

}

public void setEnergyLocation(int x, int y) {
Point newPoint = new Point(x, y);
energyLocation = newPoint;

}

public String toString() {
return "Energy Node at: " + energyLocation + ", Energy Level: " + energyLevel;

}

}