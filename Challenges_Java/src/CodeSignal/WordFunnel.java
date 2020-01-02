package CodeSignal;

public class WordFunnel {

    /*
    Given two strings of letters, determine whether the second can be made from the first by removing one letter. The remaining letters must stay in the same order.

    funnel("leave", "eave") => true
    funnel("reset", "rest") => true
    funnel("dragoon", "dragon") => true
    funnel("eave", "leave") => false
    funnel("sleet", "lets") => false
    funnel("skiff", "ski") => false
     */

    public static void main(String[] args) {
        WordFunnel funnel = new WordFunnel();

        System.out.println(funnel.funnel("leave", "eave"));
        System.out.println(funnel.funnel("reset", "rest"));
        System.out.println(funnel.funnel("dragoon", "dragon"));
        System.out.println(funnel.funnel("eave", "leave"));
        System.out.println(funnel.funnel("sleet", "lets"));
        System.out.println(funnel.funnel("skiff", "ski"));
    }

    public static Boolean funnel(String firstWord, String secondWord) {
        String[] firstWordSplit = firstWord.split("");
        for (int i = 0; i < firstWordSplit.length; i++) {
            String testWord = "";

            for (int j = 0; j < firstWordSplit.length; j++) {
                if (i != j) {
                    testWord += firstWordSplit[j];
                }
            }

            if (testWord.equals(secondWord)) {
                return true;
            }
        }

        return false;
    }

}
