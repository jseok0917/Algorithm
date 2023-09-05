import java.util.LinkedList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(4);
		list.add(2);
		
		
		list.add(1, 10);
		System.out.println(list.toString());
		
		
		
	}

}
