/*
WindowDemo.java

Example using Window182.java file.
Draws a "box" and an "oval"

Mike Barnes
8/27/2013
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class WindowDemo extends Window182 {
      static private final long serialVersionUID = 1L; // version 1, no serializable warnings
      
   public WindowDemo(String title) {
      super(title);
      repaint(); // clears window and calls paint -- to repaint window
      }
      
   /* paint is automatically called by the java GUI (AWT) whenever the
      windows needs to be "repainted".
      For example: when window is initially setVisible, when restored,
      when uncovered.  The AWT system provides the Graphics g argument.
   */   
   public void paint(Graphics g) {
      System.out.println("paint executes");
      g.setColor(Color.blue);             // set current color
      g.fillRect(100, 100, 600, 400);     // x, y, width, height of box
      g.setColor(new Color(0, 255, 255)); // color from r,g,b -- Color.cyan
      g.fillOval(200, 200, 400, 200);
      g.setColor(Color.red);
      g.drawString("Hi Comp 182", 350, 300);
      } 

   public static void main(String [] arg) {
      WindowDemo wd = new WindowDemo("Window182 Demo");
      }
   }