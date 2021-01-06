package DiceThrow;
import java.util.Random;
import java.util.*;


public class VDiceThrower {
    public static void main  (String[] args) {
        Random randGen = new Random();              // create new random generator object
        Scanner sides = new Scanner(System.in);     //Scanner  object for input instantiated
        int s;
        while (true) {                              //Loop used to get input and handle exceptions
            System.out.println("Enter the number of sides of the dice: \n");
            try {
                s = sides.nextInt();
            }
            catch (Exception e) {                   //Catching all exceptions as we have  no need for different responses
                System.out.println("Input invalid!\n");
                sides.nextLine();
                continue;                           //Skips the rest of the loop to begin it again asking for new input
            }
            if (s > 1) {                            //Condition for correct input
                break;
            }
            else {
                System.out.println("Number of sides must be greater than 2!\n");
            }
        }

        Scanner nThrows = new Scanner(System.in);   //New Scanner object for user input
        int t;
        while (true) {                              //Similar exception handling as previous user input with slightly
                                                    //different correct conditions
            System.out.println("Enter the number of throws (Must be a multiple of sides): \n");
            try {
                t = nThrows.nextInt();
            }
            catch (Exception e) {
                System.out.println("Input invalid!\n");
                nThrows.nextLine();
                continue;
            }
            if (t > 0 && t%s == 0) {
                break;
            }
            else {
                System.out.println("Input must be larger than 0 and be a multiple of the number of sides!\n");
            }
        }

        long startTime = System.currentTimeMillis();    //Used to calculate runtime of program
        int[] totalThrows = new int[s];                 //Array that will contain total number of throws
        for(int i = 0; i < t; i++) {                    //Generating the throws and storing the results in the array
            int thisFace = randGen.nextInt(s);
            totalThrows[thisFace]++;
        }
        float[] percThrows = new float[s];              //Calculating the percentage for each side ans storing in a new array
        for(int i = 0; i < s; i++) {
            percThrows[i] = (float)totalThrows[i]/t;
        }
        long endTime = System.currentTimeMillis();      //Time used to find runtime
        System.out.println("Took "+(endTime - startTime) + " ms");
        System.out.println("Total throws per side:");
        for (int i = 0; i < totalThrows.length; i++) {  //Displaying the values for each side of the dice
            System.out.println("Side " + (i+1) +": " + totalThrows[i] + ", " + percThrows[i]*100 + "%");
        }
    }
}