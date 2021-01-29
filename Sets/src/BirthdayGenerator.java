import java.util.stream.IntStream;
import java.util.*;
 
public class BirthdayGenerator {
   
    private static final int NUMBER_RUNS = 20;
 
    /**
     * Runs the birthdayRepeater simulation a number of times
     * @param args
     */
    public static void main( String [] args ) {
        IntStream.range(0, NUMBER_RUNS).forEach($ -> System.out.println(birthdayRepeater()));
    }
 
    /**
     * Generates a number to represent a day in a year (ignoring leap day)
     * @return an integer in the set {1, 2, 3, ... 365}
     */
    public static int randomDay() {
        return (int) ((Math.random() * 365) + 1);
    }
 
    /**
     * Simulates multiple different birthdays of random people
     * until two are found to have had the same birthday.
     * @return The number of times before two days matched
     */
    public static int birthdayRepeater() {
        Set<Integer> birthdays = new HashSet<>();
        while (birthdays.add(randomDay()));
        return birthdays.size();
    }
}