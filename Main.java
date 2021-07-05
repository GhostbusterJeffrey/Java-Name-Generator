import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

  private static Random first = new Random();
  private static Random second = new Random();
  private static Scanner in = new Scanner(System.in);
  private static int firstnumber = 0;
  private static int secondnumber = 0;
  private static int nameRange = 0;
  private static String line1 = " ";
  private static String line2 = " ";
  public static void clearScreen() {  

     System.out.print("\033[H\033[2J");  

     System.out.flush();  

  }

  public static void generateAnswers(){
      String input;
      System.out.println("Male or Female name? Type m/f");
      input = in.nextLine();

      in.close();
      if(input.equals("f")){
        nameRange = 1;
      } else {
        nameRange = 1001;
      }
      
      firstnumber = first.nextInt(999);
      firstnumber += nameRange;
      try{
        line1 = Files.readAllLines(Paths.get("Firstnames.txt")).get(firstnumber);
      } 
      catch(IOException e){
        System.out.println(e);
      }

      secondnumber = second.nextInt(999);
      secondnumber += 1;
      try{
        line2 = Files.readAllLines(Paths.get("Lastnames.txt")).get(secondnumber);
      }
      catch(IOException e){
        System.out.println(e);
      }
      clearScreen(); 
      System.out.println(line1 + " " + line2);
  }

  public static void main(String[] args) throws FileNotFoundException {
      generateAnswers();
  }

}