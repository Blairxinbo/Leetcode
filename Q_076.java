import javafx.util.Pair;  //create a pair like hashmap to get the key and value
import java.util.HashMap;
import java.util.Map;
import java.util.*;

class Q_076 {
    public String window (String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return "";
        }
        // S = "abcdefg", T = "abc"
        //direct the index of the character of S
        HashMap<Character, Integer> dic = new HashMap<Character, Integer>();

        // iterate all characters to transfer a String to a map for T, count can remember how many times the character is added
        for (int i = 0; i < T.length(); i++) {
            //intial the value of all char
            int count = dic.getOrDefault(T.charAt(i), 0);
            dic.put(T.charAt(i), count+1);
        }

        //filter all the characters from S into a new list along with their index
        List<Pair<Integer, Character>> filterL = new ArrayList<Pair<Integer, Character>>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            //check if char of T in the S list
            if (dic.containsKey(c)) {
                filterL.add(new Pair<Integer, Character>(i,c)); //Pair(key, value)
            }
        }

        int left = 0, right = 0;
        int curr = 0;
        int[] intial = {-1, 0, 0};
        HashMap<Character, Integer> windowcount = new HashMap<Character, Integer>();

        //filter the characters of S which is not in the T
        while (right < filterL.size()) {
            char c = filterL.get(right).getValue();
            int count = windowcount.getOrDefault(c, 0);
            windowcount.put(c, count+1);

            //if the freq of the current character added equals to the desired count in T then increment the formed count by 1
            if (dic.containsKey(c) && windowcount.get(c).intValue() == dic.get(c).intValue()) {
                curr++; //move the right pointer
            }



            //move the left pointer to contract the window
            while (left <= right && curr == dic.size()) {
                c = filterL.get(left).getValue();

                //save the smallest window until now
                int end = filterL.get(right).getKey();
                int start = filterL.get(left).getKey();
                if (intial[0] == -1 || end - start + 1 < intial[0]) {
                    intial[0] = end - start + 1;
                    intial[1] = start;
                    intial[2] = end;
                }
                // move the character that left pointer point it.
                windowcount.put(c, windowcount.get(c) - 1);

                if (dic.containsKey(c) && windowcount.get(c).intValue() < dic.get(c).intValue()) {
                    curr--;
                }
                left++;
            }
            right++;
        }
        return intial[0] == -1 ? "" : S.substring(intial[1], intial[2]+1);
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String res = new Q_076().window(S,T);
        System.out.println(res);
    }
}