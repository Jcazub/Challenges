package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromicString {
    public static String myLongestPalindrome(String s) {
        Map<Character, List<Integer>> charMap = new HashMap<Character, List<Integer>>();
        int n = s.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            if (charMap.containsKey(s.charAt(i))) {
                List<Integer> occurenceList = charMap.get(s.charAt(i));
                // check if palindrome
                for (int l = 0; l < occurenceList.size(); l++) {
                    int j = occurenceList.get(l), k = i;
                    while (j < k) {
                        if (s.charAt(j) != s.charAt(k))
                        {
                            break;
                        }
                        j++;k--;
                    }
                    if (j >= k) ans = s.substring(occurenceList.get(l), i + 1).length() > ans.length() ? s.substring(occurenceList.get(l), i + 1) : ans;
                }
                List<Integer> currentList = charMap.get(s.charAt(i));
                currentList.add(i);
            } else {
                // add to hashmap
                List<Integer> newCharList = new ArrayList<Integer>();
                newCharList.add(i);
                charMap.put(s.charAt(i), newCharList);
            }
        }

        if (!s.isEmpty() && ans.equals("")) ans = String.valueOf(s.charAt(0));

        return ans;
    }

    public String optimalLongestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {
        System.out.println(LongestPalindromicString.myLongestPalindrome("baaobaabaaaboaab"));
        System.out.println(LongestPalindromicString.myLongestPalindrome("a    b"));
    }
}
