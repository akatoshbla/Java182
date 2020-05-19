/**
* Project #1: Polymorphism, Inheritance, and Array Iterator
* File: Shape.java
* Programmer: David Kopp
* Date: 9/27/13
* Description: This is an abstract class named shape and includes the variables for its children classes
*/

   import java.awt.*;

   public abstract class Shape implements DrawableShape {
   
   // Variables
      protected Color color;
      protected int x;
      protected int y;
      protected int width;
      protected int height;
   
   // Default Constructor
      public Shape() {
         color = Color.red;
         x = 0;
         y = 0;
         width = 1;
         height = 1;
      
      }
   
   // Constructor with attributes
      public Shape(Color newColor, int anX, int anY, int anW, int anH) {
         color = newColor;
         x = anX;
         y = anY;
         width = anW;
         height = anH;
      
      }
   
   // Abstract method
      public abstract void draw(Graphics g);
   
   }