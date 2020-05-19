/**
* Project #1: Polymorphism, Inheritance, and Array Iterator
* File: View2d.java
* Programmers: David Kopp
* Date: 9/27/13
* Description: This program reads a text file and creates a collection(array data-structure) of unknown type by using the new command, while also calling the 
*					a shape or text object's constructors. Then after the objects are created and placed into the array an iterator is used to traverse 
*					the array and to call the objects draw methods associated with each object's class.
*/

   import java.awt.*;
   import java.util.*;
   import java.io.*;

   public class View2D extends Window182 {
   
      private ArrayList<DrawableShape> scene = new ArrayList<DrawableShape>();
   
      public View2D(String title, String fileName) {
      
      // Defined variables and super import
         super(title);
         int red, green, blue, x, y, width, height, numberStrings;
         File input = new File(fileName);
         String name = null;
      
      // Try and Catch for opening input file
         try {
            Scanner inFile = new Scanner(input);
         
         // While loop that reads the name of the object that needs to be created and put into an array
            while (inFile.hasNext()){
               name = inFile.next();
            	
            	// This if loop takes both box or oval and sets the corresponding object into an array
               if (name.equalsIgnoreCase("Box") || name.equalsIgnoreCase("Oval")) {
                  red = inFile.nextInt();
                  green = inFile.nextInt();
                  blue = inFile.nextInt();
                  x = inFile.nextInt();
                  y = inFile.nextInt();
                  width = inFile.nextInt();
                  height = inFile.nextInt();
                  Color shapeColor = new Color(red, green, blue);
               	
               // This nested if loop creates a box object
                  if (name.equalsIgnoreCase("Box")) {
                     scene.add(new Box(shapeColor, x, y, width, height));
                  
                  }
               
               // This nested if loop creates a oval object
                  if (name.equalsIgnoreCase("Oval")) {
                     scene.add(new Oval(shapeColor, x, y, width, height));
                  
                  }
               
               }
               
               // This if loop creates a text object and adds them to an array
               if (name.equalsIgnoreCase("Text")) {
                  x = inFile.nextInt();
                  y = inFile.nextInt();
                  numberStrings = inFile.nextInt();
                  String msgs = "";
               
               // This for loop allows the number of strings to be combined into a larger string
                  for(int i = 0; i < numberStrings; i++) {
                     msgs = msgs.concat(inFile.next() + " ");
                  
                  }
               
                  scene.add(new Text(x, y, msgs));
               
               }            
            
            }
                  	
            inFile.close();
         	
         }
         
            catch (FileNotFoundException e){
               System.out.println("File not found, try again");
            
            }
      	
         repaint();
      
      }	
   
   // This is the paint call to the iterator with a while loop to draw each shape
      public void paint(Graphics g){
         Iterator<DrawableShape> iterator = scene.iterator();
      	
         while(iterator.hasNext()){
            DrawableShape shape = iterator.next();
            shape.draw(g);
         
         }	
      	
      }
   
   // This is the main method that starts the chain of calls to create a array and draw the objects in that array to a Frame.
      public static void main(String[] arg){
         View2D header = new View2D("David Kopp Comp182 Project1 Fall 2013", "scene.v2d");
      	
      }
   	
   }