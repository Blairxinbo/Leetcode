class Q_001 {
    public int[] twoSum(int[] nums, int target) {
        int sums = 0;
        
        for (int i=0; i < nums.length; i++) {
            for (int j=i+1; j <nums.length; j++) {
                sums = nums[i] + nums[j];
                if (nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
