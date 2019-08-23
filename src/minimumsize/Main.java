package minimumsize;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		
		int s = 7;
		
		System.out.println("Input: " + Arrays.toString(nums));
		
		System.out.println("Sum Target: " + s);
		
		FindMinimumSizeSubarraySumFunction solution = new FindMinimumSizeSubarraySumFunction();
		
		System.out.println("Solution: " + solution.minSubArrayLen(s, nums));
	}
}
