package minimumsize;

public class FindMinimumSizeSubarraySumFunction {
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

		while (end < nums.length) {
			// Keep adding until the sum is s or greater
			sum += nums[end];
			end++;

			while (sum >= s) {
				min = Math.min(min, end - from);

				sum = sum - nums[from];
				from++;
			}
		}

		// If min == max_value, which mean the sum don't add up the the target
		if (min == Integer.MAX_VALUE) {
			return 0;
		} else {
			return min;
		}
	}
}
