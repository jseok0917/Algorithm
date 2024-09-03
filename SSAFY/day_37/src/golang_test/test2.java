package golang_test;

import java.util.*;

public class test2 {
	
	public static void main(String[] args) {
		
		System.out.println(pow(3,2,20) + " " + pow(3,3,20));
		
	}
	
	public static double pow(double x, double n, double lim) {
		
		double v = Math.pow(x, n);
		
		if (v < lim) {
			return v;
		} else {
			System.out.printf("%g >= %g\n", v, lim);
		}
		
		
		return lim;
	}

}
