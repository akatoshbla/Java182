/**
* Project #1: Polymorphism, Inheritance, and Array Iterator
* File: Box.java
* Programmer: David Kopp
* Date: 9/27/13
* Description: This is an class which extends its parent Shape and defines object box and includes a draw method for displaying it. 
*/

   import java.awt.*;

   public class Box extends Shape {
   
   // Default constructor
      public Box() {
         super();
      
      }
   
   // Constructor with parameters
      public Box(Color color, int x, int y, int width, int height) {
         super(color, x, y, width, height);
      
      }
   
      public void draw(Graphics g) {
         g.setColor(color);
         g.fillRect(x, y, width, height);
      
      }
   
   }