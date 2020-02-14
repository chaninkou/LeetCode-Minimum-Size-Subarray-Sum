package minimumsize;

public class FindMinimumSizeSubarraySumFunction {
	// Sliding window methods, o(N) since end and from pointers will move n times = O(N + N) worst case 
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		// We will start from 0 index
		int from = 0;
		int end = 0;

		// Sum will be 0 at first
		int sum = 0;

		// We do max_value since any number will be the smallest
		int min = Integer.MAX_VALUE;

		// move end pointer until we find a sum of s or greater
		while (end < nums.length) {
			sum += nums[end];
			end++;

			// Once we find it, get the length and compare to the min, move the from pointer now
			while (sum >= s) {
				min = Math.min(min, end - from);

				sum = sum - nums[from];
				from++;
			}
		}

		// If min == max_value, which mean the sum don't add up the the target
		// edge case if min does add up to max_value, use a boolean instead
		if (min == Integer.MAX_VALUE) {
			return 0;
		} else {
			return min;
		}
	}
}
