import java.util.*;

public class TestClass {
	private int eye;
	public static void main (String [] args) {
		test1();
	}
	public TestClass(String str) {
		eye = 0;
	}
	public static boolean test() {
		String str = "";
		String ss = "";
		return str.equals(ss);
	}
	public static void test1() {
		Set<TestClass> values = new HashSet<>();
		List<TestClass> vals = new ArrayList<>();
		TestClass t = new TestClass("sdf");
		TestClass v = new TestClass("sdf");
		values.add(t);
		values.add(v);
		vals.add(t);
		vals.add(v);
		
		System.out.println(values);
		System.out.println(vals);

	}
}
