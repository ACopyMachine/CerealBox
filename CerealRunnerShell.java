
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class CerealRunnerShell
{
  public static ArrayList<Cereal> cerealList= setList();
      
  public static ArrayList<Cereal> setList()
  {
      cerealList = new ArrayList<Cereal>();
   
    try
    {
        BufferedReader in = new BufferedReader(new FileReader("Alexander Pushkar - Cereal.txt"));
       
        // declare String to hold input (delimited) String record on each read
        String str;

        // process one input record at a time until EOF (null)
        while ((str = in.readLine())!= null)
        {
            // read current record into a new array of type String with
            // number of elements determined by the number of delimited values
            String[] cerealData = str.split(",");
            // create a new Cereal object with input record details. Transform
            // datatypes as necessary
            Cereal cerealRec = new Cereal(cerealData[0],
            cerealData[1],
            Integer.parseInt(cerealData[2]),
            Integer.parseInt(cerealData[3]),
            Integer.parseInt(cerealData[4]),
            Integer.parseInt(cerealData[5]),
            Double.parseDouble(cerealData[6]),
            Double.parseDouble(cerealData[7]),
            Integer.parseInt(cerealData[8]),
            Integer.parseInt(cerealData[9]),
            Integer.parseInt(cerealData[10]),
            Integer.parseInt(cerealData[11]),
            Double.parseDouble(cerealData[12]),
            Double.parseDouble(cerealData[13]),
            Double.parseDouble(cerealData[14]));
                                     
            // use Sop to display the record (object)                          
            //System.out.println(cerealRec);
                                       
            // add the record to cerealList
            cerealList.add(cerealRec);
           
            // use Sop to display cerealList (taking advantage of ArrayList's toString
            //System.out.println(cerealList);
    
                   
        }       
        in.close();
           
    }
    
    catch (IOException e)
    {
        System.out.println("File Read Error");
    }
    
    return cerealList;
  }
  
}



class Question1Runner extends CerealRunnerShell
{
    
    public static void main(String args[])
    {
        int count = 0;
                for(Cereal currCereal : cerealList)
                {
                    if (currCereal.getRating()>50 && currCereal.getCalories()>100)
                    {
                        count++;
        
                    }
                }
                System.out.println("There are " + count + " cereals with 50%+ rating and 100+ cals");
    }
}
/*
 There are 3 cereals with 50%+ rating and 100+ cals
 */



class Question2Runner extends CerealRunnerShell
{
    public static void main(String args[])
    {
            try
            {
                BufferedWriter out = new BufferedWriter(new FileWriter("out. txt"));
                out.write("Name\tType\tCalories\tProtein\tFat\tSodium\tFiber\tCarbohydrates\tSugar\tPotassium\tVitamins\tShelf\tWeight\tCups\tRating\n");
    
                ArrayList<Cereal> noFatList = new ArrayList<Cereal>();
                for(Cereal currCereal : cerealList)
                {
                    if (currCereal.getFat()==0)
                        noFatList.add(currCereal);
                }
                out.write("There are " + noFatList.size() + " cereals with no fat");  
                for(Cereal currCereal : noFatList)
                    out.write(":\n " + currCereal.getName());
                
                out.close();
                // close the input file
                
            }
           
            catch (IOException e)
            {
                System.out.println("File Write Error");
            }
           
    }
}


class Question3Runner extends CerealRunnerShell
{
    
    public static void main(String args[])
    {
        int count = 0;
        for(Cereal currCereal : cerealList)
        {
            if (currCereal.getSugar()>currCereal.getCarbohydrates())
            {
                count++;

            }
        }
        System.out.println("There are " + count +" cereals with more sugar then carbohydrates");
  
    }
}
/*
 There are 8 cereals with more sugar then carbohydrates
 */



class Question4Runner extends CerealRunnerShell
{
    
    public static void main(String args[])
    {
        int hotCount = 0, coldCount = 0, hotFiberCount = 0, coldFiberCount = 0;
        for(Cereal currCereal : cerealList)
        {
            if (currCereal.getTemp().equals("C"))
            {
                coldCount++;
                coldFiberCount+=currCereal.getFiber();
            }
            else if (currCereal.getTemp().equals("H"))
            {    
                hotCount++;
                hotFiberCount+=currCereal.getFiber();
            }
        }
        System.out.println("The average fiber count in hot foods is " + (double)hotFiberCount/hotCount + "\nThe average fiber count in cold foods is " + ((double)coldFiberCount/coldCount));  
    }
}
/*
 The average fiber count in hot foods is 1.0
 The average fiber count in cold foods is 2.1621621621621623
 */

