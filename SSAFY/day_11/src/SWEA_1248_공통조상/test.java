package SWEA_1248_공통조상;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class test {
	public static void main(String[] args) {
		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		System.out.println(map.getOrDefault(1, null));
		
		System.out.println(null == null);
	}

}
