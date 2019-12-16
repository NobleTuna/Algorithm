package bj16235;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		int arr[][][] = { { { 3, 1, 5, 7, 9 } } };
		
		Arrays.sort(arr[0][0]);
		
		
		for(int i=0; i<arr[0][0].length; i++) {
			System.out.println(arr[0][0][i]);
		}
	}

}
