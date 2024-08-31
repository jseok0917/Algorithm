package day_35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test01 {
	
	public static void main(String[] args) {
		
		int[] array = {1,3,5,7,9};
		List<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(5);
		list.add(1);
		list.add(7);
		list.add(3);
		
		Collections.sort(list, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1-o2;
			}
			
		});
		
		System.out.println(list.toString());
		
	
		
		
		
	}

}
