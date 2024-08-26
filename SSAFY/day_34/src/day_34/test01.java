package day_34;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test01 {
	
	public static void main(String[] args) {
		
		String[] t = {"B", "C", "D", "A"};
		
		List<String> test = Arrays.asList(t);
		
		System.out.println(test);
		
		test.sort(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				String a1 = (String) o1;
				String a2 = (String) o2;
				
				char c1 = a1.charAt(0);
				char c2 = a2.charAt(0);
				return c1-c2;
			}
			
		});
		
		
		System.out.println(test);
		
		
	}

}
