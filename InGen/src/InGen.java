import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InGen {
	private TreeSet<Name> names = new TreeSet<>();
	public static void main(String [] args) {
		
	}
	
	public int readUniqueNames() {
		try {
			Scanner fileReader = new Scanner(new File("./src/names"));
			while (fileReader.hasNext()) {
				String s = fileReader.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
