import java.util.*;
class main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        int par = cache.get(1);
        cache.put(3,3);
        cache.get(2);

        System.out.println(par);
    }
}

