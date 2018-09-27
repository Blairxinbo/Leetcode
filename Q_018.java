class Q_018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }

    private List<List<Integer>> kSum (int[] nums, int start, int k, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (k == 2) {
            int l = start , r = nums.length-1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else if (sum == target) {
                    List<Integer> curr = new ArrayList<Integer>();
                    curr.add(nums[l]);
                    curr.add(nums[r]);
                    res.add(curr);
                    while(l < r && nums[l] == nums[l+1]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                } else {
                    r--;
                }
            }
        } else {
            for (int i = start; i < nums.length-(k-1); i++) {
                if (i > start && nums[i] == nums[i-1]) continue;
                List<List<Integer>> temp = kSum (nums, i+1, k-1, target-nums[i]);
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
        }
        return res;
    }
}