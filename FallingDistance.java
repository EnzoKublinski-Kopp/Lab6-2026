import java.util.Scanner;
/**
 * Calculates falling distance over a given time. 
 *
 * @author Enzo Kublinski-Kopp
 * @version v1.0
 * @since 10/4/2026
 */
public class FallingDistance
{
    public static final double ACCELERATION = 9.8;
    
    public static void main(String[] args)
    {
        int maxSeconds;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("how many seconds to compute: ");
        maxSeconds = keyboard.nextInt();
        
        System.out.println("\nTime(secs)  Distance(m)");
        System.out.println("=========   ===========");
        
        for (int i = 0; i < maxSeconds; i++)
        {
            System.out.printf("%-12d%.1f\n", i+1, getDistance(i+1));
        }
        
        
    }
    
    /**
     * Calculates the falling distance for a given duration in seconds.
     *
     * @param The number of seconds the object has been falling.
     * @return The distance in meters.
     */
    public static double getDistance(int t)
    {
        double distance = (0.5) * ACCELERATION * Math.pow(t,2);
        
        return distance;
    }
}