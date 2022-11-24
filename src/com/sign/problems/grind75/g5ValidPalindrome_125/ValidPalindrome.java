package com.sign.problems.grind75.g5ValidPalindrome_125;

// https://leetcode.com/problems/valid-palindrome/

public class ValidPalindrome {
    public Boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        int i = 0;
        int j = input.length() - 1;

        while (i < j) {
            char charAtI = input.charAt(i);
            char charAtJ = input.charAt(j);
            if ((charAtI < 'a' || charAtI > 'z') && (charAtI < 'A' || charAtI > 'Z')) {
                i++;
                continue;
            }  // valid


            if ((charAtJ < 'a' || charAtJ > 'z') && (charAtJ < 'A' || charAtJ > 'Z')) {
                j--;
                continue;
            }  // valid

            if (charAtI == charAtJ) {
                i++;
                j--;
                continue;
            }

            // invert charAtI
            if (charAtI >= 'a') {
                charAtI -= 32;
            } else {
                charAtI += 32;
            }
            if (charAtI == charAtJ) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome palindrome = new ValidPalindrome();
        String input =  "A man, a plan, a canal: Panama";
        System.out.println(palindrome.isPalindrome(input));

        String wrongInput = "race a car";
        System.out.println(palindrome.isPalindrome(wrongInput));

    }

}
