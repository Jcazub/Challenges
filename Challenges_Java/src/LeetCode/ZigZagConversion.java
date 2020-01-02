package LeetCode;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {

        int slength = s.length();
        if (slength <= numRows || numRows < 2) return s;

        int dividend = (numRows + (numRows - 2)), numCols;
        if (dividend < 1) {
            numCols = 1;
        } else {
            numCols = (int) Math.ceil((slength * (numRows - 1))/ (double) (numRows + (numRows - 2)));
        }
        int zigCounterMax = numRows - 2, zigCounter = 0;
        char[][] zigMatrix = new char[numRows][numCols];
        int r = 0, c = 0, i = 0;

        while (r < numRows && c < numCols && i < slength) {
            if (zigCounter == 0) {
                zigMatrix[r++][c] = s.charAt(i++);
            } else {
                if (r == zigCounter) {
                    zigMatrix[r++][c] = s.charAt(i++);
                } else {
                    r++;
                    //zigMatrix[r++][c] = ' ';
                }
            }

            if (r == numRows) {
                r = 0;
                c++;
                if (zigCounter == 0) {
                    zigCounter = zigCounterMax;
                } else {
                    zigCounter--;
                }
            }
        }

        StringBuilder output = new StringBuilder();

        for (char[] innerCharArray : zigMatrix) {
            for (char currentChar : innerCharArray) {
                if (currentChar != 0) output.append(currentChar);
            }
        }

        return output.toString();
    }

    public static String myBetterConvert(String s, int numRows) {

        int slength = s.length(), newWordCount = 0, row = 0, currentIndex = 0;

        // calc skipFactor, used to generate new zigzagged String
        int skipFactor = (numRows * 2) - 2;
        if (skipFactor < 1) skipFactor = 1;


        StringBuilder sb = new StringBuilder();

        // loop through for every entry in the new word
        while (newWordCount < slength) {

            sb.append(s.charAt(currentIndex));

            if (row != 0 && row != (numRows - 1)) {
                // add extra entry
                int extraEntryIndex = currentIndex + (skipFactor - (row * 2));
                if (extraEntryIndex <= slength - 1) {
                    sb.append(s.charAt(extraEntryIndex));
                    newWordCount++;
                }

            }

            currentIndex += skipFactor;
            newWordCount++;

            if (currentIndex > slength - 1) {
                row++;
                currentIndex = row;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(myBetterConvert("ABCD", 3));
    }
}
