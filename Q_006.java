class Q_006 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int cycle = 2*numRows - 2;
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i< s.length(); j+=cycle) {
                res.append(s.charAt(j+i));
                if(i != 0 && i != numRows-1 && j+cycle-i<s.length()) {
                    res.append(s.charAt(j+cycle-i));
                }
            }
        }
        return res.toString();
    }
}
