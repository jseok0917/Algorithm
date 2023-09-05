package BOJ_17471_게리맨더링;

import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> universe = new ArrayList<>();
		
		universe.add(1);
		universe.add(6);
		universe.add(7);
		universe.add(8);
		universe.add(9);
		universe.add(12);
		universe.add(17);
		universe.add(31);
		universe.add(35);
		
		list.add(-11);
		list.add(-15);
		list.add(-17);
		list.add(-12);
		list.add(-155);
		list.add(-122);
		list.add(-133);
		
		System.out.println(universe.toString());
		System.out.println(list.toString());
		
		universe.addAll(list);
		System.out.println(universe.toString());
		
		universe.removeAll(list);
		System.out.println(universe.toString());
		
		
		
	}

}
