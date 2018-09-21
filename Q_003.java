class Q_003 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> res = new HashSet<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        int n = s.length();
        while (i < n && j < n) {
            if (!res.contains(s.charAt(j))) {
                res.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }else {
                res.remove(s.charAt(i++));
            }
        }
        return ans;
        
    }
}
