class Q_007 {
    public int reverse(int x) {
        boolean inegative = false;
        
        if (x < 0) {
            inegative = true;
            x = 0 - x;
        }
        
        long reverse = 0;
        while (x != 0) {

            if (reverse <= Integer.MAX_VALUE/10 && reverse >= Integer.MIN_VALUE/10 ) {
                 reverse = reverse * 10 + x % 10;
                 x /= 10;
            } else {
                return 0;
            }
        }
        
        return inegative ? (int)(0 - reverse) : (int)reverse;
    
    }
}
