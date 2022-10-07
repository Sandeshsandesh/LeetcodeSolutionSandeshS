package com.sign.problems.binary_search.nextgreatestletter_744;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] == target) {
                if (mid + 1 < letters.length && letters[mid+1] == target) {
                    high++;
                    continue;
                }
                return mid+1 >= letters.length ? letters[0] : letters[mid + 1];
            }
            if (target < letters[mid]) {
                high = mid - 1;
                if (high > 0 && target > letters[high]) {
                    return high+1 >= letters.length ? letters[0] : letters[high + 1];
                }
            } else {
                low = mid + 1;
                if (low < letters.length && target < letters[low]) {
                    return letters[low];
                }
            }
        }
        return low >= letters.length ? letters[0] : letters[low];

    }

    public char nextGreatestLetterEfficient(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target < letters[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return letters[low % letters.length];
    }

    public static void main(String[] args) {
        char[] input = {'c','f','j'};
        char target = 'g';

        NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
        char output = nextGreatestLetter.nextGreatestLetter(input, target);
        System.out.println(output);
        output = nextGreatestLetter.nextGreatestLetterEfficient(input, target);
        System.out.println(output);
    }
}