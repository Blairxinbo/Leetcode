class Q_017 {
    public List<String> letterCombinations(String digits) {
        String letter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) return res;
        
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            res = combine(letter[digits.charAt(i)-'0'], res);
        }
        return res;
    }
    
    public List<String> combine(String digits, List<String> l) {
        List<String> res = new ArrayList<String>();
        
        for (int i = 0; i < digits.length(); i++) {
            for (String x : l) {
                res.add(x+digits.charAt(i));
            }
        }
        return res;
    }
}
