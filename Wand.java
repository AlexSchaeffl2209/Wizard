/**
 * @author Alex on 24.04.2016.
 */
public class Wand
{
   private final int power;
   private boolean useable = true;

   public Wand(int power)
   {
      if (power < 0)
      {
         throw new IllegalArgumentException("Power darf nicht kleiner als 0 sein!");
      }
      else
      {
         this.power = power;
      }
   }

   public boolean isUsable()
   {
      return useable;
   }

   public void setUseable(boolean useable)
   {
      this.useable = useable;
   }

   public int getPower()
   {
      return power;
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Wand wand = (Wand) o;

      return power == wand.power && useable == wand.useable;
   }

   @Override
   public int hashCode()
   {
      int result = power;
      result = 31 * result + (useable ? 1 : 0);
      return result;
   }

   @Override
   public String toString()
   {
      return "Power: " + getPower() +
              "\nUseable: " + isUsable();
   }
}
