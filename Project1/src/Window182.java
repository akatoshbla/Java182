/*
Window182 is a simple GUI Window for Comp182 projects.

Mike Barnes
1/15/2013
*/

   import java.awt.*;
   import java.awt.event.*;

/**
 * Window182 is a simple window
 * for use by Comp 182 students in assignments.
 *
 * @author Mike Barnes CSUN 1/15/2013
 */
   public class Window182 extends Frame {
      static private final long serialVersionUID = 1L; // version 1, no serializable warnings
      static private final int WIDTH = 800, HEIGHT = 600;
   
   /**
   * Initialize the window's common attributes width and height
   * @param w Window's width
   * @param h Window's height
   */
      private void initWindow182(int w, int h) {
         setSize(w, h);
      // code below handles "X" window close button events.
         addWindowListener ( 
               new WindowAdapter() {
                  public void windowClosing (WindowEvent e) {
                     System.exit (0); }});
         setVisible(true);
      }
        
   /**
   * Default constructor
   */
      public Window182() {
         super("Window182");
         initWindow182(WIDTH, HEIGHT);
      }
   
   /**
   * Constructor with title
   * @param title Window's title
   */
      public Window182(String title) {
         super(title);
         initWindow182(WIDTH, HEIGHT);
      }
   
   /**
   * Constructor with title, width, and height
   * @param title Window's title
   * @param w Window's  width
   * @param h Window's height
   */
      public Window182(String title, int w, int h) {
         super(title);
         initWindow182(w, h);
      }
   }