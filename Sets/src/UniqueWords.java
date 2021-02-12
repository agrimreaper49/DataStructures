import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UniqueWords {
	public static void main (String [] args) {
		System.out.println(uniqueWordsArray("input"));
		System.out.println(uniqueWordsHashSet("input"));
		System.out.println(hashSetFile());
		System.out.println(treeSetFile());
	}
	
	public static int uniqueWordsArray(String input) {
		boolean [] arr = new boolean [128];
		for (int i = 0; i < input.length(); i++) {
			arr[input.charAt(i)] = true;
		}
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]) {
				counter++;
			}
		}
		return counter;
	}
	
	public static int uniqueWordsHashSet(String input) {
		Set<Character> unique = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			unique.add(c);
		}
		return unique.size();
	}
	
	public static int hashSetFile() {
		Set<String> uniqueHash = new HashSet<>();
		try {
			Scanner fileReader = new Scanner(new File("./src/harryPotter"));
			while (fileReader.hasNext()) {
			    uniqueHash.add(fileReader.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return uniqueHash.size();
	}
	
	public static int treeSetFile() {
		Set<String> uniqueTree = new TreeSet<>();
		try {
			Scanner fileReader = new Scanner(new File("./src/harryPotter"));
			while (fileReader.hasNext()) {
			    uniqueTree.add(fileReader.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return uniqueTree.size();
	}
}
