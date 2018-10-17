class Q_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //convert int[] to List<Integer>
        List<Integer> nums = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Collections.sort(nums, (a,b) -> a == b ? a-b : Math.abs(a-x)-Math.abs(b-x));
        nums = nums.subList(0,k);
        Collections.sort(nums);
        return nums;
    }
}