import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Alex on 24.04.2016.
 */
public class Main
{
   public static void main(String[] args) throws IOException
   {

      ArrayList<Wizard> wizardArrayList = Json.readListFromJSON();

      boolean again = true;

      do
      {
         System.out.println("Willkommen im Hogwarts!");
         System.out.println("---------------------------------------");
         System.out.println("Was möchten Sie tun?");
         System.out.println("1: Alle Zauberer ausgeben");
         System.out.println("2: Einen neuen Zauberer erschafen");
         System.out.println("3: Einen Zauberer entfernen");
         System.out.println("4: Einen Zauberer Angreifen");
         System.out.println("5: Zauberer auf Standard setzen");
         System.out.println("0: Programm beenden");
         System.out.print("Auswahl: ");

         Scanner scanner = new Scanner(System.in);
         int eingabe = scanner.nextInt();

         switch (eingabe)
         {
            case 1:
               Liste.writeAll(wizardArrayList);
               break;
            case 2:
               Liste.addWizard(wizardArrayList);
               break;
            case 3:
               Liste.deletWizard(wizardArrayList);
               break;
            case 4:
               Liste.attackWizard(wizardArrayList);
               break;
            case 5:

               boolean file = new File("C:\\Users\\Alex-Pc\\Desktop\\file.json").delete();

               if (file)
                  System.out.println("\nZauberer wurden zurückgesetzt\n");
               else
                  System.out.println("\nZauberer wurden nicht zurückgesetzt\n");

               wizardArrayList = Json.readListFromJSON();

               break;
            case 0:
               Json.writeJSON(wizardArrayList);
               again = false;
               break;
         }
      } while (again);
   }
}
