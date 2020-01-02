package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubString {

    public static int myLengthOfLongestSubstring(String s) {
        int maxCount = 0;
        int count = 0;
        StringBuilder compareString = new StringBuilder(s);
        StringBuilder builtString = new StringBuilder();
        int i = 0;

        while (i < compareString.length()) {
            if (builtString.indexOf(String.valueOf(compareString.charAt(i))) != -1) {
                i = compareString.indexOf(String.valueOf(compareString.charAt(i))) + 1;
                if (i < compareString.length()) {
                    compareString = new StringBuilder(compareString.substring(i));
                }
                i = 0;
                count = 0;
                builtString = new StringBuilder();
            } else {
                builtString.append(compareString.charAt(i));
                count++;
                ++i;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

    public static int lengthOfLongestSubstringSlidingWindow(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstringSlidingWindowOptimized(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLongestSubString.lengthOfLongestSubstringSlidingWindowOptimized("abcdcd");
    }

}
