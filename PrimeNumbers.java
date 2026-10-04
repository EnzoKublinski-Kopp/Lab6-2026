import java.util.Scanner;

/**
 * Evaluates whether given whole numbers are prime.
 *
 * @author Enzo Kublinski Kopp
 * @version v1.0
 * @since 10/04/2026
 */
public class PrimeNumbers
{
     public static void main(String[] args)
     {
        String again;
        int number;
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.print("Enter a whole number > 2 (ie 19) to test if prime: ");
            number = keyboard.nextInt();

            if (testForPrime(number)) {
                System.out.println(number + " is prime");
            } else {
                System.out.println(number + " is not prime");
            }

            System.out.print("Enter yes to test another number, no to quit. ");
            again = keyboard.next();

        } while (again.equalsIgnoreCase("yes"));

        keyboard.close();
         
     }
     
     /**
     * Tests whether a given whole number is prime.
     *
     * @param number The integer to evaluate.
     * @return true if the number is prime, false otherwise.
     */
     public static boolean testForPrime(int n)
     {
         if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
     }