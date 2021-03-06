class Q_031 {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        //find the first smallest element from the end of lists
        while(i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }

        //find the first element which is smaller than i, swap them
        if(i >= 0) {
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length-1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}