/*
Name: Brian Gerhart
CSU ID: 2741107
CIS 265: Assignment 6
Description: This program takes in two strings, the first string is converted into a File using the FIle class. then if the input of the file exists it will
call our search method where the file name matching the string will match and it prints the filepath that matches. Also if our path is a directory, an array 
of subfiles wil be created and the method is called recursively to search all the subfiles. 
*/

import java.io.File;
import java.util.Scanner;

public class Assign6gerhart {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
     
      System.out.println("Please enter a filepath, followed by the word you'd like to search for.");
         String source = input.nextLine();
         String name = input.nextLine();
         File file = new File(source);
            if(file.exists()) {  
               System.out.println("___________________________________FILE MATCHES___________________________________");
               search(file, name);
            } else {
               System.out.println("Enter filepath, followed by a space and the word you would like to search.");
            }
  
   }
    
   public static void search(File file, String name) {
      
      if (file.getName().indexOf(name) >= 0) {
         System.out.println(file.getPath());
      }
      else if (file.isDirectory()) {
        File[] subFile = file.listFiles();
         for (File sub: subFile) {  
            search(sub, name);
         }
      }
         
   } 
}