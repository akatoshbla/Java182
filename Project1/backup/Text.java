/**
* Project #1: Polymorphism and Inheritance
* File: View2d.java
* Programmer: David Kopp
* Date: 8/28/13
* Description: This is an class which defines object Text and includes a draw method for displaying it.
*/

public class Text implements DrawableShape {

protected String message;
protected int x;
protected int y;

// Default Constructor for Text
public Text() {
message = "Default Constructor";
x = 1;
y = 1;

}

// Constructor with attributes
public Text(int anX, int anY, String msg) {
x = anX;
y = anY;
message = msg;

}

// Instruction on where and what to draw for Text
public void draw(Graphics g) {
g.drawString(msg, x, y);

}

}