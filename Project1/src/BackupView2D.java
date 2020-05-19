/*
/ The main file that collects information from the abstract shape class which
/ box and oval extend to get information to draw the shapes. An array list is created to store 
/ information from a file which is then read by an iterator that does the actual drawing.
/
*/

   import java.awt.*;
   import java.util.*;
   import java.io.*;

   public class View2D extends Window182 {
	
      private ArrayList<DrawableShape> scene = new ArrayList<DrawableShape>();
   
      public View2D(String title, String fileName) {
         super(title);
         int red, green, blue, x, y, width, height, numberStrings;
         File input = new File(fileName);
         String name = null;
      
         try{
            Scanner inFile = new Scanner(input);
				
            // while(inFile.hasNext()){
//                name = inFile.next();
//                x = inFile.nextInt();
//                y = inFile.nextInt();
//                numberStrings = inFile.nextInt();
//                String n = "";
//             
//                for(int i = 0; i < numberStrings; i++) {
//                   n.concat(inFile.next());
//                }
//             
//                if(name.equals("Text")) {
//                   scene.add(new Text(x, y, n));
//                
//                }
//             }
         
            while (inFile.hasNext()){
               name = inFile.next();
//                red = inFile.nextInt();
//                green = inFile.nextInt();
//                blue = inFile.nextInt();
//                x = inFile.nextInt();
//                y = inFile.nextInt();
//                width = inFile.nextInt();
//                height = inFile.nextInt();
// 					Color shapeColor = new Color(red, green, blue);
// 					System.out.println("Name: " + name + " Color RGB " + shapeColor + " X: " + x + " Y: " + y + " Width: " + width + " Height " + height); 
            
               if (name.equals("Box") || name.equals("Oval")) {
					red = inFile.nextInt();
               green = inFile.nextInt();
               blue = inFile.nextInt();
               x = inFile.nextInt();
               y = inFile.nextInt();
               width = inFile.nextInt();
               height = inFile.nextInt();
					Color shapeColor = new Color(red, green, blue);
					System.out.println("Color RGB: " + shapeColor + " X: " + x + " Y: " + y + " Width: " + width + " Height " + height);
						if (name.equals("Box")) {
                  scene.add(new Box(shapeColor, x, y, width, height));
               }
					
               if (name.equals("Oval")) {
                  scene.add(new Oval(shapeColor, x, y, width, height));
               }
            
            }
				
				if (name.equals("Text")) {
					x = inFile.nextInt();
               y = inFile.nextInt();
               numberStrings = inFile.nextInt();
               String n = "";
            
               for(int i = 0; i < numberStrings; i++) {
                  n.concat(inFile.next());
						
               }
            
                  scene.add(new Text(x, y, n));
               
               }

				}
         
         	
            inFile.close();
         }
         
            catch (FileNotFoundException e){
               System.out.println("File not found, try again");
            }
      	
         repaint();
      }	
   
      public void paint(Graphics g){
         Iterator<DrawableShape> iterator = scene.iterator();
         while(iterator.hasNext()){
            DrawableShape shape = iterator.next();
            shape.draw(g);
         }	
      }
   
      public static void main(String [] arg){
         View2D vw = new View2D("Roland Avdalyan and David Kopp", "scene.v2d");
      }
   }