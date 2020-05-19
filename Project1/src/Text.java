/**
* Project #1: Polymorphism, Inheritance, and Array Iterator
* File: Text.java
* Programmer: David Kopp
* Date: 9/27/13
* Description: This is an class which defines object Text and includes a draw method for displaying it. 
*					It also implements an interface DrawableShape.
*/

   import java.awt.*;

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
			g.setColor(Color.black);
         g.drawString(message, x, y);
      
      }
   
   }