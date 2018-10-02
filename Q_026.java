class Q_026 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int first_num = nums[0];

        int j = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == first_num) {
                continue;
            } else {
                first_num = nums[i];
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}