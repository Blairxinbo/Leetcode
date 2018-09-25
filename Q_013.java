class Q_013 {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        
        HashMap<Character, Integer> ValueMap = new HashMap<Character, Integer>();
        ValueMap.put('M' , 1000);
        ValueMap.put('D' , 500);
        ValueMap.put('C' , 100);
        ValueMap.put('L', 50);
        ValueMap.put('X', 10);
        ValueMap.put('V' , 5);
        ValueMap.put('I', 1);
        int sum = 0;
        
        char[] res = s.toCharArray();
        sum = ValueMap.get(res[0]);
        
        for(int i = 1; i < res.length; i++) {
            sum += ValueMap.get(res[i]);
            if(ValueMap.get(res[i]) > ValueMap.get(res[i-1])) {
                sum -= 2*ValueMap.get(res[i-1]);
            } 
        }
        return sum;
    }
}
