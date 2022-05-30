import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cereal
{
   String name;              
   String temp;              
   int calories;            
   int protein;              
   int fat;                  
   int sodium;              
   double fiber;
   double carbohydrates;
   int sugar;
   int potassium;
   int vitamins;
   int shelf;
   double weight;
   double cups;
   double rating;
 
   
   public Cereal(String name, String temp, int calories, int protein, int fat, int sodium, double fiber, double carbohydrates, int sugar, int potassium, int vitamins, int shelf, double weight, double cups, double rating)      
   {
       this.name = name;
       this.temp = temp;
       this.calories = calories;
       this.protein = protein;
       this.fat = fat;
       this.sodium = sodium;
       this.fiber = fiber;
       this.carbohydrates = carbohydrates;
       this.sugar = sugar;
       this.potassium = potassium;
       this.vitamins = vitamins;
       this.shelf = shelf;
       this.weight = weight;
       this.cups = cups;
       this.rating = rating;
   }              
   
   public Cereal(String name, String temp, int calories, double cups, double rating)
   {
       this.name = name;
       this.temp = temp;
       this.calories = calories;
       this.cups = cups;
       this.rating = rating;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public String getName()
   {
       return name;
   }
   public String getTemp()
   {
       return temp;
   }
   public int getCalories()
   {
       return calories;
   }
   public int getProtein()
   {
       return protein;
   }
   public int getFat()
   {
       return fat;
   }
   public int getSodium()
   {
       return sodium;
   }
   public double getFiber()
   {
       return fiber;
   }
   public double getCarbohydrates()
   {
       return carbohydrates;
   }
   public int getSugar()
   {
       return sugar;
   }
   public int getPotassium()
   {
       return potassium;
   }
   public int getVitamins()
   {
       return vitamins;
   }
   public int getShelf()
   {
       return shelf;
   }
   public double getWeight()
   {
       return weight;
   }
   public double getCups()
   {
       return cups;
   }
   public double getRating()
   {
       return rating;
   }
   
   
   public String toString()
   {
      String tempA; 
      if (temp.equals("H"))
          tempA = "Hot";
      else if(temp.equals("C"))
          tempA = "Cold";
      else
          tempA = temp;
        
      return("\nCereal: " + name + "\n\tType: " +  tempA +"\n\tCalories: " + calories + "\n\tProtein: " + protein + "\n\tFat: " + fat + "\n\tSodium: " + sodium + "\n\tFiber: " + fiber + "\n\tCarbohydrates: " + carbohydrates + "\n\tSugar: " + sugar + "\n\tPotassium: " + potassium + "\n\tVitamins: " + vitamins + "\n\tShelf: " + shelf + "\n\tWeight: " + weight + "\n\tCups: " + cups + "\n\tRating: " + rating);
   }
   
  

}