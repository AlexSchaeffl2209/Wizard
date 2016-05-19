import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Alex on 05.05.2016.
 */
public class Liste
{
   /**
    * @param list
    */
   public static void writeAll(ArrayList<Wizard> list)
   {
      if (!(list.isEmpty()))
      {
         list.forEach(System.out::println);
      }
      else
      {
         System.out.println();
         System.out.println("Es sind keine Zauberer vorhanden!");
         System.out.println();
      }
   }

   /**
    * @param list
    * @return
    * @throws IOException
    */
   public static ArrayList<Wizard> addWizard(ArrayList<Wizard> list) throws IOException
   {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Geben Sie den Namen des neuen Zauberers ein");
      String name = scanner.nextLine();

      System.out.println("Wie Stark soll dieser Zauberer sein?");
      int power = scanner.nextInt();

      list.add(new Wizard(name, new Wand(power)));

      return list;
   }

   /**
    * @param list
    * @return
    */
   public static ArrayList<Wizard> deletWizard(ArrayList<Wizard> list)
   {
      if (!(list.isEmpty()))
      {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Welchen Zauberer möchten Sie entfernen?");
         int input = scanner.nextInt();
         input--;

         System.out.println(list.get(input));
         System.out.println("Wurde gelöscht");
         System.out.println();
         list.remove(input);

         return list;
      }
      else
      {
         System.out.println();
         System.out.println("Es sind keine Zauberer vorhanden!");
         System.out.println();

         return list;
      }
   }

   /**
    * @param list
    * @return
    */
   public static ArrayList<Wizard> attackWizard(ArrayList<Wizard> list)
   {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Angreifer Nr.");
      int attack = scanner.nextInt();

      System.out.println("Verteidiger Nr.");
      int defend = scanner.nextInt();

      Wizard wizard1 = list.get(attack - 1);
      Wizard wizard2 = list.get(defend - 1);
      wizard1.attack(wizard2);

      return list;
   }
}
