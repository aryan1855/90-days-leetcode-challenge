class Solution {
    public boolean uniformArray(int[] nums1) {

        int min = Integer.MAX_VALUE;

        // Find the minimum element
        for (int num : nums1) {
            min = Math.min(min, num);
        }

        // If minimum is odd, we can make all elements odd
        if (min % 2 != 0) {
            return true;
        }

        // If minimum is even, all elements must already be even
        for (int num : nums1) {
            if (num % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}