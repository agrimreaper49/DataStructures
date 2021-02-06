import java.util.*;

public class UniqueWords {
	public static void main (String [] args) {
		final long START = System.currentTimeMillis();
		// Do something
		System.out.println(uniqueWordsArray("Aardvark")) ;
		System.out.println(uniqueWordsHashSet("Aardvark")) ;
		final long END = System.currentTimeMillis();
		System.out.println("Total execution time: " + (END - START));

	}
	
	public static int uniqueWordsArray(String input) {
		boolean [] arr = new boolean [128];
		for (int i = 0; i < input.length(); i++) {
			arr[input.charAt(i)]  = true;
		}
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == true) {
				counter++;
			}
		}
		return counter;
	}
	
	public static int uniqueWordsHashSet(String input) {
		Set<String> unique = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			String s = input.charAt(i) + "";
			unique.add(s);
		}
		return unique.size();
	}
}
