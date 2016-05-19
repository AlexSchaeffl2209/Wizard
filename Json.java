import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author Alex on 09.05.2016.
 */
class Json
{
   /**
    * @param wizList
    * @throws IOException
    */
   static void writeJSON(ArrayList<Wizard> wizList) throws IOException
   {
      com.google.gson.Gson gson = new GsonBuilder().setPrettyPrinting().create();

      try (FileWriter w = new FileWriter("C:\\Users\\Alex-Pc\\Desktop\\file.json"))
      {
         gson.toJson(wizList, w);
      }
   }

   /**
    * @return
    * @throws IOException
    */
   static ArrayList<Wizard> readListFromJSON() throws IOException
   {
      com.google.gson.Gson gson = new GsonBuilder().setPrettyPrinting().create();

      Type listType = new TypeToken<ArrayList<Wizard>>()
      {
      }.getType();
      
      return gson.fromJson(new FileReader(decide()), listType);
   }

   /**
    * @return
    */
   static String decide()
   {
      return new File("C:\\Users\\Alex-Pc\\Desktop\\file.json").exists() ? "C:\\Users\\Alex-Pc\\Desktop\\file.json" : "C:\\Users\\Alex-Pc\\Desktop\\standard.json";
   }
}
