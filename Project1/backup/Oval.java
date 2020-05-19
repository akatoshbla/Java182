/**
* Project #1: Polymorphism and Inheritance
* File: View2d.java
* Programmer: David Kopp
* Date: 8/28/13
* Description: This program reads a text file and creates an array of objects. Each object is then colored and drawed on a Jframe. 
*/

import java.awt.*;

public class Oval extends Shape {

// Default constructor
public Oval() {
super();

}

// Constructor with parameters
public Oval(Color color, int x, int y, int width, int height) {
super();

}

public void draw(Graphics g) {
g.setColor(color);
g.fillOval(x, y, width, height);

}

}
}
}