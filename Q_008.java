class Q_008 {
    public int myAtoi(String str) {
        //remove whitespace
        str = str.trim();
        if(str == null || str.length() < 1) return 0;
        
        boolean isnegative = false;
        int first = 0;
        // decide the signs
        if(str.charAt(0) == '-') {
            isnegative = true;
            first++;
        } else if (str.charAt(0) == '+') {
            first++;
        }
        
        double res = 0;
        for (int i = first; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <='9') {
                res = res * 10 + (str.charAt(i) - '0');
            } else {
                break;
            }
        }
        
        if (isnegative) {
            res = 0 - res;
        }
        
        //check the boundary
        if(res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else 
            return (int)res;
        
    }
}
