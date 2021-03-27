import java.io.*;
import java.util.*;
 
public class FifaRunner {
 
    // Make static fields for each data structure you need.
	
	//Sets
	private static TreeSet<Integer> ages = new TreeSet<>();
	private static TreeSet<String> nationalities = new TreeSet<>();
	private static HashSet<String> positions = new HashSet<>();
	
	//Maps
	private static TreeMap<String, Integer>  positionCount = new TreeMap<>();
	private static TreeMap<String, Integer> nationalityCount = new TreeMap<>();
	private static TreeMap<String, Integer> oldestPerNation = new TreeMap<>();
	private static TreeMap<Integer, Integer> groupCount = new TreeMap<>();
	private static TreeMap<String, TreeSet<String>> positionToNation = new TreeMap<>();
	
	private static TreeMap<String, TreeSet<String>> test1 = new TreeMap<>();

  
    /**
     * Runs the program.
     * @param args
     */
    public static void main(String[] args) {
        // Change this location if you need to.
       processFile("./src/fifa");
       printResults();

    }
   
   
    /**
     * Stores the information into the data structures.
     * @param age The age of the player.
     * @param position The position of the player.
     * @param nationality The nationality of the player.
     */
    private static void processLine(int age, String position, String nationality) {
    	// Part A
       ages.add(age);
       
       //Part B
       nationalities.add(nationality);
       
       //Part C
       positions.add(position);
       
       //Part E
       positionCount.put(position, positionCount.getOrDefault(position, 0) + 1);
       
       //Part F
       nationalityCount.put(nationality, nationalityCount.getOrDefault(nationality, 0));
       //Part F
       oldestPerNation.put(nationality, 
    		   oldestPerNation.getOrDefault(nationality, 0) < age ? age : oldestPerNation.get(nationality) );
       //Part G
       int count = 5 * (int)Math.ceil(age / 5.0);
       groupCount.put(count, groupCount.getOrDefault(count, 0) + 1);
       
       //Part H
       TreeSet<String> positions = positionToNation.getOrDefault(nationality, new TreeSet<String>());
       positions.add(position);
       positionToNation.put(nationality, positions);
       
    }
    
 
   
    /**
     * Prints the results of each exercise.
     * Each print has already been set-up with basic titles,
     * but you will need to add to the prints to get the correct results
     * from your data structures.
     */
    private static void printResults() {
        //A Determine the range of ages.
        //  Print all of the ages.
        //  What is the youngest age? What is the oldest age? (Use methods to find this)
        System.out.println("All ages: " + ages.toString());
        System.out.println("Youngest: " + ages.first());
        System.out.println("Oldest: " + ages.last());
        System.out.println();
       
       
        //B Determine the number of different nationalities.
        //  Print the nationalities in alphabetical order.
        //  Print the number of unique nationalities.
        System.out.println("All nationalities: " + nationalities.toString());
        System.out.println("Unique nationalities: " + nationalities.size());
        System.out.println();
       
        //C Determine the number of different positions.
        //  Print all of the positions, order is not relevant.
        //  Print the number of unique positions.
        System.out.println("All positions: " + positions.toString());
        System.out.println("Unique positions: " + positions.size());
        System.out.println();
       
       
        //D Wait for the lesson on Maps
       
       
        //E Determine the number of players per position. IE: GK (goalkeeper) may have 85 players.
        //  Print the results in any order.
        System.out.println("Position count: " + positionCount.toString());
        System.out.println();
     
        //F Determine the number of players per nation.
        //  Print the results in any alphabetical order.
        System.out.println("Nationality count: " + nationalityCount.toString());
        System.out.println();
       
        //F Determine the oldest player per nationality.
        //  Print the results in alphabetical order.
        System.out.println("Oldest per nation: " + oldestPerNation.toString());
        System.out.println();
       
        //G Determine the number of players per age group.
        //  We will define age groups by multiples of 5.
        //  For instance, anyone aged 16, 17, 18, 19, 20 is in group 20.
        //  Anyone aged 21, 22, 23, 24, 25 is in group 25.
        //  Etcetera. Want the math? ---> scroll right                                                                                                                                                                                              5 * (int)Math.ceil(age / 5.0)
        //  Print the results in numerical order by age (youngest group first).
        System.out.println("Age group count: " + groupCount.toString());
        System.out.println();
       
        //H Build a Map of Nationalities to Positions.
        //  Print each nation on its own individual line followed by all of the positions that nation has.
        //  Also print the nation which has the most unique number of positions and how many it has.
        
        System.out.println("All positions in each nation:");
        for (String key : positionToNation.keySet()) {
            System.out.println(key + ": " + positionToNation.get(key));
        }
       
        String str = "";
        int highest = 0;
        for (String key : positionToNation.keySet()) {
        	TreeSet<String> loc = positionToNation.get(key);
        	if (loc.size() > highest) {
        		highest = loc.size();
        		str = key;
        	}
        }
        System.out.println("Country with most positions: " + str + " (" + highest + ")");

    }
   
 
 
    /**
     * This method is finished as is.
     * Runs through the given file pulling out the age, position, and nationality.
     * For each of the inputs, it will call the processLine() method.
     * @param filename The location/name of the file to process.
     */
    private static void processFile(String filename) {        
        Scanner scan = null;
        try {
            scan = new Scanner( new File( filename ) );
            while ( scan.hasNext() ) {
                int age = scan.nextInt();
                String position = scan.next();
                String nationality = scan.nextLine().trim();
                processLine( age, position, nationality );
            }            
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            if ( scan != null ) {
                scan.close();
            }
        }
    }
}
 
 
/* Sample partial output
 
All ages: [16, 17, ..]
Youngest: _#_
Oldest:   _#_
 
All nationalities: [Afghanistan, Albania, ..]
Unique nationalities: _#_
 
All positions: [RS, LM, ..]
Unique positions: _#_
 
Position count: {RS=203, LM=1095, ..}
 
Nationality count: {Afghanistan=4, Albania=39, ..}
 
Oldest per nation: {Afghanistan=26, Albania=34, ..}
 
Age group count: {20=3318, ..}
 
All positions in each nation:
Afghanistan:[CAM, CM, LB, LM]
Albania:[CAM, CB, CDM, CM, GK, LB, LCM, LDM, LM, LW, RB, RCB, RCM, RM, RS, RW, ST]
...
Country with most positions: ______(_#_)
 
*/