
public class Name implements Comparable<Name> {
	private String firstName;
	private String lastName;
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirst() {
		return firstName;
	}
	
	public String getLast() {
		return lastName;
	}
	
	public String toString() {
		return lastName + ", " + firstName;
	}
	
	public boolean equals(Name n) {
		String f = n.getFirst().toLowerCase();
		String l = n.getLast().toLowerCase();
		if (getFirst().toLowerCase().equals(f) && 
				getLast().toLowerCase().equals(l)) {
			return true;
		}
		return false;
	}
	
	public int hashCode() {
		int code = 0;
		for (int i = 0; i < getFirst().length(); i++) {
			char c = getFirst().charAt(i);
			code += Math.pow(c, c);
		}
		for (int k = 0; k < getLast().length(); k++) {
			char f = getLast().charAt(k);
			code += Math.pow(f, f);
		}
		return code;
	}
	
	@Override
	public int compareTo(Name o) {
		return getLast().compareTo(o.getLast());
	}

}
