package LeetCode;

public class ReverseInteger {

    public static int reverse(int x) {

        if (Math.abs(x) < 10) return x;

        StringBuilder intString = new StringBuilder(String.valueOf(x));
        StringBuilder intReverse = new StringBuilder();

        if (intString.charAt(0) == '-') {
            intReverse.append("-");
            intReverse.append(intString.reverse().substring(0,intString.length() - 1));
        } else {
            intReverse = intString.reverse();
        }

        int reverse;

        try {
            reverse = Integer.parseInt(intReverse.toString());
        } catch (NumberFormatException e) {
            reverse = 0;
        }

        return reverse;
    }

    public static void main(String[] args) {
        reverse(-2);
    }
}
