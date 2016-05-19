import java.io.IOException;

/**
 * @author Alex on 24.04.2016.
 */
public class Wizard
{
   private final String name;
   private Wand wand;

   public Wizard(String pName, Wand pWand) throws IOException
   {
      name = pName;
      wand = pWand;
   }

   public Wand getWand()
   {
      return wand;
   }

   public void setWand(Wand wand)
   {
      this.wand = wand;
   }

   public Wizard attack(Wizard other)
   {
      if (other == null)
      {
         return null;
      }
      else if (this.equals(other))
      {
         wand = null;
      }
      else if (other.wand == null || wand == null)
      {
         return null;
      }
      else if (!other.getWand().isUsable())
      {
         other.setWand(null);
      }
      else if (!wand.isUsable())
      {
         wand = null;
      }
      else
      {
         if (other.getWand().getPower() < wand.getPower())  //Wenn der andere Zauberer schwächer ist
         {
            other.setWand(null);
            return this;
         }
         else if (other.getWand().getPower() == wand.getPower())  //Beide Zauberer gleich stark
         {
            other.getWand().setUseable(false);
            wand.setUseable(false);
            return null;
         }
         else if (wand.getPower() < other.getWand().getPower())   //wenn der Andere Zauberer stärger ist
         {
            wand.setUseable(false);
            return other;
         }
      }

      return this;
   }

   @Override
   public String toString()
   {
      return ("Wizard: " + name + "\n" + wand + "\n");
   }

   @Override
   public int hashCode()
   {
      return super.hashCode();
   }
}