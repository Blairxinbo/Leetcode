class Q_029 {
    public int divide(int dividend, int divisor) {
        boolean isNeg = (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0);
        long up = Math.abs((long) dividend);
        long down = Math.abs((long) divisor);

        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;

        long res = 0, cur = 1;
        long sub = down;

        while(up >= down) {
            if(up >= sub) {
                res += cur;
                up -= sub;
                sub = sub << 1;
                cur = cur << 1;
            } else {
                sub = sub >> 1;
                cur = cur >> 1;
            }
        }
        return isNeg ? (int)-res : (int)res;
    }
}