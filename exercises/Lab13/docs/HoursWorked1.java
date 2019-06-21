// Reads hours worked for several employees and reports their overall hours worked 
import java.io.*;
import java.util.*;
/**
 * Reads hours worked for several employees and reports their overall hours worked 
 *
 * @author Lina Battestilli
 */

/* File structure:
Erica 7.5 8.5 10.25 8 8.5
Erin 10.5 11.5 12 11 10.75
Simone 8 8 8
Ryan 6.5 8 9.25 8
Kendall 2.5 3
*/

public class HoursWorked1 {
   public static void main(String[] args) throws FileNotFoundException {
      userInterface();
   }
    
   /**
    * Interacts with the user
    */   
   public static void userInterface()  throws FileNotFoundException  {
   
      //to read user input from console window		
      Scanner console = new Scanner(System.in); 
      
      //where to get the input to process
      Scanner fileProcessor = getInputScanner(console);
   
      //process the input file
      processFile(fileProcessor);
         
      //close all Scanners that were used
      console.close();
      fileProcessor.close();    
   }
    
   /**
    * Returns a Scanner to processes the file entered by the user
    * @param console a Scanner for the console
    * @return Scanner to an input file
    */
   public static Scanner getInputScanner(Scanner console) throws FileNotFoundException {      
      //keep on asking the user until they give you an existing input file
      System.out.print("Enter input file name:");
      File inFile = new File (console.nextLine());				
      while (!inFile.exists()){
         System.out.print("File does not exists. Enter another file name:");
         inFile = new File (console.nextLine());
      }
      Scanner input = new Scanner(inFile);         		        				
      return input;
   }
    
   /**
    * Processes a file token by token
    * @param input Scanner to read the input file
    */
   public static void processFile(Scanner input){
   	//process file token by token
      while (input.hasNext()){
      	//process one person
         String name = input.next();
         double totHours=0;	
         while (input.hasNextDouble()){
            totHours += input.nextDouble();
         }								
      	//print the results for that person
         System.out.printf("%s worked %4.2f hours this week\n",name,totHours);
      }
   }	
}