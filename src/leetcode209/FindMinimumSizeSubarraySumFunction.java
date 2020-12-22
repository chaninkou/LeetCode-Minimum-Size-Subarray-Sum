package leetcode209;

public class FindMinimumSizeSubarraySumFunction {
	// Sliding window methods, o(N) since end and from pointers will move n times = O(N + N) worst case 
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int from = 0;
		int end = 0;

		int sum = 0;

		int min = Integer.MAX_VALUE;

		// move end pointer until we find a sum of s or greater
		while (end < nums.length) {
			sum += nums[end];
			
			// Because of this, end is always an element bigger than start
			// That's why end - from will at least get 1
			end++;

			// Move from's pointer to get the min of the window
			while (sum >= s) {
				min = Math.min(min, end - from);

				sum = sum - nums[from];
				from++;
			}
		}
		
		// Same thing, but this doesn't use math.min
		// end - from + 1 because it did not end++ before while loop
//        while (end < nums.length)
//        {
//            sum += nums[end];
//            while (sum >= s)
//            {
//                if (end - from + 1 < min)
//                {
//                	min = end - from + 1;
//                }
//                sum -= nums[from];
//                from++;
//            }
//            end++;
//        }

		// If min == max_value, which mean the sum don't add up the the target
		// edge case if min does add up to max_value, use a boolean instead
		if (min == Integer.MAX_VALUE) {
			return 0;
		} else {
			return min;
		}
	}
}
