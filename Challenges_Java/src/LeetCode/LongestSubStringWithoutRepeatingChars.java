package LeetCode;

import java.lang.StringBuilder;

class LongestSubStringWithoutRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
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

    public static void main(String[] args) {
        String s = " ";

        System.out.println(LongestSubStringWithoutRepeatingChars.lengthOfLongestSubstring(s));
    }
}