package leetCodeSolutions;

import java.util.Arrays;

public class removeDuplicatesArray {
	
	public static void main(String[] args) {
		int[] newnew = {1,2,2,4,6,7,8,8,10};
		removeDuplicates(newnew);
		System.out.println(Arrays.toString(newnew));
	}
	
	public static int removeDuplicates(int[] arr) {
		int endBuffer = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			int temp = arr[i];
			if(arr[i+1] == temp) {
				endBuffer++;
				swapToEnd(arr, i);
				
			}
		}
		int output = arr.length - endBuffer;
		System.out.println(output);
		return output;
	}

	private static void swapToEnd(int[] arr, int i) {
		int counter = i;
		while(counter != arr.length - 1) {
			swap(arr, counter, counter+1);
			counter++;
		}
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
