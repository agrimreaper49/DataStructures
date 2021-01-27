import java.util.*;
 
public class Agra_10 {
 
    public static void main( String [] args ) {
        run1(); // -5
        run2(); // 1
    }
 
    /**
     * Performs the tasks of COOK, CLEAN, SERVE
     * @param tasks The tasks, always in pairs of task type then task value.
     * @return the total points awarded
     */
    public static int mealPrep(Queue<String> tasks) {
        Stack<String> platesAvailable = new Stack<>();
        int mainMeal = 0;
        int dessertMeal = 0;
        int points = 0;    
        while (!tasks.isEmpty()) {
            String task = tasks.remove();
            String mainOrDessert = tasks.remove();
            switch (task) {
                case "CLEAN":
                    platesAvailable.add(mainOrDessert);
                    break;
                case "COOK":
                    if (mainOrDessert.equals("MAIN")) {
                        mainMeal++;
                    }
                    else if (mainOrDessert.equals("DESSERT")) {
                        dessertMeal++;
                    }
                    break;
                default:
                	if (platesAvailable.isEmpty() || mainOrDessert.equals("MAIN") && (mainMeal <= 0) 
                		  || mainOrDessert.equals("MAIN") && !platesAvailable.peek().equals("LARGE") 
                		  || mainOrDessert.equals("DESSERT") && (dessertMeal <= 0)) {
                		points -= 5;
                	} 
                	else {
                		platesAvailable.pop();
                		if (mainOrDessert.equals("MAIN")) {
                			points += 2;
                			mainMeal--;
                		}
                		else if (mainOrDessert.equals("DESSERT")) {
                			points++;
                			dessertMeal--;
                		}
                	}
                	
            }
        }
        return points;
    }
 
   
    public static void run1() {
 
        Queue<String> tasks = new LinkedList<>();
        tasks.add( "CLEAN" );
        tasks.add( "LARGE" );   // current plates: (top) LARGE
        tasks.add( "CLEAN" );
        tasks.add( "LARGE" );   // current plates: (top) LARGE, LARGE
        tasks.add( "CLEAN" );
        tasks.add( "SMALL" );   // current plates: (top) SMALL, LARGE, LARGE
        tasks.add( "COOK" );
        tasks.add( "MAIN" );    // current food: MAIN - 1, DESSERT - 0
        tasks.add( "COOK" );    
        tasks.add( "DESSERT" ); // current food: MAIN - 1, DESSERT - 1
        tasks.add( "COOK" );    
        tasks.add( "DESSERT" ); // current food: MAIN - 1, DESSERT - 2
        tasks.add( "COOK" );
        tasks.add( "MAIN" );    // current food: MAIN - 2, DESSERT - 2
        tasks.add( "COOK" );
        tasks.add( "DESSERT" ); // current food: MAIN - 2, DESSERT - 3
        tasks.add( "SERVE" );
        tasks.add( "DESSERT" ); // successful (+1), points = 1.
                                // current plates: (top) LARGE, LARGE
                                // current food: MAIN - 2, DESSERT - 2
        tasks.add( "SERVE" );
        tasks.add( "DESSERT" ); // successful (+1), points = 2.
                                // current plates: (top) LARGE
                                // current food: MAIN - 2, DESSERT - 1
        tasks.add( "CLEAN" );  
        tasks.add( "SMALL" );   // current plates: (top) SMALL, LARGE
        tasks.add( "SERVE" );
        tasks.add( "MAIN" );    // unsuccessful (-5), points = -3.
                                // the top plate could not handle a MAIN dish
                                // no change to either plates or food
        tasks.add( "SERVE" );
        tasks.add( "DESSERT" ); // successful (+1), points = -2.
                                // current plates: (top) LARGE
                                // current food: MAIN - 2, DESSERT - 0
        tasks.add( "SERVE" );
        tasks.add( "DESSERT" ); // unsuccessful (-5), points = -7.
                                // there were no DESSERTs left
                                // no change to either plates or food
        tasks.add( "SERVE" );
        tasks.add( "MAIN" );    // successful (+2), points = -5.
                                // current plates: (top) none
                                // current food: MAIN - 1, DESSERT - 0
 
        System.out.println( "AGRA-10's efficiency was: " + mealPrep( tasks ) );
                                // Would print: AGRA-10's efficiency was -5.
    }
   
    public static void run2() {
        Queue<String> tasks = new LinkedList<>();
        tasks.add( "CLEAN" );
        tasks.add( "LARGE" );   // current plates: (top) LARGE
        tasks.add( "CLEAN" );
        tasks.add( "LARGE" );   // current plates: (top) LARGE, LARGE
        tasks.add( "CLEAN" );
        tasks.add( "SMALL" );   // current plates: (top) SMALL, LARGE, LARGE
        tasks.add( "COOK" );
        tasks.add( "MAIN" );    // current food: MAIN - 1, DESSERT - 0
        tasks.add( "COOK" );    
        tasks.add( "DESSERT" ); // current food: MAIN - 1, DESSERT - 1
        tasks.add( "COOK" );    
        tasks.add( "DESSERT" ); // current food: MAIN - 1, DESSERT - 2
        tasks.add( "COOK" );
        tasks.add( "MAIN" );    // current food: MAIN - 2, DESSERT - 2
        tasks.add( "COOK" );
        tasks.add( "DESSERT" ); // current food: MAIN - 2, DESSERT - 3
        tasks.add( "SERVE" );
        tasks.add( "DESSERT" ); // successful (+1), points = 1.
                                // current plates: (top) LARGE, LARGE
                                // current food: MAIN - 2, DESSERT - 2
        tasks.add( "SERVE" );
        tasks.add( "MAIN" );    // successful (+2), points = 3.
                                // current plates: (top) LARGE
                                // current food: MAIN - 1, DESSERT - 2
        tasks.add( "SERVE" );
        tasks.add( "MAIN" );    // successful (+2), points = 5.
                                // current plates: (top) none
                                // current food: MAIN - 0, DESSERT - 2
        tasks.add( "SERVE" );
        tasks.add( "DESSERT" ); // unsuccessful (-5), points = 0.
                                // there were no PLATEs left
                                // no change to either plates or food
        tasks.add( "CLEAN" );
        tasks.add( "LARGE" );   // current plates: (top) LARGE
        tasks.add( "SERVE" );
        tasks.add( "DESSERT" ); // successful (+1), points = 1.
                                // current plates: (top) none
                                // current food: MAIN - 0, DESSERT - 1
       
 
        System.out.println( "AGRA-10's efficiency was: " + mealPrep( tasks ) );
                                // Would print: AGRA-10's efficiency was 1.
    }
   
}
 