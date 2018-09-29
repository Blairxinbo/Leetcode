class Q_022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) return res;
        backtrack(res, "", n, n);
        return res;
    }
    public static void backtrack(List<String> res, String s, int left, int right) {
        if(left > right) return;
        if(left == 0 && right == 0) {
            res.add(s);
            return;
        }


        if(left > 0) {
            backtrack(res, s+"(", left-1, right);
        }
        if(right > 0) backtrack(res, s+")", left, right-1);


    }
}