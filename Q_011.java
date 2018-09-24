class Q_011 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        
        while (right >= left) {
            if (height[left] <= height[right]) {
                area = Math.max(area, height[left] * (right-left));
                left++;
            } else if (height[left] >= height[right]) {
                area = Math.max(area, height[right] *(right-left));
                right--;
            }
        }
    return area;
    }
}
