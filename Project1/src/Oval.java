/**
* Project #1: Polymorphism, Inheritance, and Array Iterator
* File: Oval.java
* Programmer: David Kopp
* Date: 9/27/13
* Description: This is an class which extends its parent Shape and defines object oval and includes a draw method for displaying it. 
*/

   import java.awt.*;

   public class Oval extends Shape {
   
   // Default constructor
      public Oval() {
         super();
      
      }
   
   // Constructor with parameters
      public Oval(Color color, int x, int y, int width, int height) {
         super(color, x, y, width, height);
      
      }
   
      public void draw(Graphics g) {
         g.setColor(color);
         g.fillOval(x, y, width, height);
      
      }
   }